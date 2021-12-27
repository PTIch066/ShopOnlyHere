CREATE TABLE products (
	ID          SERIAL    PRIMARY KEY,
	name        CHAR(20)  NOT NULL,
	price       MONEY,
	number      INT,
	description TEXT,
	date        TIMESTAMP
);