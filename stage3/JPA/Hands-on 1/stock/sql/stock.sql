create schema stock;
use stock;

create table stock(
st_id int auto_increment primary key,
st_date  date,
st_code varchar(10),
st_open float,
st_close float,
st_volume bigint
);

insert into stock (st_date,st_code,st_open,st_close,st_volume)values
("2019-09-08","FB",1001.1,1010.2,2300231);
insert into stock (st_date,st_code,st_open,st_close,st_volume)values
("2019-09-18","FB",1011.1,1020.2,2300451);
insert into stock (st_date,st_code,st_open,st_close,st_volume)values
("2018-09-18","GOOGL",1011.1,1265.2,3300451);
insert into stock (st_date,st_code,st_open,st_close,st_volume)values
("2018-11-18","GOOGL",1249.1,1255.2,3600451);
insert into stock (st_date,st_code,st_open,st_close,st_volume)values
("2019-09-02","GOOGL",1261.1,1275.2,3700451);
insert into stock (st_date,st_code,st_open,st_close,st_volume)values
("2019-09-02","GOOGL",1261.1,1275.2,3700451);
insert into stock (st_date,st_code,st_open,st_close,st_volume)values
("2020-02-02","NFLX",951.5,1000.2,1800451);
insert into stock (st_date,st_code,st_open,st_close,st_volume)values
("2020-03-03","NFLX",861.5,998.2,200451);
insert into stock (st_date,st_code,st_open,st_close,st_volume)values
("2020-05-12","NFLX",1051.5,1049.2,201051);



