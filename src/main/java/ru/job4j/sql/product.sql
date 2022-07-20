create table product(
    id serial primary key,
    name varchar(255)
);

create table client(
    id serial primary key,
    name varchar(255),
    product_id int references product(id)
);

insert into product(name) values ('credit');
insert into client(name, product_id) VALUES ('Ivan', 1);

select * from client;

select * from product where id in (select id from client);