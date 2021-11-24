create table gamers(
id serial primary key,
	name varchar(255),
	age int,
	birthday date
);
insert into gamers(name, age, birthday) values ('John', 25, '1986-03-15');
update gamers set name = 'Ludo';
delete from gamers;