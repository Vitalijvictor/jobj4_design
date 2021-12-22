create table type_of_bier (
	id serial primary key,
	type varchar(20)
);

insert into type_of_bier (type) values
('Blond');
insert into type_of_bier (type) values
('Bruin');
insert into type_of_bier (type) values
('Donker bruin');
insert into type_of_bier (type) values
('Trapist');

create table bier (
	id serial primary key,
	name varchar(20),
	type_of_bier_id integer references type_of_bier(id)
);

insert into bier (name, type_of_bier_id) values
('Duivel', 3);
insert into bier (name, type_of_bier_id) values
('Grimbergen', 1);
insert into bier (name, type_of_bier_id) values
('Leffe', 2);
insert into bier (name, type_of_bier_id) values
('Westerloo', 4);

create table state (
	id serial primary key,
	name varchar(30)
);

insert into state (name) values ('Dakota');
insert into state (name) values ('Victoria');
insert into state (name) values ('Namur');
insert into state (name) values ('Limburg');

create table land (
    id serial primary key,
	name varchar(50),
	state_id integer references state(id)
);

insert into land (name, state_id) values
('Usa', 1);
insert into land (name, state_id) values
('Australia', 2);
insert into land (name, state_id) values
('Belgium', 3);
insert into land (name, state_id) values
('Nederlands', 4);

create table bottles (
	id serial primary key,
	name varchar(30)
);

insert into bottles (name) values ('Skinny');
insert into bottles (name) values ('Fat boy');
insert into bottles (name) values ('Old jack');
insert into bottles (name) values ('Lucy');
insert into bottles (name) values ('Monch soul');

create table brewery (
	id serial primary key,
	name varchar(30),
	bier_id integer references bier(id),
	land_id integer references land(id),
	bottle_id integer references bottles(id)
);

insert into brewery (name, bier_id, land_id,
bottle_id)
values ('Budweiser', 1, 2, 3);
insert into brewery (name, bier_id, land_id,
bottle_id)
values ('Microbrouwerij Grimbergen',
 2, 1, 1);
insert into brewery (name, bier_id, land_id,
bottle_id)
values ('Jonas', 3, 4, 2);
insert into brewery (name, bier_id, land_id,
bottle_id)
values ('Patrik', 4, 3, 4);

select bi.name, count(bo.name), bo.name from bier as bi
join brewery b on bi.id = b.bier_id
join land l on b.land_id = l.id
join bottles bo on bottle_id = bo.id
group by (bi.name, bo.name) having count (bo
.name) < 2;

create view
show_brewery_land_bottles_more_than_2
as select  bi.name as bier, count(bo.name),
bo.name as bottles from bier as bi
join brewery b on bi.id = b.bier_id
join land l on b.land_id = l.id
join bottles bo on bottle_id = bo.id
group by (bi.name, bo.name) having count (bo
.name) < 2;













