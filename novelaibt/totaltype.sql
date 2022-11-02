/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80029
Source Host           : localhost:3306
Source Database       : aitag

Target Server Type    : MYSQL
Target Server Version : 80029
File Encoding         : 65001

Date: 2022-11-02 09:25:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for totaltype
-- ----------------------------
DROP TABLE IF EXISTS `totaltype`;
CREATE TABLE `totaltype` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '总类型id',
  `tagList` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '总类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of totaltype
-- ----------------------------
INSERT INTO `totaltype` VALUES ('1', '人物样貌');
INSERT INTO `totaltype` VALUES ('2', '服装类型');
INSERT INTO `totaltype` VALUES ('3', '人物画风');
INSERT INTO `totaltype` VALUES ('4', '环境样式');
