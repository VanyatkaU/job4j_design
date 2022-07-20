create table card(
    id serial primary key,
    number int
);

create table patient(
    id serial primary key,
    name varchar(255),
    card_id int references card(id) unique
);