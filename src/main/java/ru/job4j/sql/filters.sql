create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    expired_date date,
    price float,
    type_id int references type(id)
);

insert into type(name) values ('СЫР');
insert into type(name) values ('МОЛОКО');

insert into product(name, expired_date, price, type_id) values
('сыр плавленный', '2022-08-5', 75, 1);
insert into product(name, expired_date, price, type_id) values
('сыр моцарелла', '2022-08-10', 201, 1);
insert into product(name, expired_date, price, type_id) values
('сыр Король Артур', '2022-07-23', 175, 1);
insert into product(name, expired_date, price, type_id) values
('мoроженое пломбир', '2022-08-15', 115, 2);
insert into product(name, expired_date, price, type_id) values
('мoроженое брикет', '2022-09-07', 215, 2);
insert into product(name, expired_date, price, type_id) values
('молоко Вкуснотеево', '2023-08-14', 105, 2);
insert into product(name, expired_date, price, type_id) values
('йогурт', '2022-11-25', 125, 2);

select p.name as p, t.name as t from product as p
inner join type as t on p.type_id = t.id
where t.name = 'СЫР';

select name from product where name like '%мороженое%';

select name from product where expired_date < current_date;

select name from product order by price desc limit 1;

select t.name as тип, count(*) as количество from type as t
join product as p on p.type_id = t.id group by t.name;

select p.name, t.name from product as p inner join type as t on 
p.type_id = t.id where t.name in ('СЫР', 'МОЛОКО');


select t.name as тип, count(*) as количество from type as t
join product as p on p.type_id = t.id group by t.name
having count(*) < 10;

select p.name as наименование, t.name as тип from product as p
join type as t on p.type_id = t.id order by t.name;