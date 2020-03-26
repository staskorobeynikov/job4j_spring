drop table if exists accidents;

create table accidents(
	id serial primary key not null,
	name varchar(50) not null,
	text varchar(250) not null,
	address varchar(100) not null
);

insert into accidents(name, text, address) values('name', 'text', 'address');
insert into accidents(name, text, address) values('name1', 'text1', 'address1');
insert into accidents(name, text, address) values('name2', 'text2', 'address2');