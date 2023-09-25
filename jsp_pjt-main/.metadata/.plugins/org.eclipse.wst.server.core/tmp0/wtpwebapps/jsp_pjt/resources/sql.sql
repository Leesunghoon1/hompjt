create table board(
bno int auto_increment,
title varchar(200) not null,
writer varchar(100) not null,
content text,
regdate datetime default now(),
moddate datetime default now(),
primary key(bno));


create table member(
id varchar(100),
pwd varchar(100) not null,
email varchar(100) not null,
pnum int default 0,
age int default 0,
regdate datetime default now(),
lastlogin datetime default now(),
primary key(id));


