DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `goods`;
DROP TABLE IF EXISTS `order_goods`;

create table `order` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`order_number` varchar(50) not null,
	`delivery_address` varchar(100) not null,
  `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
);

create table `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_code` varchar(50) not null,
  `goods_name` varchar(50) not null,
  `price` double not null,
  `create_time` timestamp not null DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
);

create table `order_goods` (
	`order_id` bigint(20) not null,
	`goods_id` bigint(20) not null,
	foreign key(`order_id`) references `order`(`id`),	
	foreign key(`goods_id`) references `goods`(`id`)
);