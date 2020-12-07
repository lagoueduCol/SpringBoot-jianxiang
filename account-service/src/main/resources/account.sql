DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_code` varchar(20) DEFAULT NULL,
  `account_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES ('1', 'account1', 'springcss_account1');
INSERT INTO `user` VALUES ('2', 'account2', 'springcss_account2');