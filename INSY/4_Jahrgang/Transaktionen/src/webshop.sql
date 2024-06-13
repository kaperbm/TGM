DROP TABLE IF EXISTS articles CASCADE;
DROP TABLE IF EXISTS clients CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS order_lines CASCADE;


CREATE TABLE articles (
    id serial PRIMARY KEY,
    description text,
    price integer,
    amount integer
);

CREATE TABLE clients (
    id serial PRIMARY KEY,
    name text,
    address text,
    city text,
    country text
);

CREATE TABLE orders (
    id integer PRIMARY KEY,
    created_at timestamp DEFAULT now(),
    client_id integer REFERENCES clients(id)
);

CREATE TABLE order_lines (
    id serial PRIMARY KEY,
    article_id integer REFERENCES articles(id),
    order_id integer REFERENCES orders(id),
    amount integer
);

INSERT INTO articles (description, price, amount) VALUES ('Lord of the Rings Trilogy',3899,100);
INSERT INTO articles (description, price, amount) VALUES ('The Art of Computer Programming Vol. 1',10000,2);
INSERT INTO articles (description, price, amount) VALUES ('Concrete Mathematics',3000,20);
INSERT INTO articles (description, price, amount) VALUES ('Code Complete: A Practical Handbook of Software Construction',4167,20);
INSERT INTO articles (description, price, amount) VALUES ('Datenbanksysteme. Eine Einführung',4995,10);


INSERT INTO clients (name,address,city,country) VALUES ('Kunde 1', 'Wexstrasse 19-23', 'Vienna', 'Austria');
INSERT INTO clients (name,address,city,country) VALUES ('Kunde 2', '1600 Amphitheatre Parkway', 'Mountain View', 'US');



insert into orders (id, client_id) values (1,1);
insert into order_lines (article_id, order_id,amount) values (1,1,1);
insert into order_lines (article_id, order_id,amount) values (2,1,3);


insert into orders (id, client_id) values (2,2);
insert into order_lines (article_id, order_id,amount) values (3,2,4);
insert into order_lines (article_id, order_id,amount) values (4,2,1);

