create database vehicle;

create table cars (
id serial primary key,
    brand varchar(20),
    model varchar(20),
    year date
);

create table chassis (
id serial primary key,
    type varchar(10),
    car_id int references cars(id)
);

create table engines (
id serial primary key,
    engine_code varchar(30),
    car_id int references cars(id)
);

create table gear_boxes (
id serial primary key,
    gear_box_code varchar(30),
    car_id int references cars(id)
);

insert into cars (brand, model, year)
values
('BMW', '530', '02-11-2015'),
('Toyota', 'Prius', '11-04-2013'),
('Ford', 'Taurus', '25-10-2001'),
('Mercedes', 'Vito', '30-04-2020'),
('Fiat', 'Stilo', '01-10-2000'),
('Chevrolet', 'Corvette', '22-06-1965');

insert into chassis (type, car_id)
values
('BHGFFH45', 2),
('Fggdhj45', 5),
('554UI', 1),
('EF45GT', 4),
('HGFCJ52', 2);

insert into engines (engine_code, car_id)
values
('CAX', 2),
('CCZ', 1),
('M9R 782', 5),
('N52D30C', 4);

insert into gear_boxes (gear_box_code, car_id)
values
('Nj1', 2),
('Rtu45', 1),
('145DS', 5),
('Hhf1', 4);


select * from cars cr
full join chassis ch on ch.car_id = cr.id
full join engines en on en.car_id = cr.id
full join gear_boxes gb on gb.car_id = cr.id;

select * from engines en
full join cars cr on en.car_id = cr.id
full join chassis ch on ch.car_id = cr.id
full join gear_boxes gb on gb.car_id = cr.id;

select * from cars cr
full join chassis ch on ch.car_id = cr.id
full join engines en on en.car_id = cr.id
full join gear_boxes gb on gb.car_id = cr.id
where ch is null
or gb is null
or en is null;

