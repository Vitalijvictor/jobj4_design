create database vehicle;

create table chassis (
id serial primary key,
    type varchar(10)
);

create table engines (
id serial primary key,
    engine_code varchar(30)
);

create table gear_boxes (
id serial primary key,
    gear_box_code varchar(30)
);

create table cars (
id serial primary key,
    brand varchar(20),
    model varchar(20),
    year date,
    chassis_id int references chassis(id),
    engine_id int references engines(id),
    gear_box_id int references gear_boxes(id)
);

insert into chassis (type)
values
('BHGFFH45'),
('Fggdhj45'),
('554UI'),
('EF45GT'),
('HGFCJ52');

insert into engines (engine_code)
values
('CAX'),
('CCZ'),
('M9R 782'),
('N52D30C');

insert into gear_boxes (gear_box_code)
values
('Nj1'),
('Rtu45'),
('145DS'),
('Hhf1');

insert into cars (brand, model, year,
chassis_id, engine_id, gear_box_id)
values
('BMW', '530', '02-11-2015', 4, 2, 4),
('Toyota', 'Prius', '11-04-2013', 1, 3, 2),
('Ford', 'Taurus', '25-10-2001', 3, 2, 4),
('Mercedes', 'Vito', '30-04-2020', 2, 1, 3),
('Fiat', 'Stilo', '01-10-2000', 2, 3, 2),
('Chevrolet', 'Corvette', '22-06-1965', 4, 4, 1);


select * from cars cr
left join chassis ch on cr.chassis_id = ch.id
left join engines en on cr.engine_id = en.id
left join gear_boxes gb on cr.gear_box_id = gb.id;

select * from chassis ch
left join cars cr on cr.chassis_id = ch.id
where cr.chassis_id is null;

select * from cars cr
right join chassis ch
on cr.chassis_id = ch.id
where cr.chassis_id is null;

select * from engines en
left join cars cr on cr.engine_id = en.id
where cr.engine_id is null;

select * from cars cr
right join engines en
on cr.engine_id = en.id
where cr.engine_id is null;

select * from gear_boxes gb
left join cars cr on cr.gear_box_id = gb.id
where cr.gear_box_id is null;

select * from cars cr
right join gear_boxes gb
on cr.gear_box_id = gb.id
where cr.gear_box_id is null;
