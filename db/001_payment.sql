create table `payment`(
`id` bigint(20) not null auto_increment comment 'id',
`serial` varchar(200) default '',
primary key (`id`)
) engine = innodb auto_increment=1 default charset=utf8mb4;

insert into `payment`(serial) values('1111');
insert into `payment`(serial) values('2222');