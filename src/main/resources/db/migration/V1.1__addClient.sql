CREATE TABLE client(
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    phone VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    password VARCHAR NOT NULL
);

CREATE TABLE roles(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    client_id BIGINT REFERENCES client (id)
);