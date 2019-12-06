CREATE TABLE items (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	description text NOT NULL,
    createDate TIMESTAMP DEFAULT NOW()
);