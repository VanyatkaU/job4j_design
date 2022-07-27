create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

inser into fauna (name, avg_age,  discovery_date)
values ('Przewalski_s_Horse', 9125, data '1879-01-01');
inser into fauna (name, avg_age,  discovery_date)
values ('Elephant', 23725, data '1797-01-01');
inser into fauna (name, avg_age,  discovery_date)
values ('Polar bear', 9825, data '1774-01-01');
inser into fauna (name, avg_age,  discovery_date)
values ('Varan', 12045, data '1912-01-01');
inser into fauna (name, avg_age,  discovery_date)
values ('Bolitoglossa', 9125, data '2009-01-01');
inser into fauna (name, avg_age,  discovery_date)
values ('Dodo', null, null);
inser into fauna (name, avg_age,  discovery_date)
values ('Dogfish', 7300, null);

select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 20000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date > '1950-01-01';