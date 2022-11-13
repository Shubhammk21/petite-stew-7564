create database  Unit_5_HRMS;
use Unit_5_HRMS;


create table department(
    departmentId int primary key,
    department_name varchar(20) not null,
    location varchar(60)
);

create table Admin(
    id int primary key auto_increment unique,
    name varchar(30),
    post varchar(30),
    username varchar(30) not null,
    password varchar(30) not null
);

insert into admin(name,post,username,password) values('Shubham singh','CEO','shubham','mp21mk');

create table Employes(
    EmployesId int Primary key auto_increment,
    name varchar(30),
    age int,
    email varchar(40),
    address varchar(60),
    Phone_number bigint(10),
    salary int,
    departmentid int,
    username varchar(30),
    password varchar(20),
    working_status varchar(40),
    leave_request varchar(20),
    joining_date date,
    foreign key(departmentid) references department(departmentid)
);

create table leaves(
    EmployesId int unique not null,
    name varchar(30),
    departmentid int,
    Duration int,
    startdate date,
    enddate date,
    leave_request varchar(20),
    foreign key(EmployesId) references Employes(EmployesId),
    foreign key(departmentid) references department(departmentid)
);