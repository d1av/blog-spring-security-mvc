INSERT INTO Posts(title,content,description) VALUES ('My First Post','This is my first post','First Post Description');
INSERT INTO Posts(title,content,description) VALUES ('My Second Post','This is my Second post','Second Post Description');

INSERT INTO Comment(name,email,body,post_id) VALUES ('Comment 1','john@cena','First Comment',1);
INSERT INTO Comment(name,email,body,post_id) VALUES ('Nearly first :(','john@cena','Close',1);
INSERT INTO Comment(name,email,body,post_id) VALUES ('Comment 1','tony@stark','First Comment',2);
INSERT INTO Comment(name,email,body,post_id) VALUES ('Nearly First','john@cena','Close',2);

INSERT INTO roles(name) VALUES ('ROLE_USER'),('ROLE_ADMIN');

INSERT INTO users(email,name,password,username) VALUES ('admin@admin','Admin','$2a$10$FUlO0odzUuxuv1KbGjOgE.Kr9Xuz3baIMsVlhTENkD9QPkB.ecRiK','admin');
INSERT INTO users(email,name,password,username) VALUES ('davi@davi','Davi','$2a$10$9B7YovC4owgOeiHTTny.PucbEx3pWX4KAEgX447vnOpjcfguLqsB6','davi');

INSERT INTO users_roles(user_id,role_id) VALUES (1,1),(1,2),(2,1);