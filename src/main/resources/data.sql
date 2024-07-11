-- article 테이블에 데이터 삽입
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목 1', '내용 1', NOW(), NOW());
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목 2', '내용 2', NOW(), NOW());
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목 3', '내용 3', NOW(), NOW());

-- quiz 테이블에 데이터 삽입
INSERT INTO quiz (image_url, question, answer, category_id) VALUES ('https://example.com/image1.jpg', 'What is 2+2?', '4', 1);
INSERT INTO quiz (image_url, question, answer, category_id) VALUES ('https://example.com/image2.jpg', 'What is the capital of France?', 'Paris', 1);
INSERT INTO quiz (image_url, question, answer, category_id) VALUES ('https://example.com/image3.jpg', 'What is the largest planet in our solar system?', 'Jupiter', 2);
INSERT INTO quiz (image_url, question, answer, category_id) VALUES ('https://example.com/image4.jpg', 'What is the boiling point of water in Celsius?', '100', 3);
INSERT INTO quiz (image_url, question, answer, category_id) VALUES ('https://example.com/image5.jpg', 'Who painted the Mona Lisa?', 'Leonardo da Vinci', 4);
