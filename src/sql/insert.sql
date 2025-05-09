
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

