create sequence hibernate_sequence start 1 increment 1;

create table clients
(
    id          int8 not null,
    email       varchar(255),
    first_name  varchar(255),
    last_name   varchar(255),
    middle_name varchar(255),
    phone       varchar(255),
    primary key (id)
);
