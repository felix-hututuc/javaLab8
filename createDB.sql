drop table continents;
drop table countries;

create table continents (
    id serial primary key ,
    name VARCHAR(20)
    );

create table countries (
    id serial primary key ,
    name VARCHAR(20) ,
    code INTEGER ,
    continent VARCHAR(20)
);

create table city (
    id serial primary key ,
    name VARCHAR(20) ,
    country VARCHAR(20) ,
    capital boolean default false ,
    latitude decimal(8, 6) ,
    longitude decimal(9, 6)
)