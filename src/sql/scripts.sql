CREATE TABLE IF NOT EXISTS roles (
    id SERIAL PRIMARY KEY NOT NULL,
    status VARCHAR(30) NOT NULL,
    description TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL NOT NULL PRIMARY KEY,
    role_id INTEGER NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age INTEGER NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(30) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    CONSTRAINT fk_users_roles FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE IF NOT EXISTS requests (
    id SERIAL PRIMARY KEY NOT NULL,
    user_id INTEGER NOT NULL,
    time TIMESTAMP NOT NULL,
    url VARCHAR(30) NOT NULL,
    CONSTRAINT fk_requests_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS contexts (
    id SERIAL PRIMARY KEY NOT NULL,
    filter VARCHAR(500) NOT NULL,
    category VARCHAR(30) NOT NULL,
    date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS request_contexts (
    id SERIAL PRIMARY KEY NOT NULL,
    request_id BIGINT NOT NULL,
    context_id BIGINT NOT NULL,
    CONSTRAINT fk_rc_request FOREIGN KEY (request_id) REFERENCES requests(id),
    CONSTRAINT fk_rc_context FOREIGN KEY (context_id) REFERENCES contexts(id)
);

CREATE TABLE IF NOT EXISTS responses (
    id SERIAL PRIMARY KEY NOT NULL,
    user_id INTEGER NOT NULL,
    description TEXT NOT NULL,
    graphic TEXT NOT NULL,
    CONSTRAINT fk_responses_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS request_responses (
    id SERIAL PRIMARY KEY NOT NULL,
    request_url BIGINT NOT NULL,
    response_url BIGINT NOT NULL,
    CONSTRAINT fk_rr_request FOREIGN KEY (request_url) REFERENCES requests(id),
    CONSTRAINT fk_rr_response FOREIGN KEY (response_url) REFERENCES responses(id)
);

CREATE TABLE IF NOT EXISTS datasets (
    id SERIAL PRIMARY KEY NOT NULL,
    response_id INTEGER NOT NULL,
    text TEXT NOT NULL,
    image_url VARCHAR(500) NOT NULL,
    diagram TEXT NOT NULL,
    label VARCHAR(30) NOT NULL,
    source VARCHAR(500) NOT NULL,
    created_att TIMESTAMP NOT NULL,
    CONSTRAINT fk_datasets_response FOREIGN KEY (response_id) REFERENCES responses(id)
);

CREATE TABLE IF NOT EXISTS feedbacks (
    id SERIAL PRIMARY KEY NOT NULL,
    response_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    title VARCHAR(100) NOT NULL,
    comment TEXT NOT NULL,
    CONSTRAINT fk_feedbacks_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_feedbacks_response FOREIGN KEY (response_id) REFERENCES responses(id)
);
