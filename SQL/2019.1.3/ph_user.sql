/*
Navicat MySQL Data Transfer

Source Server         : 我的小家
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : ph_user

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-01-03 22:36:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classification_blog_ref
-- ----------------------------
DROP TABLE IF EXISTS `classification_blog_ref`;
CREATE TABLE `classification_blog_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classification_id` int(11) DEFAULT NULL,
  `blog_id` int(11) DEFAULT NULL,
  `blog_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of classification_blog_ref
-- ----------------------------

-- ----------------------------
-- Table structure for classificiation
-- ----------------------------
DROP TABLE IF EXISTS `classificiation`;
CREATE TABLE `classificiation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of classificiation
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `last_modified_time` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('b6ae074093b24be3b6e6664fcabc3938', 'liuys123', 'q2624522', null, null, '2019-01-02 22:14:29', '2019-01-02 22:14:29', 'himself');
INSERT INTO `user` VALUES ('b722622c5c974e63ae3284b8b98116a5', 'liuys1234', 'q2624522', null, null, '2019-01-02 22:48:16', '2019-01-02 22:48:16', 'himself');
