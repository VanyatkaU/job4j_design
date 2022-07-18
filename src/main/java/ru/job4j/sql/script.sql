create table staff(
    id serial primary key,
    name varchar(255),
    department text,
    age int,
    experience char
);
select * from staff;
insert into staff(name, department, age, experience)
values('Ivan', 'OGT', 37, 7);
select * from staff;
update staff set age = 35;
select * from staff;
delete from staff;
select * from staff;