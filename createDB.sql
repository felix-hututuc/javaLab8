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

create table cities (
    id serial primary key ,
    name VARCHAR(20) ,
    country VARCHAR(20) ,
    capital boolean default false
)