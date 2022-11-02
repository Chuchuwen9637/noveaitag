/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80029
Source Host           : localhost:3306
Source Database       : aitag

Target Server Type    : MYSQL
Target Server Version : 80029
File Encoding         : 65001

Date: 2022-11-02 09:25:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authortag
-- ----------------------------
DROP TABLE IF EXISTS `authortag`;
CREATE TABLE `authortag` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '无意义自增长',
  `author` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `url` varchar(5024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tag` varchar(5024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `negativetag` varchar(5024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SamplingSteps` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of authortag
-- ----------------------------
INSERT INTO `authortag` VALUES ('5', '三笠', 'http://rjsum4lnm.hn-bkt.clouddn.com/890b2043-1c96-442a-82c4-4541ae46b89a', '{{masterpiece}},best quality,1girl,solo,illustration,ahoge,young loli,gradient white hair,longhair,{{beautiful detailed eyes}}', 'lowres, bad anatomy, bad hands, text, error, missing fingers, extra digit, fewer digits, cropped, worst quality, low quality, normal quality, jpeg artifacts, signature, watermark, username, blurry', '50');
INSERT INTO `authortag` VALUES ('6', '三笠', 'http://rjsum4lnm.hn-bkt.clouddn.com/c49ffe7e-dcac-45c2-b8f7-49321fd8dd78', '{{masterpiece}},best quality,1girl,solo,illustration,ahoge,young loli,gradient white hair,longhair,{{beautiful detailed eyes}', 'lowres, bad anatomy, bad hands, text, error, missing fingers, extra digit, fewer digits, cropped, worst quality, low quality, normal quality, jpeg artifacts, signature, watermark, username, blurry', '50');
INSERT INTO `authortag` VALUES ('7', '三笠', 'http://rjsum4lnm.hn-bkt.clouddn.com/f193aa26-f612-4b1b-8c90-88285df3cf03', '{{masterpiece}},best quality,1girl,solo,illustration,ahoge,young loli,gradient white hair,longhair,{{beautiful detailed eyes}}', 'lowres, bad anatomy, bad hands, text, error, missing fingers, extra digit, fewer digits, cropped, worst quality, low quality, normal quality, jpeg artifacts, signature, watermark, username, blurry', '50');
INSERT INTO `authortag` VALUES ('8', '三笠', '', '{{masterpiece}},best quality,1girl,solo,illustration,ahoge,young loli,gradient white hair,longhair,{{beautiful detailed eyes}},', 'lowres, bad anatomy, bad hands, text, error, missing fingers, extra digit, fewer digits, cropped, worst quality, low quality, normal quality, jpeg artifacts, signature, watermark, username, blurry', '50');
INSERT INTO `authortag` VALUES ('9', '三笠', 'http://rjsum4lnm.hn-bkt.clouddn.com/77b1511e-460e-4e53-94d3-b44199320edb', '{{masterpiece}},best quality,1girl,solo,illustration,ahoge,young loli,gradient white hair,longhair,{{beautiful detailed eyes}},', 'lowres, bad anatomy, bad hands, text, error, missing fingers, extra digit, fewer digits, cropped, worst quality, low quality, normal quality, jpeg artifacts, signature, watermark, username, blurry', '50');
INSERT INTO `authortag` VALUES ('10', '三笠', 'http://rjsum4lnm.hn-bkt.clouddn.com/a71442fe-7e99-453f-a17b-7047211c6e24', '1girl,jk,extremely detailed 8k wallpaper,beatiful eyes,beatiful detailed face,blue hair,blush,sweats,student.', 'lowres, bad anatomy, bad hands, text, error, missing fingers, extra digit, fewer digits, cropped, worst quality, low quality, normal quality, jpeg artifacts, signature, watermark, username, blurry', '50');
INSERT INTO `authortag` VALUES ('11', '三笠', '', 'ddddddddddddd', 'ddd', '50');
INSERT INTO `authortag` VALUES ('12', 'dddddd', '', 'dddddd', 'ddd', '50');
INSERT INTO `authortag` VALUES ('13', 'dddd', 'http://rjsum4lnm.hn-bkt.clouddn.com/820a6f23-7c51-4a68-bbc8-238f4f46db53', 'ddd', 'ddd', '50');
INSERT INTO `authortag` VALUES ('14', 'afawd', 'http://rjsum4lnm.hn-bkt.clouddn.com/c5eac981-a0d4-4576-a37f-76bf31b218af', 'dawdawd', 'awdaw', '50');
INSERT INTO `authortag` VALUES ('15', 'qqq', 'http://rjsum4lnm.hn-bkt.clouddn.com/05be43f3-cc9b-46dc-8ac8-5fbaba245409', 'qqq', 'qq', '50');
INSERT INTO `authortag` VALUES ('16', 'wwwwwww', 'http://rjsum4lnm.hn-bkt.clouddn.com/ebe96001-607c-452d-90b9-5959bb057c02', '{{masterpiece}},best quality,1girl,solo,illustration,ahoge,young loli,gradient white hair,longhair,{{beautiful detailed eyes}},blue serafuku,looking_at_viewer,small breast,gradient  blue eyes,arms_behind_back,hair_flower,beautiful detailed sky,water,half body,sunset,flower_petals,detached_sleeves,smile,beautiful detailed hair,', '{{masterpiece}},best quality,1girl,solo,illustration,ahoge,young loli,gradient white hair,longhair,{{beautiful detailed eyes}},blue serafuku,looking_at_viewer,small breast,gradient  blue eyes,arms_behind_back,hair_flower,beautiful detailed sky,water,half body,sunset,flower_petals,detached_sleeves,smile,beautiful detailed hair,', '50');
