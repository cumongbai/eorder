DROP DATABASE IF EXISTS eorder;
CREATE DATABASE eorder character set utf8;
USE eorder;
CREATE TABLE order_user(
userid varchar(13),
username varchar(20) NOT NULL,
password varchar(30) NOT NULL,
roleid char(3) NOT NULL,
PRIMARY KEY (userid)
);
insert into order_user values('12321372511045','test','test','001');

CREATE TABLE role(
roleid char(3) PRIMARY KEY,
roleName varchar(10) NOT NULL);
insert into role values('001','admin');

CREATE TABLE authority(
authoid varchar(5) PRIMARY KEY,
authoType char(2) NOT NULL,
authoUrl varchar(25) NOT NULL);

CREATE TABLE user_info(
userid varchar(13) PRIMARY KEY,
mobileNum varchar(13) NOT NULL,
address varchar(15) NOT NULL,
photoUrl varchar(25));

insert into user_info values ('12321372511045','15876543298','mango street no. 5',null);

CREATE TABLE role_authority(
id varchar(6) PRIMARY KEY,
roleid varchar(3) NOT NULL,
authoid varchar(5) NOT NULL);

CREATE TABLE restaurant(
restaurantid varchar(5) PRIMARY KEY,
name varchar(20) NOT NULL,
boss varchar(13) NOT NULL,
address varchar(40),
info varchar(150),
photoUrl varchar(30));

CREATE TABLE menu(
menuid SMALLINT AUTO_INCREMENT PRIMARY KEY,
foodName varchar(20) NOT NULL,
price SMALLINT NOT NULL,
restaurantid varchar(5));

CREATE TABLE areas(
areaid varchar(3) PRIMARY KEY,
areaName varchar(20) NOT NULL);

CREATE TABLE building(
buildingid varchar(2) PRIMARY KEY,
name varchar(8),
areaid varchar(3) NOT NULL);

CREATE TABLE sysorder(
orderid varchar(15) PRIMARY KEY,
orderTime time  NOT NULL,
custid varchar(13) NOT NULL,
restaurantid varchar(4) NOT NULL,
money SMALLINT DEFAULT 0,
statues varchar(1));

CREATE TABLE orderedfood(
id int AUTO_INCREMENT PRIMARY KEY,
orderid varchar(15) NOT NULL,
menuid SMALLINT,
foodCount SMALLINT DEFAULT 1,
foodType varchar(1) DEFAULT '1');

CREATE TABLE task(
taskid int AUTO_INCREMENT PRIMARY KEY,
orderid varchar(15) NOT NULL,
delever varchar(13) NOT NULL,
statues varchar(1) DEFAULT '0');