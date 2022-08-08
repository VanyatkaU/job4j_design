create table teens(
    id serial primary key,
    name varchar(255),
    gender varchar(255)
);

insert into teens(name, gender) values ('Ivan', 'M'), ('Stepan', 'M');
insert into teens(name, gender) values ('July', 'F'), ('Lina', 'F');

select tm.name, tm.gender, tf.name, tf.gender from teens tm
cross join teens tf where tm.gender != tf.gender;