CREATE TABLE vacancy (
    id SERIAL PRIMARY KEY,
    title text NOT NULL,
    message text NOT NULL,
    link text NOT NULL,
    create_time TIMESTAMP NOT NULL
);