CREATE TABLE continents
(
    id   SERIAL PRIMARY KEY,
    area VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE populations
(
    id           SERIAL PRIMARY KEY,
    number       BIGINT NOT NULL,
    continent_id INTEGER REFERENCES continents (id)
);

CREATE TABLE animals
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(128) NOT NULL UNIQUE,
    population_id INTEGER REFERENCES populations (id)
);



