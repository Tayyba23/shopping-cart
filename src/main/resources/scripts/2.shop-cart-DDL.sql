USE shop;
CREATE TABLE `cart` (
  `cart_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(120),
  `created_at` DATETIME,
  `updated_at` DATETIME,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
