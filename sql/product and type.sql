create table product_type (
    id serial primary key,
    name varchar(255)
);

create table product (
 id serial primary key,
    name varchar(255),
    type_id int references product_type(id),
    expired_date date,
    price float
);

insert into product_type (name) values
('Chees'),
('Milk'),
('Meat'),
('Fish'),
('Bread'),
('Sweets');

insert into product (name, type_id,
expired_date, price)
values
('Bree', 1, '12-03-2021', 12.02),
('Cheddar', 1, '12-03-2071', 42.02),
('Chicken Wings', 3, '11-09-2001', 66.66);





select * from product as p join product_type as
 pt on p.type_id = pt.id where pt.name = 'Chees';

select * from products where name like
'%icecream%';

select * from product where  expired_date < date(now());

select * from product where price = (select max(price) from product);

select p.name, count(*) from product_type as pt join product as
 p on pt.id = p.type_id group by p.name;

select * from product as p join product_type as
 pt on p.type_id = pt.id where pt.name =
 'Chees' or pt.name ='Milk';

select * from product as p join product_type as
 pt on p.type_id = pt.id where p.type_id < 10;

select * from product as p join product_type as
 pt on p.type_id = pt.id;
