CREATE DATABASE sistemaVendas;
USE sistemaVendas;

CREATE TABLE cliente (
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    endereco VARCHAR(200)
);

CREATE TABLE cargo (
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome_cargo VARCHAR(100) NOT NULL,
    salario FLOAT(10, 2) NOT NULL
);

CREATE TABLE funcionario (
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    cargo INT(10) NOT NULL,
    setor VARCHAR(50) NOT NULL,
    data_admissao DATE NOT NULL,
    FOREIGN KEY (cargo) REFERENCES cargo(id)
);

CREATE TABLE produtos (
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    codigo_barras VARCHAR(100) NOT NULL UNIQUE,
    nome_produto VARCHAR(100) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    preco FLOAT(10, 2) NOT NULL,
    quantidade_estoque INT(10) NOT NULL,
    minimo_estoque INT(10)
);

CREATE TABLE usuarios (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    setor VARCHAR(50) NOT NULL
);

CREATE TABLE desconto_fidelidade (
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT(10) NOT NULL,
    valor_desconto FLOAT(10, 2) NOT NULL,
    data_aplicacao DATE NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

CREATE TABLE tipo_forma_pagamento (
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(20) NOT NULL
);

CREATE TABLE forma_pagamento (
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT(10) NOT NULL,
    id_tipo_pagamento INT NOT NULL,
    valor FLOAT(10, 2) NOT NULL,
    FOREIGN KEY (id_tipo_pagamento) REFERENCES tipo_forma_pagamento(id)
);

CREATE TABLE pedido (
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    data_pedido DATETIME NOT NULL,
    id_cliente INT(10) NOT NULL,
    valor_total FLOAT(10, 2) NOT NULL,
    id_forma_pagamento INT(10) NOT NULL,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY (id_forma_pagamento) REFERENCES forma_pagamento(id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE TABLE item_pedido (
    id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT(10) NOT NULL,
    id_produto INT(10) NOT NULL,
    quantidade INT(10) NOT NULL,
    preco_unitario FLOAT(10, 2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id),
    FOREIGN KEY (id_produto) REFERENCES produtos(id)
);
