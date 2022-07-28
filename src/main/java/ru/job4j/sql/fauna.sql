create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna (name, avg_age,  discovery_date)
values ('Przewalski_s_Horse', 9125, '1879-01-01');
insert into fauna (name, avg_age,  discovery_date)
values ('Elephant', 23725, '1797-01-01');
insert into fauna (name, avg_age,  discovery_date)
values ('Polar bear', 9825, '1774-01-01');
insert into fauna (name, avg_age,  discovery_date)
values ('Varan', 12045, '1912-01-01');
insert into fauna (name, avg_age,  discovery_date)
values ('Bolitoglossa', 9125, '2009-01-01');
insert into fauna (name, avg_age,  discovery_date)
values ('Dodo', null, null);
insert into fauna (name, avg_age,  discovery_date)
values ('Dogfish', 7300, null);

select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 20000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';
