create database truyum;

use truyum;

create table MenuItems (
item_id int auto_increment primary key,
item_name varchar(25) not null,
price float(2) not null,
item_active boolean not null,
date_of_launch date not null,
category varchar(25) not null,
free_delivery boolean not null
);

insert into MenuItems (item_name, price, item_active, date_of_launch, category, free_delivery) values (
"Sandwich", 99.00, true, "2017-03-15", "Main Course", true);
insert into MenuItems (item_name, price, item_active, date_of_launch, category, free_delivery) values (
"Burger", 129.00, true, "2017-12-23", "Main Course", false);
insert into MenuItems (item_name, price, item_active, date_of_launch, category, free_delivery) values (
"Pizza", 149.00, true, "2017-08-21", "Main Course", false);
insert into MenuItems (item_name, price, item_active, date_of_launch, category, free_delivery) values (
"French Fries", 57.00, false, "2017-07-02", "Starters", true);
insert into MenuItems (item_name, price, item_active, date_of_launch, category, free_delivery) values (
"Chocolate Brownie", 32.00, true, "2022-11-02", "Dessert", true);
