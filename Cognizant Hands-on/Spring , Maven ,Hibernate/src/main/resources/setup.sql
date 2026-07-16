create schema if not exists ormlearn;

use ormlearn;

create table if not exists country (
    co_code varchar(2) primary key,
    co_name varchar(50)
);

create table if not exists stock (
    st_id int not null auto_increment,
    st_code varchar(10),
    st_date date,
    st_open numeric(10,2),
    st_close numeric(10,2),
    st_volume numeric,
    primary key (st_id)
);

create table if not exists department (
    dp_id int not null auto_increment,
    dp_name varchar(50),
    primary key (dp_id)
);

create table if not exists employee (
    em_id int not null auto_increment,
    em_name varchar(100),
    em_salary double,
    em_permanent tinyint(1),
    em_date_of_birth date,
    em_dp_id int,
    primary key (em_id),
    foreign key (em_dp_id) references department(dp_id)
);

create table if not exists skill (
    sk_id int not null auto_increment,
    sk_name varchar(50),
    primary key (sk_id)
);

create table if not exists employee_skill (
    es_em_id int,
    es_sk_id int,
    primary key (es_em_id, es_sk_id),
    foreign key (es_em_id) references employee(em_id),
    foreign key (es_sk_id) references skill(sk_id)
);

insert into country values ('IN', 'India');
insert into country values ('US', 'United States');

insert into department (dp_name) values ('Engineering');
insert into department (dp_name) values ('HR');
insert into department (dp_name) values ('Finance');

insert into skill (sk_name) values ('Java');
insert into skill (sk_name) values ('Python');
insert into skill (sk_name) values ('SQL');

insert into employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
values ('Alice', 75000, 1, '1990-05-10', 1);

insert into employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
values ('Bob', 60000, 0, '1993-08-22', 1);

insert into employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
values ('Charlie', 55000, 1, '1988-11-15', 2);

insert into employee_skill values (1, 1);
insert into employee_skill values (1, 2);
insert into employee_skill values (2, 3);
