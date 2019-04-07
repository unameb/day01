/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50714
Source Host           : 127.0.0.1:3306
Source Database       : buses

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-04-07 19:58:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for back
-- ----------------------------
DROP TABLE IF EXISTS `back`;
CREATE TABLE `back` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) DEFAULT NULL,
  `bid` int(11) DEFAULT NULL,
  `income` double DEFAULT NULL,
  `consumption` double DEFAULT NULL,
  `run` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `bshow` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_back_bid` (`bid`),
  KEY `fk_back_did` (`did`),
  CONSTRAINT `fk_back_bid` FOREIGN KEY (`bid`) REFERENCES `bus` (`id`),
  CONSTRAINT `fk_back_did` FOREIGN KEY (`did`) REFERENCES `info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of back
-- ----------------------------
INSERT INTO `back` VALUES ('1', '23', '11', '2565', '30', '30', '2019-04-07 00:00:00', '1');
INSERT INTO `back` VALUES ('2', '101', '87686', '2389', '54', '60', '2019-03-12 17:40:37', '1');
INSERT INTO `back` VALUES ('3', '103', '87686', '2234', '56', '34', '2019-03-12 17:41:19', '1');
INSERT INTO `back` VALUES ('4', '102', '32732', '1233', '67', '89', '2019-03-12 17:41:45', '0');
INSERT INTO `back` VALUES ('5', '103', '32732', '3434.9', '56.9', '56', null, '0');
INSERT INTO `back` VALUES ('6', '103', '32732', '23', '34', '45', null, '1');

