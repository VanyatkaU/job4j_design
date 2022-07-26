insert into role(name, users_id) values ('admin', 1);
insert into role(name, users_id) values ('user', 2);
insert into users(name, role_id) values ('Ivan', 1);
insert into users(name, role_id) values ('Alex', 2);
insert into rules(name) values ('creature');
insert into rules(name) values ('completion');
insert into rules(name) values ('registration');
insert into rules(name) values ('closure');
insert into role_rules(role_id, rules_id) VALUES (1, 1);
insert into role_rules(role_id, rules_id) VALUES (2, 2);
insert into category(name) values ('urgent');
insert into category(name) values ('non-urgentk');
insert into state(name) values ('created');
insert into state(name) values ('at work');
insert into state(name) values ('completed');
insert into item(name, users_id, category_id, state_id) 
VALUES ('buying hard drives', 1, 1, 2);
insert into item(name, users_id, category_id, state_id) 
VALUES ('installation PLC', 2, 1, 3);
insert into comments(name, item_id) VALUES ('regular customer', 1);
insert into comments(name, item_id) VALUES ('new counterparty', 2);
insert into comments(name, item_id) values ('current work');
insert into attachs(name, item_id) VALUES ('commercial proposal', 1);
insert into attachs(name, item_id) VALUES ('invoice', 2);