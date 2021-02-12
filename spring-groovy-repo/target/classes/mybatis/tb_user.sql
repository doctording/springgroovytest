CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `phone` varchar(255) NOT NULL DEFAULT '' COMMENT '电话',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
insert into tb_user values(1,1001,'123456','zhang','15143219876','beijing');