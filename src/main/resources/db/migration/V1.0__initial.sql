CREATE TABLE coach
(
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    speciality VARCHAR,
    phone VARCHAR NOT NULL
);

CREATE TABLE genre
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    description TEXT
);

CREATE TABLE coach_genre
(
    coach_id BIGINT REFERENCES coach (id),
    genre_id BIGINT REFERENCES genre (id)
);