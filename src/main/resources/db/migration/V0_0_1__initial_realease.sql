CREATE TABLE users if not exists(

    id UUID PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    age INT,
    is_approved BOOLEAN

);

CREATE TABLE admins if not exists(

    id UUID PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    role_id INT

);

CREATE TABLE roles if not exists(

    id UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(250)

);

INSERT INTO roles (name, description)
VALUES ('user', 'Regular user');

INSERT INTO roles (name, description)
VALUES ('admin', 'Administrator with special privileges');

INSERT INTO users (email, first_name, last_name, age, is_approved)
VALUES ('user1@gmail.com', 'John', 'Doe', 30, true);

INSERT INTO users (email, first_name, last_name, age, is_approved)
VALUES ('user2@gmail.com', 'Jane', 'Smith', 25, false);

INSERT INTO users (email, first_name, last_name, age, is_approved)
VALUES ('user3@gmail.com', Kate, 'Rogers’, 55, true);
