CREATE TABLE subscription(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    price BIGINT NOT NULL,
    lessons_count BIGINT NOT NULL
);

ALTER TABLE client ADD COLUMN subscription_id BIGINT;

ALTER TABLE client ADD FOREIGN KEY ("subscription_id") REFERENCES "subscription" ("id");