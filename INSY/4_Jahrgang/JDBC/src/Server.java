
import java.io.*;
import java.net.InetSocketAddress;
import java.util.*;
import org.json.*;
import java.sql.*;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import javax.swing.plaf.nimbus.State;

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
            return DriverManager.getConnection(dbProps.getProperty("url"),dbProps.getProperty("user"), dbProps.getProperty("password"));
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
        server.createContext("/", new IndexHandler());

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

            //TODO read all articles and add them to res

            try {
                Statement st = conn.createStatement();
                ResultSet result = st.executeQuery("SELECT * FROM articles");

                while(result.next()) {
                    res.put(new JSONObject()
                            .put("id", result.getInt("id"))
                            .put("description", result.getString("description"))
                            .put("price", result.getInt("price"))
                            .put("amount", result.getInt("amount")));
                }
            } catch (SQLException | JSONException e) {
                throw new RuntimeException(e);
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

            //TODO read all articles and add them to res

            try {
                Statement st = conn.createStatement();
                ResultSet result = st.executeQuery("SELECT * FROM clients");

                while(result.next()) {
                    res.put(new JSONObject()
                            .put("id", result.getInt("id"))
                            .put("name", result.getString("name"))
                            .put("address", result.getString("address"))
                            .put("city", result.getString("city"))
                            .put("country", result.getString("country")));
                }
            } catch (SQLException | JSONException e) {
                throw new RuntimeException(e);
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

            //TODO read all orders and add them to res
            // Join orders with clients, order lines, and articles
            // Get the order id, client name, number of lines, and total prize of each order and add them to res

            try {
                Statement st = conn.createStatement();
                ResultSet result = st.executeQuery("SELECT o.id AS order_id, c.name AS client_name, COUNT(ol.id) AS number_of_lines, SUM(a.price) AS total_price FROM orders o INNER JOIN clients c ON o.client_id=c.id INNER JOIN order_lines ol ON ol.order_id=o.id INNER JOIN articles a ON ol.article_id=a.id GROUP BY o.id, c.name");

                while(result.next()) {
                    res.put(new JSONObject()
                            .put("order_id", result.getInt("order_id"))
                            .put("client_name", result.getString("client_name"))
                            .put("number_of_lines", result.getInt("number_of_lines"))
                            .put("total_price", result.getInt("total_price")));
                }
            } catch (SQLException | JSONException e) {
                throw new RuntimeException(e);
            }

            answerRequest(t, res.toString());
        }
    }

   
    /**
     * Handler class to place an order
     */
    class PlaceOrderHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {

            Connection conn = setupDB();
            Map <String,String> params  = queryToMap(t.getRequestURI().getQuery());

            int client_id = Integer.parseInt(params.get("client_id"));

            String response = "";
            int order_id;
            try {


                //TODO Get the next free order id
                Statement st = conn.createStatement();
                ResultSet result = st.executeQuery("SELECT MAX(id) as max_id FROM orders");
                result.next();
                order_id = result.getInt("max_id")+1;

                //TODO Create a new order with this id for client client_id
                PreparedStatement insertOrder = conn.prepareStatement("INSERT INTO orders (id, created_at, client_id) VALUES (?, current_timestamp, ?)");
                insertOrder.setInt(1, order_id);
                insertOrder.setInt(2, client_id);
                insertOrder.execute();


                for (int i = 1; i <= (params.size()-1) / 2; ++i ){
                    int article_id = Integer.parseInt(params.get("article_id_"+i));
                    int amount = Integer.parseInt(params.get("amount_"+i));


                    //TODO Get the available amount for article article_id
                    result = st.executeQuery("SELECT amount FROM articles WHERE id=" + article_id);
                    result.next();
                    int available = result.getInt("amount");


                    if (available < amount)
                        throw new IllegalArgumentException(String.format("Not enough items of article #%d available", article_id));

                    //TODO Decrease the available amount for article article_id by amount
                    st.executeUpdate("UPDATE articles SET amount=" + (available-amount) + " WHERE id=" + article_id);
                    //TODO Insert new order line
                    st.execute("INSERT INTO order_lines (article_id, order_id) VALUES (" + article_id + ", " + order_id + ")");
                }

                response = String.format("{\"order_id\": %d}", order_id);
            } catch (IllegalArgumentException | SQLException iae) {
                response = String.format("{\"error\":\"%s\"}", iae.getMessage());
            }

            answerRequest(t, response);


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
                    "<dt>Alle Artikel anzeigen:</dt><dd><a href=\"http://127.0.0.1:"+port+"/articles\">http://127.0.0.1:"+port+"/articles</a></dd>"+
                    "<dt>Alle Bestellungen anzeigen:</dt><dd><a href=\"http://127.0.0.1:"+port+"/orders\">http://127.0.0.1:"+port+"/orders</a></dd>"+
                    "<dt>Alle Kunden anzeigen:</dt><dd><a href=\"http://127.0.0.1:"+port+"/clients\">http://127.0.0.1:"+port+"/clients</a></dd>"+
                    "<dt>Bestellung abschicken:</dt><dd><a href=\"http://127.0.0.1:"+port+"/placeOrder?client_id=<client_id>&article_id_1=<article_id_1>&amount_1=<amount_1&article_id_2=<article_id_2>&amount_2=<amount_2>\">http://127.0.0.1:"+port+"/placeOrder?client_id=&lt;client_id>&article_id_1=&lt;article_id_1>&amount_1=&lt;amount_1>&article_id_2=&lt;article_id_2>&amount_2=&lt;amount_2></a></dd>"+
                    "</dl></body></html>";

            answerRequest(t, response);
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

  
}
