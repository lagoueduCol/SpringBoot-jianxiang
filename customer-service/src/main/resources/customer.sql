DROP TABLE IF EXISTS `intervention`;

CREATE TABLE `intervention`
(
  id              BIGINT(20) PRIMARY KEY NOT NULL,
  account_id   BIGINT(20) NOT NULL,
  order_number          varchar(50) NOT NULL,
  description varchar(255) DEFAULT NULL,  
  create_time      TIMESTAMP NOT NULL,
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