-- ----------------------------
-- Table structure for bus
-- ----------------------------
DROP TABLE IF EXISTS `bus`;
CREATE TABLE `bus` (
  `id` int(11) NOT NULL,
  `rid` int(255) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `sid` int(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `safeid` varchar(255) DEFAULT NULL,
  `stime` datetime DEFAULT NULL,
  `etime` datetime DEFAULT NULL,
  `update` datetime DEFAULT NULL,
  `bshow` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_bus_rid` (`rid`),
  KEY `kf_bus_sid` (`sid`),
  CONSTRAINT `fk_bus_rid` FOREIGN KEY (`rid`) REFERENCES `road` (`id`),
  CONSTRAINT `kf_bus_sid` FOREIGN KEY (`sid`) REFERENCES `state` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bus
-- ----------------------------
INSERT INTO `bus` VALUES ('11', '2', 'rg', '3', 're', 'fre', '2019-04-02 00:00:00', '2019-04-20 00:00:00', '2019-04-06 16:09:34', '1');
INSERT INTO `bus` VALUES ('2343', '2', 'df', '1', 'cdf', 'vdf', '2910-03-02 00:00:00', '2039-05-04 00:00:00', '2019-04-06 16:00:44', '0');
INSERT INTO `bus` VALUES ('32732', '2', '天津公交', '1', '津A2343', '123', '2019-04-03 00:00:00', '2019-04-11 00:00:00', '2019-03-12 16:51:33', '1');
INSERT INTO `bus` VALUES ('33442', '10005', '天津公交', '1', '津A4546', '23233', '2019-03-12 16:54:29', '2020-03-12 16:54:33', '2019-03-12 16:54:41', '1');
INSERT INTO `bus` VALUES ('36556', '10001', '天津公交', '3', '津A167', '7544343', '2019-03-12 16:55:10', '2020-03-12 16:55:12', '2019-03-12 16:55:20', '1');
INSERT INTO `bus` VALUES ('87686', '10006', '天津公交', '2', '津A8789', '4565656', '2019-03-12 16:56:06', '2020-03-12 16:56:08', '2019-03-12 16:56:15', '0');

-- ----------------------------
-- Table structure for buy
-- ----------------------------
DROP TABLE IF EXISTS `buy`;
CREATE TABLE `buy` (
  `id` varchar(255) NOT NULL,
  `partName` varchar(255) DEFAULT NULL,
  `partPrice` decimal(10,2) DEFAULT NULL,
  `partNum` int(11) DEFAULT NULL,
  `sumPrice` decimal(10,2) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `bshow` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `partName` (`partName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buy
-- ----------------------------
INSERT INTO `buy` VALUES ('1032', '公交车车载摄像头', '1200.00', '103', '123600.00', '2019-03-12 16:57:37', '1');
INSERT INTO `buy` VALUES ('2434E', 'MP3公交车报站器', '68.00', '30', '2040.00', '2019-03-12 17:00:04', '0');
INSERT INTO `buy` VALUES ('802E', '公交车门把手', '20.00', '20', '400.00', '2019-03-12 16:57:58', '1');
INSERT INTO `buy` VALUES ('AW234', '公交车吊环', '5.00', '150', '750.00', '2019-03-12 16:59:38', '1');
INSERT INTO `buy` VALUES ('fr34', '说书人', '12.00', '23', '276.00', '2019-04-05 21:21:02', '1');
INSERT INTO `buy` VALUES ('JS209', '公交车小号螺丝', '0.50', '200', '100.00', '2019-03-12 16:58:17', '1');
INSERT INTO `buy` VALUES ('JS30', '公交车雨刷', '24.00', '15', '360.00', '2019-03-12 16:58:36', '1');
INSERT INTO `buy` VALUES ('P233', '公交车垃圾桶', '10.00', '23', '230.00', '2019-03-12 16:59:00', '1');
INSERT INTO `buy` VALUES ('r4r', 'erer', '34.00', '3', '102.00', '2019-04-06 15:14:57', '1');
INSERT INTO `buy` VALUES ('SD890', '公交车座椅', '312.00', '12', '3744.00', '2019-03-12 16:59:19', '1');
INSERT INTO `buy` VALUES ('uj456', '时代大厦', '23.90', '23', '549.70', '2019-04-07 14:41:10', '1');

-- ----------------------------
-- Table structure for fix
-- ----------------------------
DROP TABLE IF EXISTS `fix`;
CREATE TABLE `fix` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT NULL,
  `driverid` int(11) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `cost` decimal(10,2) DEFAULT NULL,
  `partName` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `fshow` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_fix_bid` (`bid`),
  KEY `fk_fix_driverid` (`driverid`),
  KEY `fk_fix_partName` (`partName`),
  CONSTRAINT `fk_fix_bid` FOREIGN KEY (`bid`) REFERENCES `bus` (`id`),
  CONSTRAINT `fk_fix_driverid` FOREIGN KEY (`driverid`) REFERENCES `info` (`id`),
  CONSTRAINT `fk_fix_partName` FOREIGN KEY (`partName`) REFERENCES `stock` (`partName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fix
-- ----------------------------
INSERT INTO `fix` VALUES ('1', '11', '23', '', '0.00', '公交车车载摄像头', '2', '2019-04-07 00:00:00', '1');
INSERT INTO `fix` VALUES ('4', '32732', '103', 'xx修理厂', '234.00', '公交车门把手', '4', '2019-04-07 17:28:25', '1');
INSERT INTO `fix` VALUES ('5', '32732', '101', '还以为传统', '345.00', 'MP3公交车报站器', '2', '2019-04-07 00:00:00', '1');

-- ----------------------------
-- Table structure for gas
-- ----------------------------
DROP TABLE IF EXISTS `gas`;
CREATE TABLE `gas` (
  `id` int(11) NOT NULL,
  `income` double(255,0) DEFAULT NULL,
  `outcome` double(255,0) DEFAULT NULL,
  `gas` decimal(10,0) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `gshow` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gas
-- ----------------------------
INSERT INTO `gas` VALUES ('2233', '345', '12', '45', '2019-04-07 00:00:00', '1');
INSERT INTO `gas` VALUES ('3443', '1222', '32', '23', '2019-04-07 00:00:00', '1');
INSERT INTO `gas` VALUES ('22343', '1444', '35', '45', '2019-03-12 17:26:35', '0');

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` int(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `ishow` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('23', 'tg', '1', '34', '34354', '2019-04-06 15:15:58', '1');
INSERT INTO `info` VALUES ('101', '旺达', '1', '43543534', '34', '2019-03-12 16:07:35', '1');
INSERT INTO `info` VALUES ('102', '蓝莓', '1', '', '27', '2019-03-12 16:08:30', '1');
INSERT INTO `info` VALUES ('103', '草莓', '0', '243545', '38', '2019-03-12 16:09:04', '0');

-- ----------------------------
-- Table structure for main
-- ----------------------------
DROP TABLE IF EXISTS `main`;
CREATE TABLE `main` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `pid` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `did` int(11) NOT NULL,
  `oid` int(11) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of main
-- ----------------------------
INSERT INTO `main` VALUES ('1', '业务管理', '0', null, null, '1', '8', '2019-03-12 16:10:10');
INSERT INTO `main` VALUES ('2', '车辆管理', '0', null, null, '1', '5', '2019-03-12 16:10:33');
INSERT INTO `main` VALUES ('3', '员工管理', '0', null, null, '1', '4', '2019-03-12 16:10:57');
INSERT INTO `main` VALUES ('4', '油卡管理', '0', null, null, '1', '3', '2019-03-12 16:12:06');
INSERT INTO `main` VALUES ('5', '费用管理', '0', null, null, '0', '2', '2019-03-12 16:12:25');
INSERT INTO `main` VALUES ('11', '线路管理', '1', 'road.html', 'glyphicon glyphicon-menu-hamburger', '1', '5', '2019-03-12 16:14:11');
INSERT INTO `main` VALUES ('12', '排班管理', '1', 'turn.html', 'glyphicon glyphicon-menu-hamburger', '1', '4', '2019-03-12 16:14:39');
INSERT INTO `main` VALUES ('13', '回车登记', '1', 'back.html', 'glyphicon glyphicon-menu-hamburger', '1', '3', '2019-03-12 16:15:15');
INSERT INTO `main` VALUES ('21', '车辆管理', '2', 'buslg.html', 'glyphicon glyphicon-menu-hamburger', '1', '5', '2019-03-12 16:15:47');
INSERT INTO `main` VALUES ('22', '维修登记', '2', 'fixlg.html', 'glyphicon glyphicon-menu-hamburger', '1', '4', '2019-03-12 16:16:19');
INSERT INTO `main` VALUES ('23', '配件采购', '2', 'buy.html', 'glyphicon glyphicon-menu-hamburger', '1', '3', '2019-03-12 16:16:53');
INSERT INTO `main` VALUES ('24', '配件库存', '2', 'stock.html', 'glyphicon glyphicon-menu-hamburger', '1', '2', '2019-03-12 16:17:21');
INSERT INTO `main` VALUES ('31', '员工信息', '3', 'info.html', 'glyphicon glyphicon-user', '1', '2', '2019-03-12 16:17:57');
INSERT INTO `main` VALUES ('41', '加油登记', '4', 'gas.html', 'glyphicon glyphicon-filter', '1', '2', '2019-03-12 16:19:11');
INSERT INTO `main` VALUES ('51', '采购结算', '5', 'buysum.html', 'glyphicon glyphicon-usd', '0', '5', '2019-03-12 16:25:22');
INSERT INTO `main` VALUES ('52', '加油结算', '5', 'gassum.html', 'glyphicon glyphicon-usd', '0', '4', '2019-03-12 16:26:01');
INSERT INTO `main` VALUES ('53', '维修结算', '5', 'fixsum.html', 'glyphicon glyphicon-usd', '0', '3', '2019-03-12 16:26:28');
INSERT INTO `main` VALUES ('54', '工资管理', '5', null, 'glyphicon glyphicon-usd', '0', '2', '2019-03-12 16:26:58');

-- ----------------------------
-- Table structure for road
-- ----------------------------
DROP TABLE IF EXISTS `road`;
CREATE TABLE `road` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start` varchar(255) DEFAULT NULL,
  `end` varchar(255) DEFAULT NULL,
  `length` double DEFAULT NULL,
  `stime` varchar(255) DEFAULT NULL,
  `etime` varchar(255) DEFAULT NULL,
  `sale` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `rshow` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of road
-- ----------------------------
INSERT INTO `road` VALUES ('2', 'wefve', '34', '23', '23', '23', '232', '3', '2019-04-05 16:43:28', '1');
INSERT INTO `road` VALUES ('89', 'eed', 'de', 'ed', '23', '32', '32', '3', '2019-04-06 15:13:50', '1');
INSERT INTO `road` VALUES ('10001', '175路', '杨柳青得分得到', '下瓦房公交站d', '30', '06:00', '20:00', '2', '2019-03-12 16:29:11', '1');
INSERT INTO `road` VALUES ('10002', '638路', '海泰南公交站', '天津站', '37', '06:00', '21:00', '3', '2019-03-12 16:30:57', '1');
INSERT INTO `road` VALUES ('10003', '700路', '辰兴路公交站', '海泰北公交站', '23', '06:00', '21:30', '2', '2019-03-12 16:33:59', '1');
INSERT INTO `road` VALUES ('10004', '707路', '张家窝泰里', '海光寺公交站', '56', '05:30', '20:15', '3', '2019-03-12 16:34:43', '1');
INSERT INTO `road` VALUES ('10005', '3路', '跃升里公交站', '下瓦房公交站', '45', '05:00', '22:40', '3', '2019-03-12 16:35:22', '0');
INSERT INTO `road` VALUES ('10006', '800路', '渌水道站', '本溪路站', '23', '05:50', '22:00', '2', '2019-03-12 16:36:03', '0');

-- ----------------------------
-- Table structure for state
-- ----------------------------
DROP TABLE IF EXISTS `state`;
CREATE TABLE `state` (
  `id` int(11) NOT NULL,
  `sname` varchar(255) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of state
-- ----------------------------
INSERT INTO `state` VALUES ('1', '出车', '2019-03-12 16:49:40');
INSERT INTO `state` VALUES ('2', '可用', '2019-03-12 16:49:51');
INSERT INTO `state` VALUES ('3', '维修', '2019-03-12 16:49:58');

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` varchar(255) DEFAULT NULL,
  `partName` varchar(255) DEFAULT NULL,
  `sum` int(255) DEFAULT NULL,
  `sshow` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_stock_pid` (`pid`),
  KEY `fk_stock_name` (`partName`),
  CONSTRAINT `fk_stock_name` FOREIGN KEY (`partName`) REFERENCES `buy` (`partName`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_stock_pid` FOREIGN KEY (`pid`) REFERENCES `buy` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('1', '1032', '公交车车载摄像头', '100', '1');
INSERT INTO `stock` VALUES ('2', '2434E', 'MP3公交车报站器', '128', '1');
INSERT INTO `stock` VALUES ('3', '802E', '公交车门把手', '100', '0');
INSERT INTO `stock` VALUES ('5', 'uj456', '时代大厦', '23', '1');

-- ----------------------------
-- Table structure for turn
-- ----------------------------
DROP TABLE IF EXISTS `turn`;
CREATE TABLE `turn` (
  `id` int(11) NOT NULL,
  `driver` int(255) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `station` varchar(255) DEFAULT NULL,
  `tshow` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_turn_driver` (`driver`),
  KEY `fk_turn_rid` (`rid`),
  CONSTRAINT `fk_turn_driver` FOREIGN KEY (`driver`) REFERENCES `info` (`id`),
  CONSTRAINT `fk_turn_rid` FOREIGN KEY (`rid`) REFERENCES `road` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of turn
-- ----------------------------
INSERT INTO `turn` VALUES ('1', '101', '10002', '2019-03-14 07:41:11', '杨柳青', '0');
INSERT INTO `turn` VALUES ('2', '23', '2', '2019-04-12 00:00:00', '天津站', '1');
INSERT INTO `turn` VALUES ('3', '103', '10005', '2019-03-12 16:42:22', '下瓦房公交站', '1');
INSERT INTO `turn` VALUES ('4', '101', '10002', '2019-04-06 00:00:00', 'dfg', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(11) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `upass` varchar(255) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('A101', 'admin', '123', '2019-03-12 19:26:28');
