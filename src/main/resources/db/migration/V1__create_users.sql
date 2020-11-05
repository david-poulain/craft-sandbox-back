CREATE SCHEMA IF NOT EXISTS schema_wyn;

CREATE TABLE schema_wyn.user_id_generator (
    id INTEGER PRIMARY KEY,
    next_generated_user_id INTEGER
);

INSERT INTO schema_wyn.user_id_generator (id, next_generated_user_id) VALUES (0, 0);

CREATE TABLE schema_wyn.users (
     id INTEGER PRIMARY KEY,
     first_name VARCHAR(50),
     last_name VARCHAR(50)
);