CREATE TABLE `tb_user` (
  `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `create_time` bigint(20) unsigned not null comment '创建时间',
  `update_time` bigint(20) unsigned not null comment '创建时间',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

create table `tb_order` (
  `order_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `price` decimal(12, 4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
  `count` int(11) unsigned NOT NULL DEFAULT 1 COMMENT '件数',
  `total_price` decimal(12, 4) not null DEFAULT '0.0000' comment '总价',
  `state` tinyint(3) not null DEFAULT '1' comment '0 -> 未支付， 1 -> 已支付， 2-> 已发货， 3 -> 已收货',
  `item_id` bigint(20) unsigned not null comment '商品id',
  `user_id` bigint(20) unsigned not null comment '用户id',
  `create_time` bigint(20) unsigned not null comment '创建时间',
  `update_time` bigint(20) unsigned not null comment '创建时间',
  KEY `idx_user` (`user_id`),
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

create table `tb_product` (
  `item_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `price` decimal(12, 4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
  `name` varchar(50) not null DEFAULT '' comment '商品名称',
  `content` text comment '内容简介',
  `create_time` bigint(20) unsigned not null comment '创建时间',
  `update_time` bigint(20) unsigned not null comment '创建时间',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8mb4 COMMENT='产品表';

create table `tb_product_snapshot` (
  `snapshot_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
   `order_id` bigint(20) unsigned NOT NULL comment '订单id',
  `price` decimal(12, 4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
  `name` varchar(50) not null DEFAULT '' comment '商品名称',
  `content` text comment '内容简介',
  `create_time` bigint(20) unsigned not null comment '创建时间',
  `update_time` bigint(20) unsigned not null comment '创建时间',
  key `idx_order` (`order_id`),
  PRIMARY KEY (`snapshot_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8mb4 COMMENT='订单产品快照表';