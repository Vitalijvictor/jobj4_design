create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices (name, price) values
('Gsm', 523.25), ('Hi-Fi', 874.54),
('Helicopter', 1253.78), ('Action Cam', 964.02);

insert into people (name) values ('Jim Morison');
insert into people (name) values ('Johan
Fisher'), ('Lenny Moons'), ('Eddy Van Halen');

insert into devices_people (device_id, people_id)
values (3, 1), (1, 1), (2, 2), (4, 2), (1, 2),
(3, 3);

select avg(price) from devices;

select ppl.id, ppl.name, avg(d.price) from devices_people as dp
join devices as d on dp.device_id = d.id
join people as ppl on dp.people_id = ppl.id
group by ppl.id;

select ppl.id, ppl.name, avg(d.price) from devices_people as dp
join devices as d on dp.device_id = d.id
join people as ppl on dp.people_id = ppl.id
group by ppl.id
having avg(d.price) > 5000;


insert into devices_people(device_id,
people_id) values (1, 2, 4, 3), (2, 4, 1, 1);
insert into devices_people(device_id,
people_id) values (1, 1, 4, 2), (4, 4, 1, 2);
insert into devices_people(device_id,
people_id) values (2, 2, 4, 3), (2, 4, 1, 1);
insert into devices_people(device_id,
people_id) values (1, 3, 4, 2), (4, 4, 2, 2);