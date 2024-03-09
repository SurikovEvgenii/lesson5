DROP TABLE IF EXISTS products_order;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
CREATE TABLE orders(id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY , number_order int NOT NULL , date TIMESTAMP NOT NULL);
CREATE TABLE products(id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, name VARCHAR(255) NOT NULL, description VARCHAR(1000) NOT NULL, price INT NOT NULL);
CREATE TABLE products_order(product_id INT REFERENCES products(id), order_id INT REFERENCES orders(id), count INT NOT NULL);

INSERT INTO products(name, description, price) VALUES ('Яйца','Яйца категории C0','200');
INSERT INTO products(name, description, price) VALUES ('Хлеб','Хлеб на сыворотке.','50');
INSERT INTO products(name, description, price) VALUES ('Молоко','Молоко жирности 2.5%','70');
INSERT INTO products(name, description, price) VALUES ('Сметана','Сметана жирности 10%','60');
INSERT INTO products(name, description, price) VALUES ('Пицца','Самая вкусная пицца в мире от Итальянских поваров','1000');
INSERT INTO products(name, description, price) VALUES ('Вода','Артезианская вода. Только лучшее от природы для вашего организма','500');
INSERT INTO products(name, description, price) VALUES ('Сок Апельсиновый','Сила свежевыжатого апельсинового сока для вашего организма.','200');


