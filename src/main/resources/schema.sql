CREATE TABLE IF NOT EXISTS "user"
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    age int NOT NULL,
    email varchar(50) NOT NULL
);

INSERT INTO "user" (name, age, email) VALUES ('Ivan', 22, 'ivan@mail.ru');
INSERT INTO "user" (name, age, email) VALUES ('Petr', 33, 'petr@mail.ru');
INSERT INTO "user" (name, age, email) VALUES ('Bob', 21, 'bob@mail.ru');
