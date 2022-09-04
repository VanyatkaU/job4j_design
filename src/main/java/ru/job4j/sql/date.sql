create table students (
    id serial primary key,
    name varchar(50)
);

insert into students (name) values ('Иван Иванов');
insert into students (name) values ('Петр Петров');
insert into students (name) values ('Елена Ленина');
insert into students (name) values ('Марина Маринина');

create table authors (
    id serial primary key,
    name varchar(50)
);

insert into authors (name) values ('Александр Пушкин');
insert into authors (name) values ('Николай Гоголь');

create table books (
    id serial primary key,
    name varchar(200),
    author_id integer references authors(id)
);

insert into books (name, author_id) values ('Евгений Онегин', 1);
insert into books (name, author_id) values ('Капитанская дочка', 1);
insert into books (name, author_id) values ('Дубровский', 1);
insert into books (name, author_id) values ('Мертвые души', 2);
insert into books (name, author_id) values ('Вий', 2);

create table orders (
    id serial primary key,
    active boolean default true,
    book_id integer references books(id),
    student_id integer references students(id)
);

insert into orders (book_id, student_id) values (1, 1);
insert into orders (book_id, student_id) values (3, 1);
insert into orders (book_id, student_id) values (5, 2);
insert into orders (book_id, student_id) values (4, 1);
insert into orders (book_id, student_id) values (4, 2);
insert into orders (book_id, student_id) values (4, 3);
insert into orders (book_id, student_id) values (3, 3);
insert into orders (book_id, student_id) values (4, 4);

create view max
as select b.name as books, a.name as author, count(s.name) as count
 from books as b
    join orders o on o.book_id = b.id
    join authors a on b.author_id = a.id
    join students s on o.student_id = s.id
    group by (b.name, a.name) order by count desc limit 1;

select * from max;