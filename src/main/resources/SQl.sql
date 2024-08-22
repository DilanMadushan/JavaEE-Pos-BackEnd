create table customer(
    id varchar(100)primary key,
    name varchar(100),
    address varchar(100),
    tel varchar(10)
);

create table product(
    id varchar(100)primary key,
    name varchar(100)not null ,
    price double not null,
    qty double not null
);