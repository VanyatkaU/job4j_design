create table equipments (
    id serial primary key,
    name varchar(50),
    count integer default 0,
    area integer
);

insert into equipments (name, count, area) VALUES ('stanok_tok', 5, 4);
insert into equipments (name, count, area) VALUES ('stanok_shlif', 2, 5);
insert into equipments (name, count, area) VALUES ('pech_plav', 3, 2);
insert into equipments (name, count, area) VALUES ('pech_term', 4, 3);
insert into equipments (name, count, area) VALUES ('zatoch', 3, 4);

insert into equipments (name, count, area) VALUES ('sklad', 1, 1);
delete from equipments where area = 2;
update equipments set area = 4 where name = 'pech_term';

delete from equipments;
ALTER SEQUENCE equipments_id_seq RESTART WITH 1;

create table equipments (
    id serial primary key,
    name varchar(50),
    count integer default 0,
    area integer
);

insert into equipments (name, count, area) VALUES ('stanok_tok', 5, 4);
insert into equipments (name, count, area) VALUES ('stanok_shlif', 2, 5);
insert into equipments (name, count, area) VALUES ('pech_plav', 3, 2);
insert into equipments (name, count, area) VALUES ('pech_term', 4, 3);
insert into equipments (name, count, area) VALUES ('zatoch', 3, 4);

begin transaction isolation level repeatable read;

insert into equipments (name, count, area) VALUES ('sklad', 1, 1);
delete from equipments where area = 2;
update equipments set area = 4 where name = 'pech_term';

rollback

delete from equipments;
ALTER SEQUENCE equipments_id_seq RESTART WITH 1;

create table equipments (
    id serial primary key,
    name varchar(50),
    count integer default 0,
    area integer
);

insert into equipments (name, count, area) VALUES ('stanok_tok', 5, 4);
insert into equipments (name, count, area) VALUES ('stanok_shlif', 2, 5);
insert into equipments (name, count, area) VALUES ('pech_plav', 3, 2);
insert into equipments (name, count, area) VALUES ('pech_term', 4, 3);
insert into equipments (name, count, area) VALUES ('zatoch', 3, 4);

begin transaction isolation level serializable;

select sum(count) from equipments;

update equipments set count = 33 where name = 'stanok_shlif';
