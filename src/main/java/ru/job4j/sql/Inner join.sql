create table person (
    id serial primary key,
    name varchar(255),
    tab_number int
);

create table TP (
    id serial primary key,
    name varchar(255),
    person_id int references person(id)
);

insert into person(name, tab_number) values ('Ivan', 1623);
insert into person(name, tab_number) values ('Alex', 2645);
insert into person(name, tab_number) values ('Stepan', 2750);

insert into TP(name, person_id) values ('Korpus', 1);
insert into TP(name, person_id) values ('Filtr', 2);
insert into TP(name, person_id) values ('Vint', 3);

select T.name, p.name, p.tab_number
from TP as T join person p on T.person_id = T.id;

select T.name Наименование, p.name as Имя, p.tab_number as Табель
from TP as T join person p on T.person_id = T.id;

select T.name as "Наименование процесса", p.name as Имя, p.tab_number as Табель
from TP as T join person p on T.person_id = T.id;