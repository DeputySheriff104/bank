CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    first_name VARCHAR(15) NOT NULL UNIQUE,
    last_name VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(144) NOT NULL UNIQUE
);

CREATE TABLE accounts
(
    id SERIAL PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    money_amount INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    CONSTRAINT accounts_user_id_fk FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE transfers
(
    id SERIAL PRIMARY KEY,
    from_account_id INTEGER NOT NULL,
    to_account_id INTEGER NOT NULL,
    money_amount INTEGER NOT NULL,
    date TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT transfers_from_account_id_fk FOREIGN KEY (from_account_id) REFERENCES accounts (id),
    CONSTRAINT transfers_to_account_id_fk FOREIGN KEY (to_account_id) REFERENCES accounts (id)
);

CREATE TABLE withdrawals
(
    id SERIAL PRIMARY KEY,
    from_account_id INTEGER NOT NULL,
    money_amount INTEGER NOT NULL,
    date TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT transfers_to_account_id_fk FOREIGN KEY (from_account_id) REFERENCES accounts (id)
);

CREATE TABLE deposits
(
    id SERIAL PRIMARY KEY,
    to_account_id INTEGER NOT NULL,
    money_amount INTEGER NOT NULL,
    date TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT transfers_to_account_id_fk FOREIGN KEY (to_account_id) REFERENCES accounts (id)
);

INSERT INTO users (login, password, first_name, last_name, phone, email) VALUES
    ('Larry1', 'pass1', 'Larry', 'Lawton', '774-760-9564', 'prison@gmail.com'),
    ('Anthony2', 'pass2','Anthony', 'Soprano', '817-900-8535', 'omerta@gmail.com'),
    ('John3', 'pass3','John', 'Brown', '850-921-9054', 'sheriff@gmail.com');




