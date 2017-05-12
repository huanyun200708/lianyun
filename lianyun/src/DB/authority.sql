/*
Navicat MySQL Data Transfer

Source Server         : LocalDB
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : huangqidb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-12 19:07:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `accountid` varchar(128) NOT NULL,
  `roleId` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `authority` VALUES ('oIIwa0dLeUmRnxopIKTEHjLX0m5k', '01');
INSERT INTO `authority` VALUES ('oIIwa0S5X92Nz6zvTb-EGAYS80gw', '01');