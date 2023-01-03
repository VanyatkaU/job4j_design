CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customers(first_name, last_name, age, country) 
values('Ivan', 'Karelkin', 37, 'Russia');
insert into customers(first_name, last_name, age, country) 
values('Tanas', 'Titan', 5000, 'Universal');
insert into customers(first_name, last_name, age, country) 
values('Piter', 'Parker', 17, 'USA');
insert into customers(first_name, last_name, age, country) 
values('GariK', 'Harlamov', 41, 'Russia');

CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);

insert into orders(amount, customer_id) 
values(21000, 1);
insert into orders(amount, customer_id) 
values(2001200, 2);
insert into orders(amount, customer_id)
values(1650, 3);

select first_name,
    last_name
from customers
where id not in (select customer_id 
                 from orders
                where amount > 0);

select first_name,
    last_name
from customers
where age = (select min(age)
             from customers);