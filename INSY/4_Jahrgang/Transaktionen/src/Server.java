
import java.io.*;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.*;
import org.json.*;
import java.sql.*;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * INSY Webshop Server
 */
public class Server {

    /**
     * Port to bind to for HTTP service
     */
    private int port = 8000;

    /**
     * Connect to the database
     * @throws IOException
     */
    Connection setupDB()  {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Properties dbProps = new Properties();
        try {
            dbProps.load(new FileInputStream(rootPath + "db.properties"));
            return DriverManager.getConnection(dbProps.getProperty("url"), dbProps);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Startup the Webserver
     * @throws IOException
     */
    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/articles", new ArticlesHandler());
        server.createContext("/clients", new ClientsHandler());
        server.createContext("/placeOrder", new PlaceOrderHandler());
        server.createContext("/orders", new OrdersHandler());
        server.createContext("/order", new OrderHandler());
        server.createContext("/stats", new StatsHandler());
        server.createContext("/", new IndexHandler());

        // Default executor serializes all incoming requests and can
        // therefore not be used to demonstrate isolation levels and locks
        ExecutorService executor = Executors.newCachedThreadPool();
        server.setExecutor(executor);

        server.start();
    }


    public static void main(String[] args) throws Throwable {
        Server webshop = new Server();
        webshop.start();
        System.out.println("Webshop running at http://127.0.0.1:" + webshop.port);
    }


    /**
     * Handler for listing all articles
     */
    class ArticlesHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            Connection conn = setupDB();

            JSONArray res = new JSONArray();
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT id, description, price, amount FROM articles");
                while (rs.next())
                {
                    JSONObject art = new JSONObject();
                    art.put("id", rs.getInt(1));
                    art.put("description", rs.getString(2));
                    art.put("price", (rs.getInt(3)+0.0f)/100);
                    art.put("amount", rs.getString(4));
                    res.put(art);
                }
                rs.close();
                st.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            answerRequest(t,res.toString());
        }

    }

    /**
     * Handler for listing all clients
     */
    class ClientsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            Connection conn = setupDB();

            JSONArray res = new JSONArray();
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT id, name, address FROM clients");
                while (rs.next())
                {
                    JSONObject cli = new JSONObject();
                    cli.put("id", rs.getInt(1));
                    cli.put("name", rs.getString(2));
                    cli.put("address", rs.getString(3));
                    res.put(cli);
                }
                rs.close();
                st.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

           answerRequest(t,res.toString());
        }

    }


    /**
     * Handler for listing all orders
     */
    class OrdersHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            Connection conn = setupDB();

            JSONArray res = new JSONArray();
            try {
                Statement st = conn.createStatement();
                String query = "SELECT o.id, c.name, count(*), sum(l.amount * a.price) " +
                        "FROM orders o, clients c, order_lines l, articles a " +
                        "WHERE l.article_id = a.id and l.order_id = o.id and o.client_id = c.id " +
                        "GROUP BY o.id, c.name";
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    JSONObject ord = new JSONObject();
                    ord.put("id", rs.getInt(1));
                    ord.put("client", rs.getString(2));
                    ord.put("lines", rs.getString(3));
                    ord.put("price", rs.getFloat(4)  / 100);
                    res.put(ord);
                }
                rs.close();
                st.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            answerRequest(t, res.toString());

        }
    }

    /**
     * Handler for viewing an order
     */
    class OrderHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            Map <String,String> params  = queryToMap(t.getRequestURI().getQuery());
            Connection conn = setupDB();
            String response = "";

            JSONObject res = new JSONObject();
            try {
                String query = "SELECT o.id, c.name, count(*), sum(l.amount * a.price) " +
                        "FROM orders o, clients c, order_lines l, articles a " +
                        "WHERE o.id = ? and l.article_id = a.id and l.order_id = o.id and o.client_id = c.id " +
                        "GROUP BY o.id, c.name";

                PreparedStatement st = conn.prepareStatement(query);

                st.setInt(1,Integer.parseInt(params.get("order_id")));
                ResultSet rs = st.executeQuery();

                if (!rs.next())
                    throw new IllegalArgumentException();
                res.put("id", rs.getInt(1));
                res.put("client", rs.getString(2));
                res.put("lines", rs.getString(3));
                res.put("price", rs.getFloat(4)  / 100);
                rs.close();

                String query2 = "SELECT a.description, l.amount, a.price*l.amount " +
                        "FROM   order_lines l, articles a " +
                        "WHERE l.order_id = ? and l.article_id = a.id";
                PreparedStatement st2 = conn.prepareStatement(query2);
                st2.setInt(1,Integer.parseInt(params.get("order_id")));
                ResultSet rs2 = st2.executeQuery();

                JSONArray resLines = new JSONArray();
                while (rs2.next()) {
                    JSONObject line = new JSONObject();
                    line.put("description", rs2.getString(1));
                    line.put("amount", rs2.getInt(2));
                    line.put("price", rs2.getFloat(3)/100);
                    resLines.put(line);
                }
                res.put("lines",resLines);
                rs2.close();
                st.close();

                response = res.toString();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (Exception e) {
                response = "{\"error\":\"Order not found.\"}";

            }

            answerRequest(t, response);
        }

    }

    /**
     * Handler class to place an order
     */
    class PlaceOrderHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            System.out.printf("Placing order using thread %s / %d%n", Thread.currentThread().getName(), Thread.currentThread().getId());
            Connection conn = setupDB();
            Map <String,String> params  = queryToMap(t.getRequestURI().getQuery());

            int client_id = Integer.parseInt(params.get("client_id"));

            String response = "";
            int order_id = 1;
            try {
                Statement st1 = conn.createStatement();

                // Get the next free order id
                ResultSet rs1 = st1.executeQuery("SELECT MAX(id)+1 from orders");
                if (rs1.next())
                    order_id = rs1.getInt(1);

                // Just to demonstrate a possible race condition
                sleep(5);

                // Create order
                PreparedStatement st2 = conn.prepareStatement("INSERT INTO orders (id, client_id) VALUES (?,?)");
                st2.setInt(1, order_id);
                st2.setInt(2, client_id);
                st2.executeUpdate();

                for (int i = 1; i <= (params.size()-1) / 2; ++i ){
                    int article_id = Integer.parseInt(params.get("article_id_"+i));
                    int amount = Integer.parseInt(params.get("amount_"+i));

                    PreparedStatement stGetAmount = conn.prepareStatement("SELECT amount FROM articles WHERE id = ?");
                    stGetAmount.setInt(1, article_id);
                    ResultSet rsAmount = stGetAmount.executeQuery();
                    if (!rsAmount.next())
                        throw new IllegalArgumentException("Article does not exist");
                    int available = rsAmount.getInt(1);

                    // Simulate some slow task here like warehouse lookup for available items.
                   sleep(5);

                    if (available < amount)
                        throw new IllegalArgumentException(String.format("Not enough items of article #%d available", article_id));

                    PreparedStatement stSetAmount = conn.prepareStatement("UPDATE articles SET amount = amount - ? WHERE id = ?");
                    stSetAmount.setInt(1, amount);
                    stSetAmount.setInt(2, article_id);
                    stSetAmount.executeUpdate();

                    // Simulate a possible general random error
                    if(Math.random() > 0.95){
                        throw new RuntimeException();
                    }

                    PreparedStatement stInsert = conn.prepareStatement("INSERT INTO order_lines (order_id,article_id,amount) VALUES (?,?,?)");
                    stInsert.setInt(1, order_id);
                    stInsert.setInt(2, article_id);
                    stInsert.setInt(3, amount);
                    stInsert.executeUpdate();
                }

                response = String.format("{\"order_id\": %d}", order_id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (IllegalArgumentException iae) {
                response = String.format("{\"error\":\"%s\"}", iae.getMessage());
            }

            answerRequest(t, response);

            System.out.printf("Finished placing order using thread %s / %d%n", Thread.currentThread().getName(), Thread.currentThread().getId());
        }
    }

    /**
     * Handler for listing static index page
     */
    class IndexHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "<!doctype html>\n" +
                    "<html><head><title>INSY Webshop</title><link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/water.css@2/out/water.css\"></head>" +
                    "<body><h1>INSY Pseudo-Webshop</h1>" +
                    "<h2>Verf&uuml;gbare Endpoints:</h2><dl>"+
                    "<dt>Bestellstatistiken anzeigen:</dt><dd><a href=\"http://127.0.0.1:"+port+"/stats\">http://127.0.0.1:"+port+"/stats</a></dd>"+
                    "<dt>Alle Artikel anzeigen:</dt><dd><a href=\"http://127.0.0.1:"+port+"/articles\">http://127.0.0.1:"+port+"/articles</a></dd>"+
                    "<dt>Alle Bestellungen anzeigen:</dt><dd><a href=\"http://127.0.0.1:"+port+"/orders\">http://127.0.0.1:"+port+"/orders</a></dd>"+
                    "<dt>Details zu Bestellung anzeigen:</dt><dd><a href=\"http://127.0.0.1:"+port+"/order?order_id=<order_id>\">http://127.0.0.1:"+port+"/order?order_id=&lt;order_id></a></dd>"+
                    "<dt>Alle Kunden anzeigen:</dt><dd><a href=\"http://127.0.0.1:"+port+"/clients\">http://127.0.0.1:"+port+"/clients</a></dd>"+
                    "<dt>Bestellung abschicken:</dt><dd><a href=\"http://127.0.0.1:"+port+"/placeOrder?client_id=<client_id>&article_id_1=<article_id_1>&amount_1=<amount_1&article_id_2=<article_id_2>&amount_2=<amount_2>\">http://127.0.0.1:"+port+"/placeOrder?client_id=&lt;client_id>&article_id_1=&lt;article_id_1>&amount_1=&lt;amount_1>&article_id_2=&lt;article_id_2>&amount_2=&lt;amount_2></a></dd>"+
                    "</dl></body></html>";

            answerRequest(t, response);
        }

    }

    /**
     * Handler for some statistics about clients and orders
     */
    class StatsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {

            Connection conn = setupDB();
            JSONObject res = new JSONObject();

            JSONArray overview = new JSONArray();

            Statement st = null;
            try {
                st = conn.createStatement();

                // Get overview of orders by country
                ResultSet rs = st.executeQuery(("SELECT c.country, count(distinct c.id), count(distinct o.id) " +
                        "FROM clients c, orders o " +
                        "WHERE c.id = o.client_id " +
                        "GROUP BY country"));

                // Simulate some very complicated calculations here
                sleep(15);

                while (rs.next()) {
                    JSONObject c = new JSONObject();
                    String country = rs.getString(1);
                    c.put("country", country);
                    c.put("num_clients", rs.getInt(2));
                    c.put("num_orders", rs.getInt(3));
                    overview.put(c);

                    // Get detailed list of each order for the country
                    JSONArray orders = new JSONArray();
                    PreparedStatement stDetail = conn.prepareStatement("SELECT c.name, o.id, count(*), sum(l.amount * a.price) " +
                            "FROM clients c, orders o, order_lines l, articles a " +
                            "WHERE a.id = l.article_id and c.id = o.client_id and o.id = l.order_id and c.country = ?" +
                            "GROUP BY o.id, c.name");
                    stDetail.setString(1, country);
                    ResultSet rs2 = stDetail.executeQuery();
                    while (rs2.next()){
                        JSONObject o = new JSONObject();
                        o.put("client", rs2.getString(1));
                        o.put("id",rs2.getInt(2));
                        o.put("lines",rs2.getInt(3));
                        o.put("price",rs2.getFloat(4)/100);
                        orders.put(o);
                    }
                    res.put(country,orders);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            res.put("overview",overview);

            answerRequest(t,res.toString());
        }
    }

    /**
     * Helper function to send an answer given as a String back to the browser
     * @param t HttpExchange of the request
     * @param response Answer to send
     * @throws IOException
     */
    private void answerRequest(HttpExchange t, String response) throws IOException {
        byte[] payload = response.getBytes();
        t.sendResponseHeaders(200, payload.length);
        OutputStream os = t.getResponseBody();
        os.write(payload);
        os.close();
    }

    /**
     * Helper method to parse query paramaters
     * @param query
     * @return
     */
    public static Map<String, String> queryToMap(String query){
        Map<String, String> result = new HashMap<String, String>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length>1) {
                result.put(pair[0], pair[1]);
            }else{
                result.put(pair[0], "");
            }
        }
        return result;
    }

    /**
     * Helper method to simulate calculations in order to provoke race conditions
     * @param secs Time to sleep in seconds
     */
    public static void sleep(int secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
