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
    position_id int references position(id)
);
create table secondBiologicalChild(
    id serial primary key,
    name varchar(255),
    dna int,
    position_id int references position(id)
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

create table soccerTeams(
     id serial primary key,
     teamName varchar(50),
     soccerPlayer_id int references soccerPlayers(id),
     soccerClub_id int references soccerClubs(id)
 );
 create table soccerPlayers(
    id serial primary key,
     name varchar(255)
 );
create table soccerClubs(
    id serial primary key,
     name varchar(255)
 );


