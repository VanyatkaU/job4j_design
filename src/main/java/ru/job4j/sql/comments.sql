create table comments (
    id serial primary key,
    name text,
    item_id int references item(id)
);