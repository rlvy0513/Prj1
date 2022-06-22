create table notices(
seq varchar2(10),
title varchar2(100),
writer varchar2(30),
content varchar2(300),
regdate date,
hit number);



-----------------------
create table board(
bno varchar2(10),
bsubj varchar2(200),
bwriter varchar2(50),
bmemo varchar2(500),
bdate date,
bcnt number);

select * from board;

insert into board(bno,bsubj,bwriter,bmemo,bdate,bcnt) values();

-------------------------
create table nmember(
id varchar2(50),
pwd varchar2(50),
name varchar2(50),
gender varchar2(10),
birth varchar2(10),
is_lunar varchar2(10),
cphone varchar2(15),
email varchar2(50),
habit varchar2(200),
regdate date);

select * from nmember;

--------------------
create table nmember2(
tid varchar2(50),
tpwd varchar2(50),
tname varchar2(50),
tgender varchar2(10),
tbirth varchar2(10),
tis_lunar varchar2(10),
tcphone varchar2(15),
temail varchar2(50),
thabit varchar2(200),
tregdate date);
insert into nmember2(tid,tpwd,tname,tgender,tbirth,tis_lunar,tcphone,temail,thabit,tregdate)
values('blue','111','hong','남성','2000-05-05','solar','010-1111-3333','a@b.com','movie',sysdate);
commit;
select * from nmember2;