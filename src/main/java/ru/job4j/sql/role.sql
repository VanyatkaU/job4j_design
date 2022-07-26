create table role (
    id serial primary key,
    name text,
    users_id int references users(id)
);
