create table departments(
    id serial primary key,
    name varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255),
    department_id int references departments(id)
);

insert into departments(name) values ('OGMet');
insert into departments(name) values ('OGT');
insert into departments(name) values ('OTC');
insert into departments(name) values ('DC');
insert into departments(name) values ('PC');

insert into employees(name, department_id) values ('Metallurg', 1);
insert into employees(name, department_id) values ('Laborant', 1);
insert into employees(name, department_id) values ('Technolog', null);
insert into employees(name, department_id) values ('Controler', null);
insert into employees(name, department_id) values ('Desiner 1', 4);
insert into employees(name, department_id) values ('Desiner 2', 4);
insert into employees(name, department_id) values ('Tokar', 5);
insert into employees(name, department_id) values ('Freser', 5);
insert into employees(name, department_id) values ('O_CHPU', 5);

select * from employees e left join departments d 
on e.department_id = d.id;

select * from departments d left join employees e 
on d.id = e.department_id;

select * from departments d right join employees e  
on e.department_id = d.id;

select * from employees e right join departments d 
on e.department_id = d.id;

select * from employees e full join departments d 
on e.department_id = d.id;

select * from employees e left join departments d 
on e.department_id = d.id
union
select * from employees e right join departments d 
on e.department_id = d.id;

select * from departments d cross join employees e;

select * from departments d left join employees e
on e.department_id = d.id where e.department_id is null;


select e.id, e.name, d.name as department from departments d 
right join employees e on d.id = e.department_id;

select e.id, e.name, d.name as department from employees e 
left join departments d on d.id = e.department_id;
