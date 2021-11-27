many-to-one

create table maleBiologicalParent(
    id serial primary key,
    name varchar(255),
    dna int
);
create table firstBiologicalChild(
    id serial primary key,
    name varchar(255),
    dna int,
    maleBiologicalParent_id int references maleBiologicalParent(id)
);
create table secondBiologicalChild(
    id serial primary key,
    name varchar(255),
    dna int,
    maleBiologicalParent_id int references maleBiologicalParent(id)
);

one-to-one

create table passport(
    id serial primary key,
    numberPassport int,
);
create table dna(
    id serial primary key,
    dna int,
    dna_id int references passport(id) unique
);

many-to-many

create table clubsOfUEFA(
     id serial primary key,
     teamName varchar(50),
     countries_id int references countries(id),
     soccerClub_id int references soccerClubs(id)
 );
 create table countries(
    id serial primary key,
     name varchar(255)
 );
create table soccerClubs(
    id serial primary key,
     name varchar(255)
 );


