create table role(
    id serial primary key,
    function varchar(255)
);
create table users(
    id serial primary key,
    name varchar(255),
    role_id int references role(id)

);
create table rules(
     id serial primary key,
     rule varchar(255)
 );
create table rules_role(
     id serial primary key,
     rules_id int references rules(id),
     role_id int references role(id)
 );
create table category(
id serial primary key,
     category_name varchar(255)
 );
create table state(
     id serial primary key,
     position int
 );
create table item(
     id serial primary key,
     message varchar(255),
     users_id int references users(id),
     category_id int references category(id),
     state_id int references state(id)
 );
create table comments(
     comment varchar(255),
     id serial primary key,
     item_id int references item(id)
 );
create table attachs(
     id serial primary key,
     new_attach varchar(255),
     item_id int references item(id)
 );
