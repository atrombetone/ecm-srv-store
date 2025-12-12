
INSERT INTO tb_users (birthday, hash_expiration, id, gendertype, phone, "name", "password", hash_lost_pwd, mail)
VALUES('1977-05-04', NULL, 1, 'MALE', '+5519998689623', 'André Luiz Trombetone', '123', NULL, 'altrombetone@gmail.com');

INSERT INTO tb_user_roles
(is_active, id, id_user, user_role)
VALUES(true, 1, 1, 'USER');

INSERT INTO tb_user_roles
(is_active, id, id_user, user_role)
VALUES(true, 2, 1, 'ADMIN');