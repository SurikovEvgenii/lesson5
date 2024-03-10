DROP TABLE IF EXISTS products_order;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;

CREATE TABLE orders(id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY , number_order int NOT NULL , date VARCHAR NOT NULL);
CREATE TABLE products(id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, name VARCHAR(255) NOT NULL, description VARCHAR(1000) NOT NULL, price INT NOT NULL);
CREATE TABLE products_order(product_id INT REFERENCES products(id), order_id INT REFERENCES orders(id), count INT NOT NULL);

INSERT INTO products(name, description, price) VALUES ('Яйца','Яйца категории C0','200');
INSERT INTO products(name, description, price) VALUES ('Хлеб','Хлеб на сыворотке.','50');
INSERT INTO products(name, description, price) VALUES ('Молоко','Молоко жирности 2.5%','70');
INSERT INTO products(name, description, price) VALUES ('Сметана','Сметана жирности 10%','60');
INSERT INTO products(name, description, price) VALUES ('Пицца','Самая вкусная пицца в мире от Итальянских поваров','1000');
INSERT INTO products(name, description, price) VALUES ('Вода','Артезианская вода. Только лучшее от природы для вашего организма','500');
INSERT INTO products(name, description, price) VALUES ('Сок Апельсиновый','Сила свежевыжатого апельсинового сока для вашего организма.','200');

INSERT INTO orders(number_order, date) VALUES (142,'24-08-2005');
INSERT INTO orders(number_order, date) VALUES (142,'23-07-2006');
INSERT INTO orders(number_order, date) VALUES (142,'24-08-2005');
INSERT INTO orders(number_order, date) VALUES (102,'28-10-2007');
INSERT INTO orders(number_order, date) VALUES (102,'28-10-2007');
INSERT INTO orders(number_order, date) VALUES (106,'27-08-2005');
INSERT INTO orders(number_order, date) VALUES (106,'27-08-2005');

INSERT INTO products_order(product_id, order_id, count) VALUES (1,1,2);
INSERT INTO products_order(product_id, order_id, count) VALUES (2,2,2);
INSERT INTO products_order(product_id, order_id, count) VALUES (3,4,1);
INSERT INTO products_order(product_id, order_id, count) VALUES (1,6,1);
INSERT INTO products_order(product_id, order_id, count) VALUES (5,5,1);
INSERT INTO products_order(product_id, order_id, count) VALUES (3,3,1);
INSERT INTO products_order(product_id, order_id, count) VALUES (2,2,1);
INSERT INTO products_order(product_id, order_id, count) VALUES (1,3,2);



