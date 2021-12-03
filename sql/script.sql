create table departments (
    id serial primary key,
    name varchar(255)
);

create table emploers (
    id serial primary key,
    name varchar(255),
    department_id int references departments(id)
);

insert into departments (name)
values
('Financial'),
('Government'),
('Environmental protection'),
('Ministry of Foreign Affairs'),
('The Culture');

insert into emploers (name, department_id)
values
('Manos Bumba', 2),
('Peter Gabriel', 3),
('Marine Le Pen', 1),
('Rony Size', 2),
('Edika Bado', 4),
('Jenny Stone', 5),
('Alias Brams', 1),
('Karla Ramon', 4),
('Elisabeth Taylor', 3),
('Alexandra Lima', 5);

select * from emploers e left join departments d on e.department_id = d.id;

select * from departments d right join emploers e on e.departments_id = d.id;

select * from emploers e full join departments d on e.departments_id = d.id;

select * from emploers e cross join departments d;

select * from departments d left join emploers e on e.departments_id = d.id where e.departments_id = null;


select * from emploers e left join departments d on e.department_id = d.id;
select * from departments d left joinemploers e on e.department_id = d.id;

create table teens (
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens (name, gender)
values
('Tim Tayler', 'm'),
('Luna Ramon', 'v'),
('Enio Maricone', 'm'),
('Mailo Stone', 'm'),
('Kim Bild', 'v'),
('Luci Talie', 'v');

select * from teens t1 cross join teens t2 where t1.gender != t2.gender;

select d.name, e.name, e.departments_id from emploers e left join departments d on e.department_id = d.id;
select d.name, e.name, e.departments_id from departments d left joinemploers e on e.department_id = d.id;