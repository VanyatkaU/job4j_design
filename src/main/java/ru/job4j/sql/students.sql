create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('PC', 45000);
insert into devices(name, price) values ('SSD', 13562);
insert into devices(name, price) values ('Plaeyr', 3560);
insert into devices(name, price) values ('Smartphone', 25530);
insert into devices(name, price) values ('Printer', 7256);
insert into devices(name, price) values ('Scaner', 5000);

insert into people(name) values ('Ivan');
insert into people(name) values ('Alex');
insert into people(name) values ('Stepan');

insert into devices_people(device_id, people_id) values (1, 1);
insert into devices_people(device_id, people_id) values (3, 1);
insert into devices_people(device_id, people_id) values (2, 2);
insert into devices_people(device_id, people_id) values (6, 2);
insert into devices_people(device_id, people_id) values (4, 3);
insert into devices_people(device_id, people_id) values (5, 3);

select avg(price) from devices;

select p.name, avg(d.price) as avg_price from devices_people as dp
join people as p on dp.people_id = p.id
join devices as d on dp.device_id = d.id
group by p.name;

select p.name, avg(d.price) as avg_price from devices_people as dp
join people as p on dp.people_id = p.id
join devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;