create table car_bodies(
    id serial primary key,
    name varchar(255)
);

create table car_engines(
    id serial primary key,
    name varchar(255)
);

create table car_transmissions(
    id serial primary key,
    name varchar(255)
);

create table cars(
    id serial primary key,
    name varchar(255),
    body_id int references car_bodies(id),
    engine_id int references car_engines(id),
    transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values ('Sedan'), ('Hachback'), 
('Miniwan'), ('Station_wagon');
insert into car_engines(name) values ('Hybrid'), ('Electric'), 
('V-shaped');
insert into car_transmissions(name) values ('Robotic'), ('Automatic'), 
('Mechanical');
insert into cars(name, body_id, engine_id, transmission_id) values 
('VW', 1, null, 2), ('KIA', 2, 3, 2), ('Lada', null, 3, 3), ('Toyota', 2, 1, 1);

select c.name car_name, cb.name body_name, ce.name engine_name, 
ct.name transmission_name from cars c 
left join car_bodies cb on c.body_id = cb.id
left join car_engines ce on c.engine_id = ce.id
left join car_transmissions ct on c.transmission_id = ct.id
order by c.name;

select cb.name from car_bodies cb left join cars c on 
c.body_id = cb.id where c.id is null;

select ce.name from car_engines ce left join cars c on 
c.engine_id = ce.id where c.id is null;

select ct.name from car_transmissions ct left join cars c on 
c.transmission_id = ct.id where c.id is null;