CREATE DATABASE IF NOT EXISTS user_service;
USE user_service;

CREATE TABLE IF NOT EXISTS user (
    id       BIGINT UNSIGNED NOT NULL PRIMARY KEY,
    username VARCHAR(50)     NOT NULL,
    password VARCHAR(500)    NOT NULL
);

/******************************************/

CREATE DATABASE IF NOT EXISTS user_service_2;
USE user_service_2;

CREATE TABLE IF NOT EXISTS user (
    id       BIGINT UNSIGNED NOT NULL PRIMARY KEY,
    username VARCHAR(50)     NOT NULL,
    password VARCHAR(500)    NOT NULL
);
