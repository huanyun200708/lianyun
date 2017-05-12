/*
Navicat MySQL Data Transfer

Source Server         : LocalDB
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : huangqidb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-12 21:53:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `onboardinfo`
-- ----------------------------
DROP TABLE IF EXISTS `onboardmessage`;
CREATE TABLE `onboardmessage` (
  `id` varchar(128) NOT NULL,
  `accountname` varchar(128) DEFAULT NULL,
  `accountphone` varchar(20) DEFAULT NULL,
  `appointtime` varchar(128) DEFAULT NULL,
  `onboardtime` varchar(128) DEFAULT NULL,
  `onboardaddress` varchar(4000) DEFAULT NULL,
  `appointstatus` varchar(1) DEFAULT NULL,
  `onboardstatus` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of onboardinfo
-- ----------------------------
