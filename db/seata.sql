CREATE TABLE t_order(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	user_id BIGINT,
	product_id BIGINT,
	`count` INT,
	money DECIMAL,
	`status` int
) ENGINE=INNODB AUTO_INCREMENT = 7 DEFAULT CHARSET = utf8;

create table t_storage(
    id bigint auto_increment primary key ,
    product_id bigint,
    total int,
    userd int,
    residue int
) engine = innodb auto_increment = 2 default charset = utf8;

insert into t_storage(id, product_id, total, userd, residue)
values (1, 1, 100, 0, 100);

create table t_account(
    id bigint auto_increment primary key ,
    user_id bigint,
    total decimal,
    used decimal,
    residue decimal
) engine = innodb auto_increment = 2 default charset = utf8;
insert into t_account(id, user_id, total, used, residue) values (1,1,1000,0,1000);

CREATE TABLE `undo_log` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id` bigint(20) NOT NULL,
    `xid` varchar(100) NOT NULL,
    `context` varchar(128) NOT NULL,
    `rollback_info` longblob NOT NULL,
    `log_status` int(11) NOT NULL,
    `log_created` datetime NOT NULL,
    `log_modified` datetime NOT NULL,
    `ext` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;