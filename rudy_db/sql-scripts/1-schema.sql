\c rudy;

CREATE SCHEMA rudy_schema;
SET search_path TO rudy_schema, public;

CREATE TABLE rudy_schema.users
(
    id    SERIAL PRIMARY KEY,
    email VARCHAR(256) UNIQUE NOT NULL,
    name  VARCHAR(256)        NOT NULL
);

CREATE TABLE rudy_schema.places
(
    id   VARCHAR(64) PRIMARY KEY,
    name VARCHAR(256) NOT NULL
);

CREATE TABLE rudy_schema.visits
(
    id         SERIAL PRIMARY KEY,
    user_id    BIGINT                   NOT NULL,
    place_id   VARCHAR(64)              NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES rudy_schema.users (id) ON DELETE CASCADE,
    FOREIGN KEY (place_id) REFERENCES rudy_schema.places (id) ON DELETE CASCADE
);
