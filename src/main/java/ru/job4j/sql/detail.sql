create table details(
     id serial primary key,
     name varchar(255)
 );

 create table unit(
     id serial primary key,
     name varchar(255)
 );

 create table details_unit(
     id serial primary key,
     detail_id int references detail(id),
     unit_id int references unit(id)
 );

insert into details(name) values ('screw');
insert into details(name) values ('washer');
insert into details(name) values ('nut');

insert into unit(name) values ('housing');
insert into unit(name) values ('valve');
insert into unit(name) values ('pump');

insert into details_unit(details_id, unit_id) values (1, 1);
insert into details_unit(details_id, unit_id) values (1, 2);
insert into details_unit(details_id, unit_id) values (1, 3);
insert into details_unit(details_id, unite_id) values (2, 1);
insert into details_unit(details_id, unite_id) values (2, 2);
insert into details_unit(details_id, unit_id) values (3, 3);