CREATE DATABASE coucheV2;
USE coucheV2;

CREATE TABLE client (
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL
);

INSERT INTO client (name) VALUES ('Jérémy'), ('Julia'), ('Clara');