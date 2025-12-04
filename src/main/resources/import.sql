-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

INSERT INTO tb_users (birthday, hash_expiration, id, gendertype, phone, "name", "password", hash_lost_pwd, mail)
VALUES('1977-05-04', NULL, 1, 'MALE', '+5519998689623', 'André Luiz Trombetone', '123', NULL, 'altrombetone@gmail.com');