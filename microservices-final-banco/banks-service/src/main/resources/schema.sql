CREATE TABLE IF NOT EXISTS banks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    country VARCHAR(50) NOT NULL,
    address VARCHAR(150) NOT NULL,
    phone INT NOT NULL
);

INSERT INTO banks(name, country, address, phone)
VALUES ('Davivienda', 'Colombia', 'Direccion Davivienda', 320);
