CREATE DATABASE db_demo;

CREATE TABLE db_demo.user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(20) NOT NULL
);

CREATE TABLE db_demo.authorities (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    authorityName VARCHAR(20) NOT NULL
);

CREATE TABLE db_demo.user_authorities (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    authorities_id BIGINT NOT NULL,

    CONSTRAINT fk_user_user_authorities FOREIGN KEY (user_id) REFERENCES db_demo.user(id),
    CONSTRAINT fk_authorities_user_authorities FOREIGN KEY (authorities_id) REFERENCES db_demo.authorities(id)
);

INSERT INTO authorities (authority_name) VALUES ('ROLE_USER');
INSERT INTO authorities (authority_name) VALUES ('ROLE_ADMIN');
