CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);
                            
insert into company(id, name) values(1, 'Sber'), (2, 'MTC'), (3, 'Machin'), (4, 'Temp'), (5, 'FT'),
                                (6, 'VTB'), (7, 'Ciber'), (8, 'TB');
                                
insert into person(id, name, company_id) values(1, 'Ivanov I.I.', 1);
insert into person(id, name, company_id) values(2, 'Stepanov S.S.', 1);
insert into person(id, name, company_id) values(3, 'Yakovlev A.G.', 1);
insert into person(id, name, company_id) values(4, 'Irinina I.E.', 1);
insert into person(id, name, company_id) values(5, 'Karelkin I.I.', 2);
insert into person(id, name, company_id) values(6, 'Bezgin I.I.', 2);
insert into person(id, name, company_id) values(7, 'Green R.', 2);
insert into person(id, name, company_id) values(8, 'Geller R.', 3);
insert into person(id, name, company_id) values(9, 'Mask I.', 3);
insert into person(id, name, company_id) values(10, 'Simpson G.', 2);
insert into person(id, name, company_id) values(11, 'Sanches R.', 3);
insert into person(id, name, company_id) values(12, 'Sanches M.', 3);
insert into person(id, name, company_id) values(13, 'Geller M.', 3);
insert into person(id, name, company_id) values(14, 'Simpson M.', 4);
insert into person(id, name, company_id) values(15, 'Ivanov D.', 4);
insert into person(id, name, company_id) values(16, 'Mukhina N.', 4);
insert into person(id, name, company_id) values(17, 'Parker P.', 4);
insert into person(id, name, company_id) values(18, 'Tanas', 5);
insert into person(id, name, company_id) values(19, 'Gamora', 5);
insert into person(id, name, company_id) values(20, 'Siff', 5);
insert into person(id, name, company_id) values(21, 'Darksied', 5);
insert into person(id, name, company_id) values(22, 'Stilet', 5);
insert into person(id, name, company_id) values(23, 'Tribiany J.', 6);
insert into person(id, name, company_id) values(24, 'Boufer F.', 6);
insert into person(id, name, company_id) values(25, 'Bing Ch.', 6);
insert into person(id, name, company_id) values(26, 'Kostin A.', 6);
insert into person(id, name, company_id) values(27, 'Letto J.', 6);
insert into person(id, name, company_id) values(28, 'Kruc C.', 6);
insert into person(id, name, company_id) values(29, 'Prime O.', 7);
insert into person(id, name, company_id) values(30, 'Megatron', 7);
insert into person(id, name, company_id) values(31, 'Super M', 7);
insert into person(id, name, company_id) values(32, 'Ares', 7);
insert into person(id, name, company_id) values(33, 'Odin', 7);
insert into person(id, name, company_id) values(34, 'Gendalf', 7);
insert into person(id, name, company_id) values(35, 'Bageens F', 8);
insert into person(id, name, company_id) values(36, 'Gembgy S.', 8);
insert into person(id, name, company_id) values(37, 'Sauron', 8);
insert into person(id, name, company_id) values(38, 'Potter G.', 8);
                                           
select * from company;
select * from person;