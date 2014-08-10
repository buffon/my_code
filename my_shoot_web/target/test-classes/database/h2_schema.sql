SET MODE MYSQL;

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL DEFAULT '',
  `sex` smallint(1) unsigned NOT NULL DEFAULT '0',
  `common` char(50) NOT NULL DEFAULT '',
  `created_by` varchar(20) NOT NULL DEFAULT '',
  `created_time` int(10) NOT NULL,
  `age` int(10) NOT NULL,
  PRIMARY KEY (`id`)
);