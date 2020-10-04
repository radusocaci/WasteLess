INSERT INTO wasteless.users(username, password, enabled) VALUES ('admin','admin', true);
INSERT INTO wasteless.users(username, password, enabled) VALUES ('user','user', true);

INSERT INTO wasteless.user_roles (username, role) VALUES ('admin', 'ROLE_USER');
INSERT INTO wasteless.user_roles (username, role) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO wasteless.user_roles (username, role) VALUES ('user', 'ROLE_USER');
