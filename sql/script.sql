create table registration_number(
    id serial primary key,
    state varchar(255),
    register_number int
);

create table vehicle(
    id serial primary key,
    brand varchar(255),
	model varchar(255),
	year_of_issue int,
    registration_number_id int references registration_number(id) unique
);

insert into registration_number(state,
register_number) values ('Alabama', 1445412);
insert into registration_number(state,
register_number) values ('Dacota', 1588656);
insert into registration_number(state,
register_number) values ('Virginia', 1475555);
insert into registration_number(state,
register_number) values ('New York', 2545523);
insert into registration_number(state,
register_number) values ('Montana', 556621);
insert into registration_number(state,
register_number) values ('Dacota', 5454988);


insert into vehicle(brand,
model, year_of_issue, registration_number_id)
values ('DMC', 'F12', 1956, 2);
insert into vehicle(brand,
model, year_of_issue, registration_number_id)
values ('BMW', '530', 2011, 3);
insert into vehicle(brand,
model, year_of_issue, registration_number_id)
values ('Mercedes', 'E220', 2017, 1);
insert into vehicle(brand,
model, year_of_issue, registration_number_id)
values ('Opel', 'Zafira', 2000, 4);

insert into vehicle(brand,
model, year_of_issue)
values ('Honda', 'Crv', 2015);
insert into vehicle(brand,
model, year_of_issue)
values ('Toyota', 'Prius', 2014);

select * from vehicle inner join
registration_number r on vehicle
.registration_number_id = r.id;

select * from vehicle join registration_number
r on vehicle.registration_number_id = r.id;

select  rr.brand, r.register_number, r.state
from vehicle as rr join registration_number as
r on rr.registration_number_id = r.id;