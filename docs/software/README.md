# Реалізація інформаційного та програмного забезпечення

## SQL скрипти:

```sql
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
```

### Insert scripts:

```sql
INSERT INTO roles (status, description) VALUES
('Admin', 'Administrator with full access'),
('Editor', 'User who can edit content'),
('Viewer', 'User with read-only access');

INSERT INTO users (role_id, first_name, last_name, age, email, password, phone_number) VALUES
(1, 'Alice', 'Johnson', 30, 'alice@example.com', 'alice123', '+1234567890'),
(2, 'Bob', 'Smith', 25, 'bob@example.com', 'bobsecure', '+1987654321'),
(3, 'Charlie', 'Brown', 28, 'charlie@example.com', 'charliepass', '+1122334455');

INSERT INTO requests (user_id, time, url) VALUES
(1, NOW(), '/api/data/1'),
(2, NOW(), '/api/data/2'),
(3, NOW(), '/api/data/3');

INSERT INTO contexts (filter, category, date) VALUES
('filter=recent', 'science', CURRENT_DATE),
('filter=popular', 'technology', CURRENT_DATE),
('filter=archive', 'history', CURRENT_DATE);

INSERT INTO request_contexts (request_id, context_id) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO responses (user_id, description, graphic) VALUES
(1, 'Response for request 1', 'graphic_data_1'),
(2, 'Response for request 2', 'graphic_data_2'),
(3, 'Response for request 3', 'graphic_data_3');

INSERT INTO request_responses (request_url, response_url) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO datasets (response_id, text, image_url, diagram, label, source, created_att) VALUES
(1, 'Dataset 1 content', 'https://example.com/image1.png', 'diagram1', 'Label1', 'Source1', NOW()),
(2, 'Dataset 2 content', 'https://example.com/image2.png', 'diagram2', 'Label2', 'Source2', NOW()),
(3, 'Dataset 3 content', 'https://example.com/image3.png', 'diagram3', 'Label3', 'Source3', NOW());

INSERT INTO feedbacks (response_id, user_id, title, comment) VALUES
(1, 2, 'Great explanation', 'The response was very informative and clear.'),
(2, 3, 'Needs improvement', 'More visuals would be helpful.'),
(3, 1, 'Perfect', 'Exactly what I was looking for.');

```


## TODO:
- RESTfull сервіс для управління даними

