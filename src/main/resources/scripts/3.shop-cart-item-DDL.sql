USE shop;
CREATE TABLE `item` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `item_name` varchar(120),
  `cart_id` int(11) unsigned NOT NULL,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  PRIMARY KEY (`id`),
  KEY `cart_id` (`cart_id`),
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `Cart` (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
