CREATE TABLE lesson(
    id BIGSERIAL PRIMARY KEY,
    "date" date NOT NULL,
    "time" time NOT NULL,
    coach_id BIGINT REFERENCES coach (id) NOT NULL,
    client_id BIGINT REFERENCES client (id)
)