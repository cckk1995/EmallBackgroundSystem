/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : db_emall

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 01/04/2019 19:30:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for em_address
-- ----------------------------
DROP TABLE IF EXISTS `em_address`;
CREATE TABLE `em_address` (
  `address_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `receiver_name` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `receiver_phone` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `address` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `address_detail` varchar(256) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `postal_code` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `is_default` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for em_admin_info
-- ----------------------------
DROP TABLE IF EXISTS `em_admin_info`;
CREATE TABLE `em_admin_info` (
  `admin_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `is_used` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of em_admin_info
-- ----------------------------
BEGIN;
INSERT INTO `em_admin_info` VALUES ('71904354424332288', '柴凯', 1, '1234', '17855824130', '363853018@qq.com', 0, '2019-03-29 11:00:00', '2019-03-29 21:02:45');
COMMIT;

-- ----------------------------
-- Table structure for em_buyer_comment
-- ----------------------------
DROP TABLE IF EXISTS `em_buyer_comment`;
CREATE TABLE `em_buyer_comment` (
  `buyer_comment_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `order_item_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `comment` varchar(500) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `comment_type` tinyint(4) NOT NULL DEFAULT '1',
  `comment_img_url` text COLLATE utf8_unicode_ci,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`buyer_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of em_buyer_comment
-- ----------------------------
BEGIN;
INSERT INTO `em_buyer_comment` VALUES ('1', '1000', '1001', '质量很好', 1, NULL, '2019-02-18 14:57:08', '2019-02-18 14:57:10');
INSERT INTO `em_buyer_comment` VALUES ('2', '1001', '1001', '质量一般', 2, NULL, '2019-02-18 14:58:14', '2019-02-18 14:58:16');
COMMIT;

-- ----------------------------
-- Table structure for em_category
-- ----------------------------
DROP TABLE IF EXISTS `em_category`;
CREATE TABLE `em_category` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_parent_id` int(11) NOT NULL DEFAULT '0',
  `cat_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `cat_status` tinyint(1) NOT NULL DEFAULT '1',
  `sort_order` int(4) DEFAULT '100',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of em_category
-- ----------------------------
BEGIN;
INSERT INTO `em_category` VALUES (1, 21, '手机', 1, 100, '2019-03-17 18:56:42', '2019-03-17 18:56:44');
INSERT INTO `em_category` VALUES (2, 23, '电话卡', 1, 99, '2019-03-17 18:57:00', '2019-03-17 18:57:02');
INSERT INTO `em_category` VALUES (3, 22, '电视', 1, 98, '2019-03-17 18:57:23', '2019-03-17 18:57:25');
INSERT INTO `em_category` VALUES (4, 22, '电视盒子', 1, 97, '2019-03-17 18:57:42', '2019-03-17 18:57:44');
INSERT INTO `em_category` VALUES (5, 21, '笔记本', 1, 96, '2019-03-17 18:58:14', '2019-03-17 18:58:16');
INSERT INTO `em_category` VALUES (6, 21, '平板', 1, 95, '2019-03-17 18:58:33', '2019-03-17 18:58:35');
INSERT INTO `em_category` VALUES (7, 22, '家电', 1, 94, '2019-03-17 18:59:03', '2019-03-17 18:59:05');
INSERT INTO `em_category` VALUES (8, 22, '插线板', 1, 93, '2019-03-17 18:59:58', '2019-03-17 19:00:01');
INSERT INTO `em_category` VALUES (9, 23, '出行', 1, 92, '2019-03-17 19:00:17', '2019-03-17 19:00:19');
INSERT INTO `em_category` VALUES (10, 23, '穿戴', 1, 91, '2019-03-17 19:00:39', '2019-03-17 19:00:41');
INSERT INTO `em_category` VALUES (11, 22, '智能', 1, 90, '2019-03-17 19:00:57', '2019-03-17 19:00:59');
INSERT INTO `em_category` VALUES (12, 22, '路由器', 1, 89, '2019-03-17 19:01:16', '2019-03-17 19:01:18');
INSERT INTO `em_category` VALUES (13, 23, '电源', 1, 87, '2019-03-17 19:01:55', '2019-03-17 19:01:57');
INSERT INTO `em_category` VALUES (14, 23, '配件', 1, 86, '2019-03-17 19:02:10', '2019-03-17 19:02:12');
INSERT INTO `em_category` VALUES (15, 22, '健康', 1, 85, '2019-03-17 19:02:26', '2019-03-17 19:02:28');
INSERT INTO `em_category` VALUES (16, 23, '儿童', 1, 84, '2019-03-17 19:02:45', '2019-03-17 19:02:47');
INSERT INTO `em_category` VALUES (17, 23, '耳机', 1, 83, '2019-03-17 19:03:02', '2019-03-17 19:03:04');
INSERT INTO `em_category` VALUES (18, 22, '音箱', 1, 82, '2019-03-17 19:03:34', '2019-03-17 19:03:36');
INSERT INTO `em_category` VALUES (19, 23, '生活', 1, 81, '2019-03-17 19:03:48', '2019-03-17 19:03:50');
INSERT INTO `em_category` VALUES (20, 23, '箱包', 1, 80, '2019-03-17 19:44:02', '2019-03-17 19:44:04');
INSERT INTO `em_category` VALUES (21, 0, '手机电脑', 1, 100, '2019-03-26 09:34:31', '2019-03-26 09:34:34');
INSERT INTO `em_category` VALUES (22, 0, '家用设备', 1, 78, '2019-03-17 19:51:38', '2019-03-17 19:51:40');
INSERT INTO `em_category` VALUES (23, 0, '其它', 1, 77, '2019-03-17 19:51:54', '2019-03-17 19:51:56');
COMMIT;

-- ----------------------------
-- Table structure for em_index_list
-- ----------------------------
DROP TABLE IF EXISTS `em_index_list`;
CREATE TABLE `em_index_list` (
  `list_id` int(11) NOT NULL AUTO_INCREMENT,
  `list_name` varchar(30) NOT NULL,
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `source_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sorted` int(10) NOT NULL,
  PRIMARY KEY (`list_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of em_index_list
-- ----------------------------
BEGIN;
INSERT INTO `em_index_list` VALUES (1001, '手机', 'http://139.199.125.60/test/WechatIMG1686.jpeg', '/chaikai', 100);
INSERT INTO `em_index_list` VALUES (1002, '配件', 'http://139.199.125.60/test/WechatIMG494.jpeg', '/goodslist', 98);
INSERT INTO `em_index_list` VALUES (1003, '家电', 'https://i1.mifile.cn/a4/xmad_1544580545953_UvEXK.jpg', '/goodslist', 96);
INSERT INTO `em_index_list` VALUES (1004, '智能硬件', 'http://i3.mifile.cn/a4/124d82cc-cfce-44ab-b711-28b21be81683', '/goodslist', 94);
COMMIT;

-- ----------------------------
-- Table structure for em_index_list_item
-- ----------------------------
DROP TABLE IF EXISTS `em_index_list_item`;
CREATE TABLE `em_index_list_item` (
  `item_id` varchar(32) NOT NULL,
  `list_id` int(11) NOT NULL,
  `source_url` varchar(255) NOT NULL,
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `old_price` decimal(10,2) DEFAULT NULL,
  `discount_type` varchar(100) DEFAULT NULL,
  `discount` varchar(100) DEFAULT NULL,
  `sorted` int(10) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `foreign` (`list_id`),
  CONSTRAINT `foreign` FOREIGN KEY (`list_id`) REFERENCES `em_index_list` (`list_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of em_index_list_item
-- ----------------------------
BEGIN;
INSERT INTO `em_index_list_item` VALUES ('37930332053704704', 1001, '/goodsdetail', '帅帅帅', 2199.00, 'new', '八折', 1);
INSERT INTO `em_index_list_item` VALUES ('67240186572312576', 1002, '/goodsdetail', '潮流镜面渐变色，2400万自拍旗舰', 2199.00, 'new', '八折', 1);
INSERT INTO `em_index_list_item` VALUES ('67245475711291392', 1002, '/goodsdetail', '帅帅帅', 2199.00, 'new', '八折', 3);
INSERT INTO `em_index_list_item` VALUES ('67252275143643136', 1002, '/goodsdetail', '帅帅帅', 2199.00, 'new', '八折', 2);
INSERT INTO `em_index_list_item` VALUES ('67262632629243904', 1003, '/goodsdetail', '帅帅帅', 3199.00, 'new', '八折', 1);
INSERT INTO `em_index_list_item` VALUES ('67263952970977280', 1003, '/goodsdetail', '帅帅帅', 3199.00, 'new', '八折', 2);
INSERT INTO `em_index_list_item` VALUES ('67275168409849856', 1004, '/goodsdetail', '帅帅帅', 3199.00, 'new', '八折', 1);
INSERT INTO `em_index_list_item` VALUES ('67285747811880960', 1001, '/goodsdetail', '潮流镜面渐变色，2400万自拍旗舰', 3199.00, 'new', '八折', 2);
INSERT INTO `em_index_list_item` VALUES ('67293299584929792', 1003, '/goodsdetail', '帅帅帅', 3199.00, 'new', '八折', 3);
INSERT INTO `em_index_list_item` VALUES ('67294325813678080', 1003, '/goodsdetail', '帅帅帅', 3199.00, 'new', '八折', 4);
INSERT INTO `em_index_list_item` VALUES ('67567150864666624', 1004, '/goodsdetail', '帅帅帅', 3199.00, 'new', '八折', 2);
INSERT INTO `em_index_list_item` VALUES ('67568478206693376', 1004, '/goodsdetail', '性能好，穿墙能力很强', 499.00, 'discount', '八折', 3);
COMMIT;

-- ----------------------------
-- Table structure for em_item
-- ----------------------------
DROP TABLE IF EXISTS `em_item`;
CREATE TABLE `em_item` (
  `item_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `category_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `item_title` varchar(256) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `item_sales` int(11) NOT NULL DEFAULT '0',
  `item_main_image` varchar(256) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `item_detail_image` text COLLATE utf8_unicode_ci,
  `item_intro_image` varchar(256) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of em_item
-- ----------------------------
BEGIN;
INSERT INTO `em_item` VALUES ('37849334754447360', '1', '小米MIX3', 100, 'http://139.199.125.60/商品图片/Mix3/mix3_main_1.jpg', '\"http://139.199.125.60/商品图片/Mix3/mix3_detail_1.jpg\", \"http://139.199.125.60/商品图片/Mix3/mix3_detail_2.jpg\", \"http://139.199.125.60/商品图片/Mix3/mix3_detail_3.jpg\", \"http://139.199.125.60/商品图片/Mix3/mix3_detail_4.jpg\"', '\"http://139.199.125.60/商品图片/Mix3/mix3_intro_1.jpg\", \"http://139.199.125.60/商品图片/Mix3/mix3_intro_2.jpg\", \"http://139.199.125.60/商品图片/Mix3/mix3_intro_3.jpg\", \"http://139.199.125.60/商品图片/Mix3/mix3_intro_4.jpg\"', '2019-01-15 00:00:00', '2019-01-15 00:00:00');
INSERT INTO `em_item` VALUES ('37854334218014720', '1', '小米MAX3', 150, 'http://139.199.125.60/商品图片/Max3/max3_main_1.jpg', '\"http://139.199.125.60/商品图片/Max3/max3_detail_1.jpg\", \"http://139.199.125.60/商品图片/Max3/max3_detail_2.jpg\", \"http://139.199.125.60/商品图片/Max3/max3_detail_3.jpg\", \"http://139.199.125.60/商品图片/Max3/max3_detail_4.jpg\"', '\"http://139.199.125.60/商品图片/Max3/max3_intro_1.jpg\", \"http://139.199.125.60/商品图片/Max3/max3_intro_2.jpg\", \"http://139.199.125.60/商品图片/Max3/max3_intro_3.jpg\", \"http://139.199.125.60/商品图片/Max3/max3_intro_4.jpg\"', '2019-01-15 00:00:00', '2019-01-15 00:00:00');
INSERT INTO `em_item` VALUES ('37905485735006208', '1', '红米6A', 120, 'http://139.199.125.60/商品图片/红米6A/6a_main_1.jpg', '\"http://139.199.125.60/商品图片/红米6A/6a_detail_1.jpg\", \"http://139.199.125.60/商品图片/红米6A/6a_detail_2.jpg\", \"http://139.199.125.60/商品图片/红米6A/6a_detail_3.jpg\", \"http://139.199.125.60/商品图片/红米6A/6a_detail_4.jpg\"', '\"http://139.199.125.60/商品图片/红米6A/6a_intro_1.jpg\", \"http://139.199.125.60/商品图片/红米6A/6a_intro_2.jpg\", \"http://139.199.125.60/商品图片/红米6A/6a_intro_3.jpg\", \"http://139.199.125.60/商品图片/红米6A/6a_intro_4.jpg\"', '2019-01-15 00:00:00', '2019-01-15 00:00:00');
INSERT INTO `em_item` VALUES ('37930332053704704', '1', '小米8青春版', 130, 'http://139.199.125.60/商品图片/小米8青春版/m8yang_main_1.jpg', '\"http://139.199.125.60/商品图片/小米8青春版/m8yang_detail_4.jpg\",\"http://139.199.125.60/商品图片/小米8青春版/m8yang_detail_1.jpg\",\"http://139.199.125.60/商品图片/小米8青春版/m8yang_detail_2.jpg\",\"http://139.199.125.60/商品图片/小米8青春版/m8yang_detail_3.jpg\"', '\"http://139.199.125.60/商品图片/小米8青春版/m8yang_intro_1.jpg\",\"http://139.199.125.60/商品图片/小米8青春版/m8yang_intro_3.jpg\",\"http://139.199.125.60/商品图片/小米8青春版/m8yang_intro_2.jpg\",\"http://139.199.125.60/商品图片/小米8青春版/m8yang_intro_4.jpg\"', '2019-01-15 00:00:00', '2019-01-15 00:00:00');
INSERT INTO `em_item` VALUES ('37938115868233728', '1', '小米8', 110, 'http://139.199.125.60/商品图片/小米8/m8_main_1.jpg', '\"http://139.199.125.60/商品图片/小米8/m8_detail_1.jpg\",\"http://139.199.125.60/商品图片/小米8/m8_detail_3.jpg\",\"http://139.199.125.60/商品图片/小米8/m8_detail_2.jpg\",\"http://139.199.125.60/商品图片/小米8/m8_detail_4.jpg\"', '\"http://139.199.125.60/商品图片/小米8/m8_intro_1.jpg\",\"http://139.199.125.60/商品图片/小米8/m8_intro_3.jpg\",\"http://139.199.125.60/商品图片/小米8/m8_intro_2.jpg\",\"http://139.199.125.60/商品图片/小米8/m8_intro_4.jpg\"', '2019-01-15 00:00:00', '2019-01-15 00:00:00');
INSERT INTO `em_item` VALUES ('57773610638905344', '1', '小米play', 38, 'http://139.199.125.60/商品图片/小米play/play_main_1.jpg', '\"http://139.199.125.60/商品图片/小米play/play_detail_1.png,http://139.199.125.60/商品图片/小米play/play_detail_2.png,http://139.199.125.60/商品图片/小米play/play_detail_3.png,http://139.199.125.60/商品图片/小米play/play_detail_4.png\"', '\"http://139.199.125.60/商品图片/小米play/play_intro_1.jpg,http://139.199.125.60/商品图片/小米play/play_intro_2.jpg,http://139.199.125.60/商品图片/小米play/play_intro_3.jpg,http://139.199.125.60/商品图片/小米play/play_intro_4.jpg\"', '2019-02-19 10:16:13', '2019-02-19 10:16:16');
INSERT INTO `em_item` VALUES ('57777819237093376', '1', '红米Note7', 782, 'http://139.199.125.60/商品图片/红米Note7/note7_main.jpg', '\"http://139.199.125.60/商品图片/红米Note7/note7_detail_1.jpg,http://139.199.125.60/商品图片/红米Note7/note7_detail_2.jpg,http://139.199.125.60/商品图片/红米Note7/note7_detail_3.jpg,http://139.199.125.60/商品图片/红米Note7/note7_detail_4.jpg\"', '\"http://139.199.125.60/商品图片/红米Note7/note7_intro_1.jpg,http://139.199.125.60/商品图片/红米Note7/note7_intro_2.jpg,http://139.199.125.60/商品图片/红米Note7/note7_intro_3.jpg,http://139.199.125.60/商品图片/红米Note7/note7_intro_4.jpg\"', '2019-02-19 10:29:37', '2019-02-19 10:29:39');
INSERT INTO `em_item` VALUES ('67232003774615552', '5', '小米air', 42, 'http://139.199.125.60/商品图片/小米air/main.jpg', '\"http://139.199.125.60/商品图片/小米air/detail4.jpg,http://139.199.125.60/商品图片/小米air/detail2.jpg,http://139.199.125.60/商品图片/小米air/detail3.jpg,http://139.199.125.60/商品图片/小米air/detail1.jpg\"', '\"http://139.199.125.60/商品图片/小米air/intro1.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67236502299873280', '14', '苹果lightning数据线', 56, 'http://139.199.125.60/商品图片/苹果lightning数据线/main.jpg', '\"http://139.199.125.60/商品图片/苹果lightning数据线/detail4.jpg,http://139.199.125.60/商品图片/苹果lightning数据线/detail2.jpg,http://139.199.125.60/商品图片/苹果lightning数据线/detail1.jpg,http://139.199.125.60/商品图片/苹果lightning数据线/detail.jpg\"', '\"http://139.199.125.60/商品图片/苹果lightning数据线/intro1.jpg,http://139.199.125.60/商品图片/苹果lightning数据线/intro2.jpg,http://139.199.125.60/商品图片/苹果lightning数据线/intro3.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67240186572312576', '14', '小米自拍杆', 26, 'http://139.199.125.60/商品图片/小米自拍杆/main.jpg', '\"http://139.199.125.60/商品图片/小米自拍杆/detail2.jpg,http://139.199.125.60/商品图片/小米自拍杆/detail1.jpg\"', '\"http://139.199.125.60/商品图片/小米自拍杆/intro1.jpg,http://139.199.125.60/商品图片/小米自拍杆/intro2.jpg,http://139.199.125.60/商品图片/小米自拍杆/intro3.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67245475711291392', '14', '小米指环支架', 97, 'http://139.199.125.60/商品图片/小米指环支架/main.jpg', '\"http://139.199.125.60/商品图片/小米指环支架/detail2.jpg,http://139.199.125.60/商品图片/小米指环支架/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米指环支架/intro1.jpg,http://139.199.125.60/商品图片/小米指环支架/intro2.jpg,http://139.199.125.60/商品图片/小米指环支架/intro3.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67248021649625088', '8', '3口USB插线板', 46, 'http://139.199.125.60/商品图片/3口USB插线板/main.jpg', '\"http://139.199.125.60/商品图片/3口USB插线板/detail4.jpg,http://139.199.125.60/商品图片/3口USB插线板/detail2.jpg,http://139.199.125.60/商品图片/3口USB插线板/detail3.jpg,http://139.199.125.60/商品图片/3口USB插线板/detail.jpg\"', '\"http://139.199.125.60/商品图片/3口USB插线板/intro.png\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67251042576109568', '19', '小米HI压力锅', 123, 'http://139.199.125.60/商品图片/小米HI压力锅/main.jpg', '\"http://139.199.125.60/商品图片/小米HI压力锅/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米HI压力锅/intro.png\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67252275143643136', '14', '小米随身风扇', 167, 'http://139.199.125.60/商品图片/小米随身风扇/main.jpg', '\"http://139.199.125.60/商品图片/小米随身风扇/detail2.jpg,http://139.199.125.60/商品图片/小米随身风扇/detail3.jpg,http://139.199.125.60/商品图片/小米随身风扇/detail1.jpg,http://139.199.125.60/商品图片/小米随身风扇/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米随身风扇/intro1.jpg,http://139.199.125.60/商品图片/小米随身风扇/intro2.jpg,http://139.199.125.60/商品图片/小米随身风扇/intro3.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67253690847072256', '6', '小米平板4', 222, 'http://139.199.125.60/商品图片/小米平板4/main.jpg', '\"http://139.199.125.60/商品图片/小米平板4/detail4.jpg,http://139.199.125.60/商品图片/小米平板4/detail2.jpg,http://139.199.125.60/商品图片/小米平板4/detail3.jpg,http://139.199.125.60/商品图片/小米平板4/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米平板4/intro.jpg,http://139.199.125.60/商品图片/小米平板4/attr2.jpg,http://139.199.125.60/商品图片/小米平板4/attr1.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67256979160436736', '17', '蓝牙耳机AirDots', 256, 'http://139.199.125.60/商品图片/蓝牙耳机AirDots/main.jpg', '\"http://139.199.125.60/商品图片/蓝牙耳机AirDots/detail4.jpg,http://139.199.125.60/商品图片/蓝牙耳机AirDots/detail2.jpg,http://139.199.125.60/商品图片/蓝牙耳机AirDots/detail3.jpg,http://139.199.125.60/商品图片/蓝牙耳机AirDots/detail.jpg\"', '\"http://139.199.125.60/商品图片/蓝牙耳机AirDots/intro1.jpg,http://139.199.125.60/商品图片/蓝牙耳机AirDots/intro2.jpg,http://139.199.125.60/商品图片/蓝牙耳机AirDots/intro3.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67257990772035584', '9', '九号平衡车', 113, 'http://139.199.125.60/商品图片/九号平衡车/main.jpg', '\"http://139.199.125.60/商品图片/九号平衡车/detail2.jpg,http://139.199.125.60/商品图片/九号平衡车/detail.jpg\"', '\"http://139.199.125.60/商品图片/九号平衡车/intro1.jpg,http://139.199.125.60/商品图片/九号平衡车/intro3.png\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67259557050978304', '10', '小米手环3', 56, 'http://139.199.125.60/商品图片/小米手环3/main.jpg', '\"http://139.199.125.60/商品图片/小米手环3/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米手环3/attr1.jpg,http://139.199.125.60/商品图片/小米手环3/intro1.jpeg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67262632629243904', '7', '米家空调伴侣', 256, 'http://139.199.125.60/商品图片/米家空调伴侣/main.jpg', '\"http://139.199.125.60/商品图片/米家空调伴侣/detail2.jpg,http://139.199.125.60/商品图片/米家空调伴侣/detail3.jpg,http://139.199.125.60/商品图片/米家空调伴侣/detail.jpg\"', '\"http://139.199.125.60/商品图片/米家空调伴侣/intro.jpg,http://139.199.125.60/商品图片/米家空调伴侣/attr.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67263952970977280', '7', '米家空调', 121, 'http://139.199.125.60/商品图片/米家空调/main.jpg', '\"http://139.199.125.60/商品图片/米家空调/detail3.jpeg,http://139.199.125.60/商品图片/米家空调/detail2.jpg,http://139.199.125.60/商品图片/米家空调/detail1.jpg\"', '\"http://139.199.125.60/商品图片/米家空调/intro.jpg,http://139.199.125.60/商品图片/米家空调/attr2.jpg,http://139.199.125.60/商品图片/米家空调/attr3.jpeg,http://139.199.125.60/商品图片/米家空调/attr1.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67266180670689280', '10', '小米手环3腕带', 456, 'http://139.199.125.60/商品图片/小米手环3腕带/main.jpg', '\"http://139.199.125.60/商品图片/小米手环3腕带/detail2.jpg,http://139.199.125.60/商品图片/小米手环3腕带/detail3.jpg,http://139.199.125.60/商品图片/小米手环3腕带/detail1.jpg\"', '\"http://139.199.125.60/商品图片/小米手环3腕带/intro1.jpg,http://139.199.125.60/商品图片/小米手环3腕带/intro2.jpg,http://139.199.125.60/商品图片/小米手环3腕带/intro3.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67268254925983744', '10', '米动手表青春版', 178, 'http://139.199.125.60/商品图片/米动手表青春版/main.jpg', '\"http://139.199.125.60/商品图片/米动手表青春版/detail2.jpg,http://139.199.125.60/商品图片/米动手表青春版/detail3.jpg,http://139.199.125.60/商品图片/米动手表青春版/detail1.jpg\"', '\"http://139.199.125.60/商品图片/米动手表青春版/intro.jpeg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67269856021843968', '10', 'AMAZFIT手环', 99, 'http://139.199.125.60/商品图片/AMAZFIT手环/main.jpg', '\"http://139.199.125.60/商品图片/AMAZFIT手环/detail2.jpg,http://139.199.125.60/商品图片/AMAZFIT手环/detail3.jpg,http://139.199.125.60/商品图片/AMAZFIT手环/detail1.jpg\"', '\"http://139.199.125.60/商品图片/AMAZFIT手环/intro1.jpg,http://139.199.125.60/商品图片/AMAZFIT手环/intro2.jpg,http://139.199.125.60/商品图片/AMAZFIT手环/intro3.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67270977352241152', '20', 'FREETIE云弹减震运动鞋', 752, 'http://139.199.125.60/商品图片/FREETIE云弹减震运动鞋/main.jpg', '\"http://139.199.125.60/商品图片/FREETIE云弹减震运动鞋/detail2.jpg,http://139.199.125.60/商品图片/FREETIE云弹减震运动鞋/detail3.jpg,http://139.199.125.60/商品图片/FREETIE云弹减震运动鞋/detail1.jpg\"', '\"http://139.199.125.60/商品图片/FREETIE云弹减震运动鞋/intro1.jpg,http://139.199.125.60/商品图片/FREETIE云弹减震运动鞋/intro2.jpg,http://139.199.125.60/商品图片/FREETIE云弹减震运动鞋/intro3.jpg,http://139.199.125.60/商品图片/FREETIE云弹减震运动鞋/intro4.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67273079591931904', '3', '米家投影仪', 71, 'http://139.199.125.60/商品图片/米家投影仪/main.jpg', '\"http://139.199.125.60/商品图片/米家投影仪/detail2.jpg,http://139.199.125.60/商品图片/米家投影仪/detail1.jpg\"', '\"http://139.199.125.60/商品图片/米家投影仪/intro.jpeg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67274302634201088', '15', '米家iHealth血压计', 31, 'http://139.199.125.60/商品图片/米家iHealth血压计/main.jpg', '\"http://139.199.125.60/商品图片/米家iHealth血压计/detail.jpg\"', '\"http://139.199.125.60/商品图片/米家iHealth血压计/intro.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67275168409849856', '12', '小米路由器4A', 42, 'http://139.199.125.60/商品图片/小米路由器4A/main.jpg', '\"http://139.199.125.60/商品图片/小米路由器4A/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米路由器4A/intro.jpeg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67276242512384000', '12', '小米路由器Mesh', 142, 'http://139.199.125.60/商品图片/小米路由器Mesh/main.jpg', '\"http://139.199.125.60/商品图片/小米路由器Mesh/detail4.jpg,http://139.199.125.60/商品图片/小米路由器Mesh/detail2.jpg,http://139.199.125.60/商品图片/小米路由器Mesh/detail3.jpg,http://139.199.125.60/商品图片/小米路由器Mesh/detail1.jpg\"', '\"http://139.199.125.60/商品图片/小米路由器Mesh/intro.jpeg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67278498632699904', '18', '小米随身蓝牙音箱', 399, 'http://139.199.125.60/商品图片/小米随身蓝牙音箱/main.jpg', '\"http://139.199.125.60/商品图片/小米随身蓝牙音箱/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米随身蓝牙音箱/intro.png\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67279601239724032', '15', '米家空气净化器MAX', 29, 'http://139.199.125.60/商品图片/米家空气净化器MAX/main.jpg', '\"http://139.199.125.60/商品图片/米家空气净化器MAX/detail.jpg\"', '\"http://139.199.125.60/商品图片/米家空气净化器MAX/intro.jpeg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67285747811880960', '1', '小米9', 129, 'http://139.199.125.60/商品图片/小米9/main.jpg', '\"http://139.199.125.60/商品图片/小米9/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米9/intro.jpg,http://139.199.125.60/商品图片/小米9/intro1.jpg,http://139.199.125.60/商品图片/小米9/intro2.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67289515756490752', '3', '小米电视4A 32英寸', 29, 'http://139.199.125.60/商品图片/小米电视4A 32英寸/main.jpg', '\"http://139.199.125.60/商品图片/小米电视4A 32英寸/detail2.jpg,http://139.199.125.60/商品图片/小米电视4A 32英寸/detail3.jpg,http://139.199.125.60/商品图片/小米电视4A 32英寸/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米电视4A 32英寸/intro.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67290731974627328', '3', '小米电视4C 55英寸', 67, 'http://139.199.125.60/商品图片/小米电视4C 55英寸/main.png', '\"http://139.199.125.60/商品图片/小米电视4C 55英寸/detail1.png,http://139.199.125.60/商品图片/小米电视4C 55英寸/detail.png\"', '\"http://139.199.125.60/商品图片/小米电视4C 55英寸/intro.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67291818119008256', '3', '小米电视4C 43英寸', 67, 'http://139.199.125.60/商品图片/小米电视4C 43英寸/main.png', '\"http://139.199.125.60/商品图片/小米电视4C 43英寸/detail2.png,http://139.199.125.60/商品图片/小米电视4C 43英寸/detail1.png,http://139.199.125.60/商品图片/小米电视4C 43英寸/detail.png\"', '\"http://139.199.125.60/商品图片/小米电视4C 43英寸/intro.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67293299584929792', '3', '小米电视4A 65英寸', 67, 'http://139.199.125.60/商品图片/小米电视4A 65英寸/main.jpg', '\"http://139.199.125.60/商品图片/小米电视4A 65英寸/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米电视4A 65英寸/intro.jpeg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67294325813678080', '3', '小米电视4 55英寸', 67, 'http://139.199.125.60/商品图片/小米电视4 55英寸/main.jpg', '\"http://139.199.125.60/商品图片/小米电视4 55英寸/detail2.jpg,http://139.199.125.60/商品图片/小米电视4 55英寸/detail1.jpg\"', '\"http://139.199.125.60/商品图片/小米电视4 55英寸/intro.jpeg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67295251110694912', '3', '米家激光投影电视', 67, 'http://139.199.125.60/商品图片/米家激光投影电视/main.jpg', '\"http://139.199.125.60/商品图片/米家激光投影电视/detail2.jpg,http://139.199.125.60/商品图片/米家激光投影电视/detail1.jpg,http://139.199.125.60/商品图片/米家激光投影电视/detail.jpg\"', '\"http://139.199.125.60/商品图片/米家激光投影电视/intro.png\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67296058916868096', '3', '小米电视4 75英寸', 67, 'http://139.199.125.60/商品图片/小米电视4 75英寸/main.jpg', '\"http://139.199.125.60/商品图片/小米电视4 75英寸/detail1.jpg,http://139.199.125.60/商品图片/小米电视4 75英寸/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米电视4 75英寸/intro.jpeg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67296995131658240', '5', '15.6寸游戏本', 24, 'http://139.199.125.60/商品图片/15.6寸游戏本/main.jpg', '\"http://139.199.125.60/商品图片/15.6寸游戏本/detail1.jpg,http://139.199.125.60/商品图片/15.6寸游戏本/detail.jpg\"', '\"http://139.199.125.60/商品图片/15.6寸游戏本/intro.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67298259357798400', '11', '米家扫地机器人', 224, 'http://139.199.125.60/商品图片/米家扫地机器人/main.jpg', '\"http://139.199.125.60/商品图片/米家扫地机器人/detail.jpg\"', '\"http://139.199.125.60/商品图片/米家扫地机器人/intro.png\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67299384437903360', '19', '米家电动剃须刀', 137, 'http://139.199.125.60/商品图片/米家电动剃须刀/main.jpg', '\"http://139.199.125.60/商品图片/米家电动剃须刀/detail1.jpg,http://139.199.125.60/商品图片/米家电动剃须刀/detail.jpg\"', '\"http://139.199.125.60/商品图片/米家电动剃须刀/intro.jpeg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67300241581674496', '16', '米兔故事机', 121, 'http://139.199.125.60/商品图片/米兔故事机/main.jpg', '\"http://139.199.125.60/商品图片/米兔故事机/detail1.jpg,http://139.199.125.60/商品图片/米兔故事机/detail.jpg\"', '\"http://139.199.125.60/商品图片/米兔故事机/intro.jpeg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67324621527322624', '16', '米兔折叠婴儿推车', 143, 'http://139.199.125.60/商品图片/米兔折叠婴儿推车/main.png', '\"http://139.199.125.60/商品图片/米兔折叠婴儿推车/detail2.png,http://139.199.125.60/商品图片/米兔折叠婴儿推车/detail1.png,http://139.199.125.60/商品图片/米兔折叠婴儿推车/detail.png\"', '\"http://139.199.125.60/商品图片/米兔折叠婴儿推车/intro.jpeg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67560357996400640', '17', '小米K歌耳机', 55, 'http://139.199.125.60/商品图片/小米K歌耳机/main.jpg', '\"http://139.199.125.60/商品图片/小米K歌耳机/detail2.jpg,http://139.199.125.60/商品图片/小米K歌耳机/detail3.jpg,http://139.199.125.60/商品图片/小米K歌耳机/detail1.jpg,http://139.199.125.60/商品图片/小米K歌耳机/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米K歌耳机/intro.jpeg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67564438857060352', '17', '小米蓝牙耳机Air', 35, 'http://139.199.125.60/商品图片/小米蓝牙耳机Air/main.jpg', '\"http://139.199.125.60/商品图片/小米蓝牙耳机Air/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米蓝牙耳机Air/intro1.jpg,http://139.199.125.60/商品图片/小米蓝牙耳机Air/intro2.jpg,http://139.199.125.60/商品图片/小米蓝牙耳机Air/intro3.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67567150864666624', '4', '小米盒子4', 332, 'http://139.199.125.60/商品图片/小米盒子4/main.jpg', '\"http://139.199.125.60/商品图片/小米盒子4/detail2.jpg,http://139.199.125.60/商品图片/小米盒子4/detail3.jpg,http://139.199.125.60/商品图片/小米盒子4/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米盒子4/intro.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67567771005095936', '4', '小米盒子4c', 122, 'http://139.199.125.60/商品图片/小米盒子4c/main.jpg', '\"http://139.199.125.60/商品图片/小米盒子4c/detail2.jpg,http://139.199.125.60/商品图片/小米盒子4c/detail1.jpg,http://139.199.125.60/商品图片/小米盒子4c/detail.jpg\"', '\"http://139.199.125.60/商品图片/小米盒子4c/intro.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67568478206693376', '4', '小米盒子3 增强版 ', 321, 'http://139.199.125.60/商品图片/小米盒子3 增强版 /main.jpg', '\"http://139.199.125.60/商品图片/小米盒子3 增强版 /detail2.jpg,http://139.199.125.60/商品图片/小米盒子3 增强版 /detail.jpg\"', '\"http://139.199.125.60/商品图片/小米盒子3 增强版 /intro.jpg\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
INSERT INTO `em_item` VALUES ('67570454273331200', '2', '米粉卡日租卡', 25, 'http://139.199.125.60/商品图片/米粉卡日租卡/main.jpg', '\"http://139.199.125.60/商品图片/米粉卡日租卡/detail.jpg\"', '\"http://139.199.125.60/商品图片/米粉卡日租卡/intro.png\"', '2019-03-16 00:00:00', '2019-03-16 00:00:00');
COMMIT;

-- ----------------------------
-- Table structure for em_item_attr_key
-- ----------------------------
DROP TABLE IF EXISTS `em_item_attr_key`;
CREATE TABLE `em_item_attr_key` (
  `attr_key_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `attr_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`attr_key_id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of em_item_attr_key
-- ----------------------------
BEGIN;
INSERT INTO `em_item_attr_key` VALUES (1, '37849334754447360', '版本');
INSERT INTO `em_item_attr_key` VALUES (2, '37849334754447360', '颜色');
INSERT INTO `em_item_attr_key` VALUES (3, '37854334218014720', '版本');
INSERT INTO `em_item_attr_key` VALUES (4, '37854334218014720', '颜色');
INSERT INTO `em_item_attr_key` VALUES (5, '37905485735006208', '版本');
INSERT INTO `em_item_attr_key` VALUES (6, '37905485735006208', '颜色');
INSERT INTO `em_item_attr_key` VALUES (7, '37930332053704704', '版本');
INSERT INTO `em_item_attr_key` VALUES (8, '37930332053704704', '颜色');
INSERT INTO `em_item_attr_key` VALUES (9, '37938115868233728', '版本');
INSERT INTO `em_item_attr_key` VALUES (10, '37938115868233728', '颜色');
INSERT INTO `em_item_attr_key` VALUES (11, '57773610638905344', '版本');
INSERT INTO `em_item_attr_key` VALUES (12, '57773610638905344', '颜色');
INSERT INTO `em_item_attr_key` VALUES (13, '57777819237093376', '版本');
INSERT INTO `em_item_attr_key` VALUES (14, '57777819237093376', '颜色');
INSERT INTO `em_item_attr_key` VALUES (24, '67232003774615552', '版本');
INSERT INTO `em_item_attr_key` VALUES (25, '67232003774615552', '颜色');
INSERT INTO `em_item_attr_key` VALUES (26, '67236502299873280', '颜色');
INSERT INTO `em_item_attr_key` VALUES (28, '67240186572312576', '颜色');
INSERT INTO `em_item_attr_key` VALUES (29, '67245475711291392', '颜色');
INSERT INTO `em_item_attr_key` VALUES (30, '67248021649625088', '颜色');
INSERT INTO `em_item_attr_key` VALUES (31, '67251042576109568', '颜色');
INSERT INTO `em_item_attr_key` VALUES (32, '67252275143643136', '颜色');
INSERT INTO `em_item_attr_key` VALUES (33, '67253690847072256', '版本');
INSERT INTO `em_item_attr_key` VALUES (34, '67253690847072256', '颜色');
INSERT INTO `em_item_attr_key` VALUES (35, '67256979160436736', '颜色');
INSERT INTO `em_item_attr_key` VALUES (36, '67257990772035584', '颜色');
INSERT INTO `em_item_attr_key` VALUES (37, '67259557050978304', '颜色');
INSERT INTO `em_item_attr_key` VALUES (38, '67262632629243904', '颜色');
INSERT INTO `em_item_attr_key` VALUES (39, '67263952970977280', '版本');
INSERT INTO `em_item_attr_key` VALUES (40, '67266180670689280', '颜色');
INSERT INTO `em_item_attr_key` VALUES (41, '67268254925983744', '颜色');
INSERT INTO `em_item_attr_key` VALUES (42, '67269856021843968', '颜色');
INSERT INTO `em_item_attr_key` VALUES (43, '67270977352241152', '颜色');
INSERT INTO `em_item_attr_key` VALUES (44, '67270977352241152', '尺码');
INSERT INTO `em_item_attr_key` VALUES (45, '67273079591931904', '颜色');
INSERT INTO `em_item_attr_key` VALUES (46, '67274302634201088', '颜色');
INSERT INTO `em_item_attr_key` VALUES (47, '67275168409849856', '颜色');
INSERT INTO `em_item_attr_key` VALUES (48, '67276242512384000', '颜色');
INSERT INTO `em_item_attr_key` VALUES (49, '67278498632699904', '颜色');
INSERT INTO `em_item_attr_key` VALUES (50, '67279601239724032', '颜色');
INSERT INTO `em_item_attr_key` VALUES (53, '67285747811880960', '版本');
INSERT INTO `em_item_attr_key` VALUES (54, '67285747811880960', '颜色');
INSERT INTO `em_item_attr_key` VALUES (55, '67289515756490752', '颜色');
INSERT INTO `em_item_attr_key` VALUES (56, '67289515756490752', '尺寸');
INSERT INTO `em_item_attr_key` VALUES (57, '67290731974627328', '颜色');
INSERT INTO `em_item_attr_key` VALUES (58, '67290731974627328', '尺寸');
INSERT INTO `em_item_attr_key` VALUES (59, '67291818119008256', '颜色');
INSERT INTO `em_item_attr_key` VALUES (60, '67291818119008256', '尺寸');
INSERT INTO `em_item_attr_key` VALUES (61, '67293299584929792', '颜色');
INSERT INTO `em_item_attr_key` VALUES (62, '67293299584929792', '尺寸');
INSERT INTO `em_item_attr_key` VALUES (63, '67294325813678080', '颜色');
INSERT INTO `em_item_attr_key` VALUES (64, '67294325813678080', '尺寸');
INSERT INTO `em_item_attr_key` VALUES (65, '67295251110694912', '颜色');
INSERT INTO `em_item_attr_key` VALUES (66, '67296058916868096', '颜色');
INSERT INTO `em_item_attr_key` VALUES (67, '67296058916868096', '尺寸');
INSERT INTO `em_item_attr_key` VALUES (68, '67296995131658240', '配置');
INSERT INTO `em_item_attr_key` VALUES (69, '67298259357798400', '颜色');
INSERT INTO `em_item_attr_key` VALUES (70, '67299384437903360', '颜色');
INSERT INTO `em_item_attr_key` VALUES (71, '67300241581674496', '颜色');
INSERT INTO `em_item_attr_key` VALUES (72, '67324621527322624', '颜色');
INSERT INTO `em_item_attr_key` VALUES (73, '67560357996400640', '版本');
INSERT INTO `em_item_attr_key` VALUES (74, '67564438857060352', '颜色');
INSERT INTO `em_item_attr_key` VALUES (75, '67567150864666624', '颜色');
INSERT INTO `em_item_attr_key` VALUES (76, '67567771005095936', '颜色');
INSERT INTO `em_item_attr_key` VALUES (77, '67568478206693376', '颜色');
INSERT INTO `em_item_attr_key` VALUES (78, '67570454273331200', '套餐');
COMMIT;

-- ----------------------------
-- Table structure for em_item_attr_val
-- ----------------------------
DROP TABLE IF EXISTS `em_item_attr_val`;
CREATE TABLE `em_item_attr_val` (
  `attr_key_id` int(11) NOT NULL,
  `item_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `symbol` int(11) NOT NULL,
  `attr_value` varchar(256) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `attr_img` varchar(256) COLLATE utf8_unicode_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of em_item_attr_val
-- ----------------------------
BEGIN;
INSERT INTO `em_item_attr_val` VALUES (1, '37849334754447360', 1, '8G+128G', '');
INSERT INTO `em_item_attr_val` VALUES (1, '37849334754447360', 2, '6G+128G', '');
INSERT INTO `em_item_attr_val` VALUES (1, '37849334754447360', 3, '8G+256G', '');
INSERT INTO `em_item_attr_val` VALUES (2, '37849334754447360', 4, '宝石蓝', 'http://139.199.125.60/商品图片/Mix3/mix3_attr_1.jpg');
INSERT INTO `em_item_attr_val` VALUES (2, '37849334754447360', 5, '黑色', 'http://139.199.125.60/商品图片/Mix3/mix3_attr_2.jpg');
INSERT INTO `em_item_attr_val` VALUES (3, '37854334218014720', 1, '4GB+6GB', '');
INSERT INTO `em_item_attr_val` VALUES (3, '37854334218014720', 2, '6GB+128GB', '');
INSERT INTO `em_item_attr_val` VALUES (4, '37854334218014720', 3, '黑色', 'http://139.199.125.60/商品图片/Max3/max3_attr_1.png');
INSERT INTO `em_item_attr_val` VALUES (4, '37854334218014720', 4, '金色', 'http://139.199.125.60/商品图片/Max3/max3_attr_2.png');
INSERT INTO `em_item_attr_val` VALUES (4, '37854334218014720', 5, '蓝色', 'http://139.199.125.60/商品图片/Max3/max3_attr_3.png');
INSERT INTO `em_item_attr_val` VALUES (5, '37905485735006208', 1, '2G+16G', '');
INSERT INTO `em_item_attr_val` VALUES (5, '37905485735006208', 2, '3G+32G', '');
INSERT INTO `em_item_attr_val` VALUES (6, '37905485735006208', 3, '流沙金', 'http://139.199.125.60/商品图片/红米6A/6a_attr_1.png');
INSERT INTO `em_item_attr_val` VALUES (6, '37905485735006208', 4, '铂银灰', 'http://139.199.125.60/商品图片/红米6A/6a_attr_2.png');
INSERT INTO `em_item_attr_val` VALUES (6, '37905485735006208', 5, '樱花粉', 'http://139.199.125.60/商品图片/红米6A/6a_attr_3.png');
INSERT INTO `em_item_attr_val` VALUES (6, '37905485735006208', 6, '巴厘蓝', 'http://139.199.125.60/商品图片/红米6A/6a_attr_4.png');
INSERT INTO `em_item_attr_val` VALUES (7, '37930332053704704', 1, '6G+64G', '');
INSERT INTO `em_item_attr_val` VALUES (7, '37930332053704704', 2, '4G+64G', '');
INSERT INTO `em_item_attr_val` VALUES (7, '37930332053704704', 3, '6G+128G', '');
INSERT INTO `em_item_attr_val` VALUES (7, '37930332053704704', 4, '4G+128G', '');
INSERT INTO `em_item_attr_val` VALUES (8, '37930332053704704', 5, '深空灰', 'http://139.199.125.60/商品图片/小米8青春版/m8yang_attr_1.jpg');
INSERT INTO `em_item_attr_val` VALUES (8, '37930332053704704', 6, '梦幻蓝', 'http://139.199.125.60/商品图片/小米8青春版/m8yang_attr_2.jpg');
INSERT INTO `em_item_attr_val` VALUES (8, '37930332053704704', 7, '暮光金', 'http://139.199.125.60/商品图片/小米8青春版/m8yang_attr_3.jpg');
INSERT INTO `em_item_attr_val` VALUES (9, '37938115868233728', 1, '6G+64GB', '');
INSERT INTO `em_item_attr_val` VALUES (9, '37938115868233728', 2, '8G+128G', '');
INSERT INTO `em_item_attr_val` VALUES (9, '37938115868233728', 3, '6G+128G', '');
INSERT INTO `em_item_attr_val` VALUES (9, '37938115868233728', 4, '6G+256G', '');
INSERT INTO `em_item_attr_val` VALUES (10, '37938115868233728', 5, '蓝色', 'http://139.199.125.60/商品图片/小米8/m8_attr_1.png');
INSERT INTO `em_item_attr_val` VALUES (10, '37938115868233728', 6, '黑色', 'http://139.199.125.60/商品图片/小米8/m8_attr_2.png');
INSERT INTO `em_item_attr_val` VALUES (10, '37938115868233728', 7, '金色', 'http://139.199.125.60/商品图片/小米8/m8_attr_3.png');
INSERT INTO `em_item_attr_val` VALUES (10, '37938115868233728', 8, '白色', 'http://139.199.125.60/商品图片/小米8/m8_attr_4.png');
INSERT INTO `em_item_attr_val` VALUES (11, '57773610638905344', 1, '4G+64G', '');
INSERT INTO `em_item_attr_val` VALUES (12, '57773610638905344', 1, '梦幻蓝', 'http://139.199.125.60/商品图片/小米Play/paly_attr_1.png');
INSERT INTO `em_item_attr_val` VALUES (12, '57773610638905344', 3, '黑色', 'http://139.199.125.60/商品图片/小米Play/paly_attr_2.png');
INSERT INTO `em_item_attr_val` VALUES (12, '57773610638905344', 4, '暮光金', 'http://139.199.125.60/商品图片/小米Play/paly_attr_3.png');
INSERT INTO `em_item_attr_val` VALUES (13, '57777819237093376', 1, '6G+64G', '');
INSERT INTO `em_item_attr_val` VALUES (13, '57777819237093376', 2, '4G+64G', '');
INSERT INTO `em_item_attr_val` VALUES (13, '57777819237093376', 3, '3G+32G', '');
INSERT INTO `em_item_attr_val` VALUES (14, '57777819237093376', 4, '亮黑色', 'http://139.199.125.60/商品图片/红米Note7/note7_attr_1.png');
INSERT INTO `em_item_attr_val` VALUES (14, '57777819237093376', 5, '梦幻蓝', 'http://139.199.125.60/商品图片/红米Note7/note7_attr_2.png');
INSERT INTO `em_item_attr_val` VALUES (14, '57777819237093376', 6, '暮光金', 'http://139.199.125.60/商品图片/红米Note7/note7_attr_3.png');
INSERT INTO `em_item_attr_val` VALUES (24, '67232003774615552', 1, 'i5 4G 256G', '');
INSERT INTO `em_item_attr_val` VALUES (24, '67232003774615552', 2, 'M3 4G 128G', '');
INSERT INTO `em_item_attr_val` VALUES (24, '67232003774615552', 3, 'M3 4G 256G', '');
INSERT INTO `em_item_attr_val` VALUES (25, '67232003774615552', 4, '银色', 'http://139.199.125.60/商品图片/小米air/attr1.png');
INSERT INTO `em_item_attr_val` VALUES (25, '67232003774615552', 5, '金色', 'http://139.199.125.60/商品图片/小米air/attr2.png');
INSERT INTO `em_item_attr_val` VALUES (26, '67236502299873280', 1, '白色', '');
INSERT INTO `em_item_attr_val` VALUES (28, '67240186572312576', 1, '白色', '');
INSERT INTO `em_item_attr_val` VALUES (28, '67240186572312576', 2, '黑色', '');
INSERT INTO `em_item_attr_val` VALUES (29, '67245475711291392', 1, '金色', '');
INSERT INTO `em_item_attr_val` VALUES (29, '67245475711291392', 2, '银色', '');
INSERT INTO `em_item_attr_val` VALUES (30, '67248021649625088', 1, '白色', '');
INSERT INTO `em_item_attr_val` VALUES (30, '67248021649625088', 2, '黑色', '');
INSERT INTO `em_item_attr_val` VALUES (31, '67251042576109568', 1, '白色', '');
INSERT INTO `em_item_attr_val` VALUES (32, '67252275143643136', 1, '白色', '');
INSERT INTO `em_item_attr_val` VALUES (32, '67252275143643136', 2, '蓝色', '');
INSERT INTO `em_item_attr_val` VALUES (33, '67253690847072256', 1, '10寸 LTE 128G', '');
INSERT INTO `em_item_attr_val` VALUES (33, '67253690847072256', 2, '10寸 LTE 64G', '');
INSERT INTO `em_item_attr_val` VALUES (33, '67253690847072256', 3, '8寸 LTE 64G', '');
INSERT INTO `em_item_attr_val` VALUES (33, '67253690847072256', 4, '8寸 WIFI 32G', '');
INSERT INTO `em_item_attr_val` VALUES (33, '67253690847072256', 5, '8寸 WIFI 64G', '');
INSERT INTO `em_item_attr_val` VALUES (34, '67253690847072256', 6, '金色', 'http://139.199.125.60/商品图片/小米平板4/attr1.jpg');
INSERT INTO `em_item_attr_val` VALUES (34, '67253690847072256', 7, '黑色', 'http://139.199.125.60/商品图片/小米平板4/attr2.jpg');
INSERT INTO `em_item_attr_val` VALUES (35, '67256979160436736', 1, '白色', '');
INSERT INTO `em_item_attr_val` VALUES (36, '67257990772035584', 1, '白色', 'http://139.199.125.60/商品图片/九号平衡车/attr1.jpg');
INSERT INTO `em_item_attr_val` VALUES (36, '67257990772035584', 2, '黑色', 'http://139.199.125.60/商品图片/九号平衡车/attr2.jpg');
INSERT INTO `em_item_attr_val` VALUES (37, '67259557050978304', 1, '黑色', 'http://139.199.125.60/商品图片/小米手环3/attr1.jpg');
INSERT INTO `em_item_attr_val` VALUES (38, '67262632629243904', 1, '白色', 'http://139.199.125.60/商品图片/米家空调伴侣/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (39, '67263952970977280', 1, '普通', 'http://139.199.125.60/商品图片/米家空调/attr1.jpg');
INSERT INTO `em_item_attr_val` VALUES (39, '67263952970977280', 2, '互联网', 'http://139.199.125.60/商品图片/米家空调/attr2.jpg');
INSERT INTO `em_item_attr_val` VALUES (39, '67263952970977280', 3, '一级能效', 'http://139.199.125.60/商品图片/米家空调/attr3.jpg');
INSERT INTO `em_item_attr_val` VALUES (40, '67266180670689280', 1, '石墨黑', '');
INSERT INTO `em_item_attr_val` VALUES (40, '67266180670689280', 2, '热力橙', '');
INSERT INTO `em_item_attr_val` VALUES (40, '67266180670689280', 3, '深空蓝', '');
INSERT INTO `em_item_attr_val` VALUES (40, '67266180670689280', 4, '藕荷粉', '');
INSERT INTO `em_item_attr_val` VALUES (40, '67266180670689280', 5, '酒红', '');
INSERT INTO `em_item_attr_val` VALUES (41, '67268254925983744', 1, '曜石黑', 'http://139.199.125.60/商品图片/米动手表青春版/attr1.jpg');
INSERT INTO `em_item_attr_val` VALUES (41, '67268254925983744', 2, '卡其绿', 'http://139.199.125.60/商品图片/米动手表青春版/attr2.jpg');
INSERT INTO `em_item_attr_val` VALUES (41, '67268254925983744', 3, '火焰橙', 'http://139.199.125.60/商品图片/米动手表青春版/attr3.jpg');
INSERT INTO `em_item_attr_val` VALUES (42, '67269856021843968', 1, '猎豹黑', '');
INSERT INTO `em_item_attr_val` VALUES (43, '67270977352241152', 1, '花黑色', '');
INSERT INTO `em_item_attr_val` VALUES (43, '67270977352241152', 2, '花蓝色', '');
INSERT INTO `em_item_attr_val` VALUES (44, '67270977352241152', 3, '39', '');
INSERT INTO `em_item_attr_val` VALUES (44, '67270977352241152', 4, '40', '');
INSERT INTO `em_item_attr_val` VALUES (44, '67270977352241152', 5, '41', '');
INSERT INTO `em_item_attr_val` VALUES (44, '67270977352241152', 6, '42', '');
INSERT INTO `em_item_attr_val` VALUES (44, '67270977352241152', 7, '43', '');
INSERT INTO `em_item_attr_val` VALUES (44, '67270977352241152', 8, '44', '');
INSERT INTO `em_item_attr_val` VALUES (44, '67270977352241152', 9, '45', '');
INSERT INTO `em_item_attr_val` VALUES (45, '67273079591931904', 1, '白色', 'http://139.199.125.60/商品图片/米家投影仪/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (46, '67274302634201088', 1, '白色', 'http://139.199.125.60/商品图片/米家iHealth血压计/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (47, '67275168409849856', 1, '白色', 'http://139.199.125.60/商品图片/小米路由器4A/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (48, '67276242512384000', 1, '白色', 'http://139.199.125.60/商品图片/小米路由器Mesh/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (49, '67278498632699904', 1, '星空灰', 'http://139.199.125.60/商品图片/小米随身蓝牙音箱/attr1.jpg');
INSERT INTO `em_item_attr_val` VALUES (49, '67278498632699904', 2, '香槟金', 'http://139.199.125.60/商品图片/小米随身蓝牙音箱/attr2.jpg');
INSERT INTO `em_item_attr_val` VALUES (49, '67278498632699904', 3, '金属银', 'http://139.199.125.60/商品图片/小米随身蓝牙音箱/attr3.jpg');
INSERT INTO `em_item_attr_val` VALUES (50, '67279601239724032', 1, '白色', 'http://139.199.125.60/商品图片/米家空气净化器MAX/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (53, '67285747811880960', 1, '6G+128GB', '');
INSERT INTO `em_item_attr_val` VALUES (53, '67285747811880960', 2, '8G+128GB', '');
INSERT INTO `em_item_attr_val` VALUES (54, '67285747811880960', 3, '深灰色', 'http://139.199.125.60/商品图片/小米9/attr1.jpg');
INSERT INTO `em_item_attr_val` VALUES (54, '67285747811880960', 4, '幻影紫', 'http://139.199.125.60/商品图片/小米9/attr2.jpg');
INSERT INTO `em_item_attr_val` VALUES (54, '67285747811880960', 5, '幻影蓝', 'http://139.199.125.60/商品图片/小米9/attr3.jpg');
INSERT INTO `em_item_attr_val` VALUES (55, '67289515756490752', 1, '黑色', 'http://139.199.125.60/商品图片/小米电视4A 32英寸/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (56, '67289515756490752', 2, '32寸', '');
INSERT INTO `em_item_attr_val` VALUES (57, '67290731974627328', 1, '黑色', 'http://139.199.125.60/商品图片/小米电视4C 55英寸/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (58, '67290731974627328', 2, '55寸', '');
INSERT INTO `em_item_attr_val` VALUES (59, '67291818119008256', 1, '黑色', 'http://139.199.125.60/商品图片/小米电视4C 43英寸/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (60, '67291818119008256', 2, '43寸', '');
INSERT INTO `em_item_attr_val` VALUES (61, '67293299584929792', 1, '黑色', 'http://139.199.125.60/商品图片/小米电视4A 65英寸/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (62, '67293299584929792', 2, '65寸', '');
INSERT INTO `em_item_attr_val` VALUES (63, '67294325813678080', 1, '黑色', 'http://139.199.125.60/商品图片/小米电视4 55英寸/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (64, '67294325813678080', 2, '55寸', '');
INSERT INTO `em_item_attr_val` VALUES (65, '67295251110694912', 1, '白色', 'http://139.199.125.60/商品图片/米家激光投影电视/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (66, '67296058916868096', 1, '黑色', 'http://139.199.125.60/商品图片/小米电视4 75英寸/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (67, '67296058916868096', 2, '75寸', '');
INSERT INTO `em_item_attr_val` VALUES (68, '67296995131658240', 1, 'i5 8G 1T+256G 1050Ti 4G', 'http://139.199.125.60/商品图片/15.6寸游戏本/attr1.jpg');
INSERT INTO `em_item_attr_val` VALUES (68, '67296995131658240', 2, 'i5 8G 1T+256G 1050Ti 4G', 'http://139.199.125.60/商品图片/15.6寸游戏本/attr2.jpg');
INSERT INTO `em_item_attr_val` VALUES (69, '67298259357798400', 1, '白色', 'http://139.199.125.60/商品图片/米家扫地机器人/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (70, '67299384437903360', 1, '黑色', 'http://139.199.125.60/商品图片/米家电动剃须刀/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (71, '67300241581674496', 1, '粉色', 'http://139.199.125.60/商品图片/米兔故事机/attr1.jpg');
INSERT INTO `em_item_attr_val` VALUES (71, '67300241581674496', 2, '蓝色', 'http://139.199.125.60/商品图片/米兔故事机/attr2.jpg');
INSERT INTO `em_item_attr_val` VALUES (72, '67324621527322624', 1, '粉色', 'http://139.199.125.60/商品图片/米兔折叠婴儿推车/attr1.jpg');
INSERT INTO `em_item_attr_val` VALUES (72, '67324621527322624', 2, '蓝色', 'http://139.199.125.60/商品图片/米兔折叠婴儿推车/attr2.jpg');
INSERT INTO `em_item_attr_val` VALUES (72, '67324621527322624', 3, '米灰色', 'http://139.199.125.60/商品图片/米兔折叠婴儿推车/attr3.jpg');
INSERT INTO `em_item_attr_val` VALUES (73, '67560357996400640', 1, '蓝牙版', 'http://139.199.125.60/商品图片/小米K歌耳机/attr1.jpg');
INSERT INTO `em_item_attr_val` VALUES (73, '67560357996400640', 2, '有线版', 'http://139.199.125.60/商品图片/小米K歌耳机/attr2.jpg');
INSERT INTO `em_item_attr_val` VALUES (74, '67564438857060352', 1, '白色', 'http://139.199.125.60/商品图片/小米蓝牙耳机Air/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (75, '67567150864666624', 1, '白色', 'http://139.199.125.60/商品图片/小米盒子4/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (76, '67567771005095936', 1, '黑色', 'http://139.199.125.60/商品图片/小米盒子4c/attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (77, '67568478206693376', 1, '白色', 'http://139.199.125.60/商品图片/小米盒子3 增强版 /attr.jpg');
INSERT INTO `em_item_attr_val` VALUES (78, '67570454273331200', 1, '1元日租卡', '');
INSERT INTO `em_item_attr_val` VALUES (78, '67570454273331200', 2, '3元日租卡', '');
COMMIT;

-- ----------------------------
-- Table structure for em_item_stock
-- ----------------------------
DROP TABLE IF EXISTS `em_item_stock`;
CREATE TABLE `em_item_stock` (
  `stock_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `attr_symbol_path` varchar(256) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `price` decimal(15,2) NOT NULL DEFAULT '0.00',
  `item_status` tinyint(4) NOT NULL DEFAULT '1',
  `stock` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=197 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of em_item_stock
-- ----------------------------
BEGIN;
INSERT INTO `em_item_stock` VALUES (1, '37849334754447360', '1,4', 3599.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (2, '37849334754447360', '1,5', 3599.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (3, '37849334754447360', '2,4', 3299.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (4, '37849334754447360', '3,4', 3999.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (5, '37854334218014720', '1,3', 1599.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (6, '37854334218014720', '1,4', 1599.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (7, '37854334218014720', '2,3', 1899.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (8, '37854334218014720', '2,4', 1899.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (9, '37854334218014720', '2,5', 1899.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (10, '37905485735006208', '1,3', 569.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (11, '37905485735006208', '1,4', 569.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (12, '37905485735006208', '1,5', 569.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (13, '37905485735006208', '1,6', 569.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (14, '37905485735006208', '2,3', 669.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (15, '37905485735006208', '2,4', 669.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (16, '37905485735006208', '2,5', 669.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (17, '37905485735006208', '2,6', 669.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (18, '37930332053704704', '1,5', 1699.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (19, '37930332053704704', '1,6', 1699.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (20, '37930332053704704', '1,7', 1699.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (21, '37930332053704704', '2,5', 1399.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (22, '37930332053704704', '2,6', 1399.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (23, '37930332053704704', '2,7', 1399.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (24, '37930332053704704', '3,5', 1999.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (25, '37930332053704704', '3,6', 1999.00, 1, 1000);
INSERT INTO `em_item_stock` VALUES (26, '37930332053704704', '3,7', 1999.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (27, '37930332053704704', '4,5', 1799.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (28, '37930332053704704', '4,6', 1799.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (29, '37930332053704704', '4,7', 1799.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (30, '37938115868233728', '1,5', 2499.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (31, '37938115868233728', '1,6', 2499.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (32, '37938115868233728', '1,7', 2499.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (33, '37938115868233728', '1,8', 2499.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (34, '37938115868233728', '2,5', 3099.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (35, '37938115868233728', '2,6', 3099.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (36, '37938115868233728', '2,7', 3099.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (37, '37938115868233728', '3,5', 2799.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (38, '37938115868233728', '3,6', 2799.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (39, '37938115868233728', '3,7', 2799.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (40, '37938115868233728', '3,8', 2799.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (41, '37938115868233728', '4,5', 2999.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (42, '37938115868233728', '4,6', 2999.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (43, '37938115868233728', '4,7', 2999.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (44, '37938115868233728', '4,8', 2999.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (45, '57773610638905344', '1,2', 1099.00, 1, 34);
INSERT INTO `em_item_stock` VALUES (46, '57773610638905344', '1,3', 1099.00, 1, 55);
INSERT INTO `em_item_stock` VALUES (47, '57773610638905344', '1,4', 1099.00, 1, 89);
INSERT INTO `em_item_stock` VALUES (48, '57777819237093376', '1,4', 1399.00, 1, 15);
INSERT INTO `em_item_stock` VALUES (49, '57777819237093376', '1,5', 1399.00, 1, 13);
INSERT INTO `em_item_stock` VALUES (50, '57777819237093376', '1,6', 1399.00, 1, 22);
INSERT INTO `em_item_stock` VALUES (51, '57777819237093376', '2,4', 1199.00, 1, 9);
INSERT INTO `em_item_stock` VALUES (52, '57777819237093376', '2,5', 1199.00, 1, 12);
INSERT INTO `em_item_stock` VALUES (53, '57777819237093376', '2,6', 1199.00, 1, 7);
INSERT INTO `em_item_stock` VALUES (54, '57777819237093376', '3,4', 999.00, 1, 21);
INSERT INTO `em_item_stock` VALUES (55, '57777819237093376', '3,5', 999.00, 1, 11);
INSERT INTO `em_item_stock` VALUES (102, '67232003774615552', '1,4', 4299.00, 1, 13);
INSERT INTO `em_item_stock` VALUES (103, '67232003774615552', '2,4', 3599.00, 1, 19);
INSERT INTO `em_item_stock` VALUES (104, '67232003774615552', '3,4', 3999.00, 1, 11);
INSERT INTO `em_item_stock` VALUES (105, '67232003774615552', '1,5', 4299.00, 1, 12);
INSERT INTO `em_item_stock` VALUES (106, '67232003774615552', '2,5', 3599.00, 1, 21);
INSERT INTO `em_item_stock` VALUES (107, '67232003774615552', '3,5', 3999.00, 1, 16);
INSERT INTO `em_item_stock` VALUES (108, '67236502299873280', '1', 35.00, 1, 1120);
INSERT INTO `em_item_stock` VALUES (109, '67240186572312576', '1', 49.00, 1, 233);
INSERT INTO `em_item_stock` VALUES (110, '67240186572312576', '2', 49.00, 1, 124);
INSERT INTO `em_item_stock` VALUES (111, '67245475711291392', '1', 15.00, 1, 2214);
INSERT INTO `em_item_stock` VALUES (112, '67245475711291392', '2', 15.00, 1, 1376);
INSERT INTO `em_item_stock` VALUES (113, '67248021649625088', '1', 49.00, 1, 123);
INSERT INTO `em_item_stock` VALUES (114, '67248021649625088', '1', 49.00, 1, 145);
INSERT INTO `em_item_stock` VALUES (115, '67251042576109568', '1', 999.00, 1, 147);
INSERT INTO `em_item_stock` VALUES (116, '67252275143643136', '1', 19.90, 1, 289);
INSERT INTO `em_item_stock` VALUES (117, '67252275143643136', '2', 19.90, 1, 277);
INSERT INTO `em_item_stock` VALUES (118, '67253690847072256', '1,6', 2099.00, 1, 131);
INSERT INTO `em_item_stock` VALUES (119, '67253690847072256', '2,6', 1899.00, 1, 213);
INSERT INTO `em_item_stock` VALUES (120, '67253690847072256', '3,6', 1499.00, 1, 39);
INSERT INTO `em_item_stock` VALUES (121, '67253690847072256', '4,6', 1099.00, 1, 35);
INSERT INTO `em_item_stock` VALUES (122, '67253690847072256', '5,6', 1399.00, 1, 98);
INSERT INTO `em_item_stock` VALUES (123, '67253690847072256', '1,7', 2099.00, 1, 31);
INSERT INTO `em_item_stock` VALUES (124, '67253690847072256', '2,7', 1899.00, 1, 87);
INSERT INTO `em_item_stock` VALUES (125, '67253690847072256', '3,7', 1499.00, 1, 45);
INSERT INTO `em_item_stock` VALUES (126, '67253690847072256', '4,7', 1099.00, 1, 74);
INSERT INTO `em_item_stock` VALUES (127, '67253690847072256', '5,7', 1399.00, 1, 84);
INSERT INTO `em_item_stock` VALUES (128, '67256979160436736', '1', 199.00, 1, 241);
INSERT INTO `em_item_stock` VALUES (129, '67257990772035584', '1', 1999.00, 1, 157);
INSERT INTO `em_item_stock` VALUES (130, '67257990772035584', '2', 1999.00, 1, 241);
INSERT INTO `em_item_stock` VALUES (131, '67259557050978304', '1', 159.00, 1, 579);
INSERT INTO `em_item_stock` VALUES (132, '67262632629243904', '1', 169.00, 1, 12);
INSERT INTO `em_item_stock` VALUES (133, '67263952970977280', '1', 1599.00, 1, 79);
INSERT INTO `em_item_stock` VALUES (134, '67263952970977280', '2', 1999.00, 1, 69);
INSERT INTO `em_item_stock` VALUES (135, '67263952970977280', '3', 2499.00, 1, 17);
INSERT INTO `em_item_stock` VALUES (136, '67266180670689280', '1', 19.90, 1, 10);
INSERT INTO `em_item_stock` VALUES (137, '67266180670689280', '2', 19.90, 1, 13);
INSERT INTO `em_item_stock` VALUES (138, '67266180670689280', '3', 19.90, 1, 18);
INSERT INTO `em_item_stock` VALUES (139, '67266180670689280', '4', 19.90, 1, 31);
INSERT INTO `em_item_stock` VALUES (140, '67266180670689280', '5', 19.90, 1, 21);
INSERT INTO `em_item_stock` VALUES (141, '67268254925983744', '1', 399.00, 1, 52);
INSERT INTO `em_item_stock` VALUES (142, '67268254925983744', '2', 399.00, 1, 42);
INSERT INTO `em_item_stock` VALUES (143, '67268254925983744', '3', 399.00, 1, 54);
INSERT INTO `em_item_stock` VALUES (144, '67269856021843968', '1', 299.00, 1, 29);
INSERT INTO `em_item_stock` VALUES (145, '67270977352241152', '1,3', 249.00, 1, 10);
INSERT INTO `em_item_stock` VALUES (146, '67270977352241152', '1,4', 249.00, 1, 11);
INSERT INTO `em_item_stock` VALUES (147, '67270977352241152', '1,5', 249.00, 1, 12);
INSERT INTO `em_item_stock` VALUES (148, '67270977352241152', '1,6', 249.00, 1, 13);
INSERT INTO `em_item_stock` VALUES (149, '67270977352241152', '1,7', 249.00, 1, 14);
INSERT INTO `em_item_stock` VALUES (150, '67270977352241152', '1,8', 249.00, 1, 15);
INSERT INTO `em_item_stock` VALUES (151, '67270977352241152', '1,9', 249.00, 1, 16);
INSERT INTO `em_item_stock` VALUES (152, '67270977352241152', '2,3', 249.00, 1, 17);
INSERT INTO `em_item_stock` VALUES (153, '67270977352241152', '2,4', 249.00, 1, 19);
INSERT INTO `em_item_stock` VALUES (154, '67270977352241152', '2,5', 249.00, 1, 31);
INSERT INTO `em_item_stock` VALUES (155, '67270977352241152', '2,6', 249.00, 1, 14);
INSERT INTO `em_item_stock` VALUES (156, '67270977352241152', '2,7', 249.00, 1, 31);
INSERT INTO `em_item_stock` VALUES (157, '67270977352241152', '2,8', 249.00, 1, 41);
INSERT INTO `em_item_stock` VALUES (158, '67270977352241152', '2,9', 249.00, 1, 18);
INSERT INTO `em_item_stock` VALUES (159, '67273079591931904', '1', 2999.00, 1, 20);
INSERT INTO `em_item_stock` VALUES (160, '67274302634201088', '1', 399.00, 1, 119);
INSERT INTO `em_item_stock` VALUES (161, '67275168409849856', '1', 199.00, 1, 42);
INSERT INTO `em_item_stock` VALUES (162, '67276242512384000', '1', 999.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (163, '67278498632699904', '1', 69.00, 1, 101);
INSERT INTO `em_item_stock` VALUES (164, '67278498632699904', '2', 69.00, 1, 102);
INSERT INTO `em_item_stock` VALUES (165, '67278498632699904', '3', 69.00, 1, 103);
INSERT INTO `em_item_stock` VALUES (166, '67279601239724032', '1', 2199.00, 1, 101);
INSERT INTO `em_item_stock` VALUES (167, '67285747811880960', '1,3', 2999.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (168, '67285747811880960', '1,4', 2999.00, 1, 101);
INSERT INTO `em_item_stock` VALUES (169, '67285747811880960', '1,5', 2999.00, 1, 102);
INSERT INTO `em_item_stock` VALUES (170, '67285747811880960', '2,3', 3299.00, 1, 103);
INSERT INTO `em_item_stock` VALUES (171, '67285747811880960', '2,4', 3299.00, 1, 105);
INSERT INTO `em_item_stock` VALUES (172, '67285747811880960', '2,5', 3299.00, 1, 106);
INSERT INTO `em_item_stock` VALUES (173, '67289515756490752', '1,2', 799.00, 1, 201);
INSERT INTO `em_item_stock` VALUES (174, '67290731974627328', '1,2', 2199.00, 1, 109);
INSERT INTO `em_item_stock` VALUES (175, '67291818119008256', '1,2', 1299.00, 1, 111);
INSERT INTO `em_item_stock` VALUES (176, '67293299584929792', '1,2', 3199.00, 1, 323);
INSERT INTO `em_item_stock` VALUES (177, '67294325813678080', '1,2', 3599.00, 1, 281);
INSERT INTO `em_item_stock` VALUES (178, '67295251110694912', '1', 8999.00, 1, 201);
INSERT INTO `em_item_stock` VALUES (179, '67296058916868096', '1,2', 8999.00, 1, 101);
INSERT INTO `em_item_stock` VALUES (180, '67296995131658240', '1', 6699.00, 1, 19);
INSERT INTO `em_item_stock` VALUES (181, '67296995131658240', '2', 8999.00, 1, 28);
INSERT INTO `em_item_stock` VALUES (182, '67298259357798400', '1', 1999.00, 1, 121);
INSERT INTO `em_item_stock` VALUES (183, '67299384437903360', '1', 199.00, 1, 333);
INSERT INTO `em_item_stock` VALUES (184, '67300241581674496', '1', 149.00, 1, 19);
INSERT INTO `em_item_stock` VALUES (185, '67300241581674496', '2', 149.00, 1, 21);
INSERT INTO `em_item_stock` VALUES (186, '67324621527322624', '1', 699.00, 1, 90);
INSERT INTO `em_item_stock` VALUES (187, '67324621527322624', '2', 699.00, 1, 30);
INSERT INTO `em_item_stock` VALUES (188, '67324621527322624', '3', 699.00, 1, 43);
INSERT INTO `em_item_stock` VALUES (189, '67560357996400640', '1', 249.00, 1, 48);
INSERT INTO `em_item_stock` VALUES (190, '67560357996400640', '2', 169.00, 1, 109);
INSERT INTO `em_item_stock` VALUES (191, '67564438857060352', '1', 399.00, 1, 342);
INSERT INTO `em_item_stock` VALUES (192, '67567150864666624', '1', 299.00, 1, 158);
INSERT INTO `em_item_stock` VALUES (193, '67567771005095936', '1', 199.00, 1, 122);
INSERT INTO `em_item_stock` VALUES (194, '67568478206693376', '1', 399.00, 1, 100);
INSERT INTO `em_item_stock` VALUES (195, '67570454273331200', '1', 50.00, 1, 29);
INSERT INTO `em_item_stock` VALUES (196, '67570454273331200', '2', 100.00, 1, 78);
COMMIT;

-- ----------------------------
-- Table structure for em_navigation
-- ----------------------------
DROP TABLE IF EXISTS `em_navigation`;
CREATE TABLE `em_navigation` (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `source_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `buy_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `buy_status` tinyint(4) NOT NULL,
  `classify` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of em_navigation
-- ----------------------------
BEGIN;
INSERT INTO `em_navigation` VALUES ('2', '2', '2', '2', 2, '2');
COMMIT;

-- ----------------------------
-- Table structure for em_navigation_item
-- ----------------------------
DROP TABLE IF EXISTS `em_navigation_item`;
CREATE TABLE `em_navigation_item` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `item_id` varchar(32) NOT NULL,
  `source_url` varchar(100) NOT NULL,
  `item_status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `itemId` (`item_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of em_navigation_item
-- ----------------------------
BEGIN;
INSERT INTO `em_navigation_item` VALUES (4, '67291818119008256', '/goodslist', 1);
COMMIT;

-- ----------------------------
-- Table structure for em_order
-- ----------------------------
DROP TABLE IF EXISTS `em_order`;
CREATE TABLE `em_order` (
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `payment` decimal(15,2) NOT NULL DEFAULT '0.00',
  `payment_type` int(4) NOT NULL DEFAULT '1',
  `postage` decimal(15,2) NOT NULL DEFAULT '0.00',
  `order_status` int(10) NOT NULL DEFAULT '1',
  `total_price` decimal(15,2) DEFAULT '0.00' COMMENT '商品总价,单位是元,保留两位小数',
  `payment_time` datetime DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `close_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `address_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `receiver_name` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `receiver_phone` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `address` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `address_detail` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of em_order
-- ----------------------------
BEGIN;
INSERT INTO `em_order` VALUES ('67605891880595456', '71907093032079360', 29008.00, 0, 8.00, 0, 29000.00, NULL, NULL, '2019-03-30 03:58:51', '2019-02-01 16:18:22', '2019-03-18 13:21:41', '2019-03-30 03:58:51', '', '', '', '', '');
INSERT INTO `em_order` VALUES ('67608188983455744', '71907093032079360', 29008.00, 1, 8.00, 0, 29000.00, NULL, NULL, '2019-01-01 18:44:57', NULL, '2019-03-18 13:30:48', NULL, '', '', '', '', '');
INSERT INTO `em_order` VALUES ('67622760251404288', '71907093032079360', 29008.00, 1, 8.00, 0, 29000.00, NULL, NULL, '2019-03-30 03:58:55', NULL, '2019-03-18 14:28:42', '2019-03-30 03:58:55', '', '', '', '', '');
INSERT INTO `em_order` VALUES ('68283102115672064', '71907093032079360', 29008.00, 2, 8.00, 2, 29000.00, NULL, NULL, '2019-04-01 18:38:12', NULL, '2019-03-20 10:12:40', NULL, '', '', '', '', '');
INSERT INTO `em_order` VALUES ('68293565322899456', '71907093032079360', 29008.00, 1, 8.00, 0, 29000.00, NULL, NULL, '2019-04-01 02:54:30', NULL, '2019-03-20 10:54:15', '2019-04-01 02:54:30', '', '', '', '', '');
INSERT INTO `em_order` VALUES ('68315112766976000', '71907093032079360', 298.00, 3, 8.00, 0, 290.00, NULL, NULL, '2019-03-31 06:58:34', NULL, '2019-03-20 12:19:52', '2019-03-31 06:58:34', '', '', '', '', '');
INSERT INTO `em_order` VALUES ('70953690462433280', '71907093032079360', 298.00, 1, 8.00, 4, 290.00, NULL, NULL, '2019-03-21 18:38:16', NULL, '2019-03-27 19:04:38', NULL, '', '', '', '', '');
INSERT INTO `em_order` VALUES ('70960625056231424', '71907093032079360', 298.00, 4, 8.00, 1, 290.00, NULL, NULL, '2019-01-03 18:38:22', NULL, '2019-03-27 19:32:11', NULL, '', '', '', '', '');
INSERT INTO `em_order` VALUES ('70968953576632320', '71907093032079360', 298.00, 1, 8.00, 0, 290.00, NULL, NULL, '2019-03-06 18:38:29', NULL, '2019-03-27 20:05:17', NULL, '', '', '', '', '');
INSERT INTO `em_order` VALUES ('71289697623879680', '71907093032079360', 2808.00, 1, 8.00, 1, 2800.00, NULL, NULL, '2019-02-07 18:38:35', NULL, '2019-03-28 17:19:48', NULL, '', '', '', '', '');
INSERT INTO `em_order` VALUES ('71356596848177152', '71907093032079360', 55008.00, 1, 8.00, 1, 55000.00, NULL, NULL, '2019-02-13 18:38:49', NULL, '2019-03-28 21:45:38', NULL, '', '', '', '', '');
INSERT INTO `em_order` VALUES ('71357023555694592', '71907093032079360', 2208.00, 1, 8.00, 1, 2200.00, NULL, NULL, '2019-03-07 18:39:05', NULL, '2019-03-28 21:47:20', NULL, '', '', '', '', '');
INSERT INTO `em_order` VALUES ('71357779885174784', '71907093032079360', 2208.00, 1, 8.00, 1, 2200.00, NULL, NULL, '2019-02-01 18:38:57', NULL, '2019-03-28 21:50:20', NULL, '', '', '', '', '');
INSERT INTO `em_order` VALUES ('71358347634552832', '71907093032079360', 2208.00, 1, 8.00, 1, 2200.00, NULL, NULL, '2019-01-03 18:39:12', NULL, '2019-03-28 21:52:36', NULL, '', '', '', '', '');
INSERT INTO `em_order` VALUES ('71359610011004928', '71907093032079360', 2208.00, 1, 8.00, 1, 2200.00, NULL, NULL, '2019-01-03 18:39:17', NULL, '2019-03-28 21:57:37', NULL, '', '', '', '', '');
COMMIT;

-- ----------------------------
-- Table structure for em_order_item
-- ----------------------------
DROP TABLE IF EXISTS `em_order_item`;
CREATE TABLE `em_order_item` (
  `order_item_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL,
  `item_id` varchar(32) NOT NULL,
  `item_title` varchar(256) NOT NULL DEFAULT '',
  `attr_val` varchar(128) DEFAULT NULL COMMENT '所购买商品属性',
  `item_main_image` varchar(256) NOT NULL DEFAULT '',
  `current_unit_price` decimal(15,2) DEFAULT '0.00' COMMENT '生成订单时的商品单价，单位是元,保留两位小数',
  `amount` int(11) NOT NULL DEFAULT '1',
  `total_price` decimal(15,2) DEFAULT '0.00' COMMENT '商品总价,单位是元,保留两位小数',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `order_id_index` (`order_id`) USING BTREE,
  KEY `order_id_user_id_index` (`user_id`,`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of em_order_item
-- ----------------------------
BEGIN;
INSERT INTO `em_order_item` VALUES ('67605892056756224', 'user1', '67605891880595456', '123456', '小米笔记本', NULL, 'http://139.199.125.60/bijiben13.3.jpg', 5500.00, 2, 11000.00, '2019-03-18 13:21:41', NULL);
INSERT INTO `em_order_item` VALUES ('67605892056756225', 'user1', '67605891880595456', '12000', 'Xiaomi/小米 小米电视4A 43英寸4S PRO智能网络4K超清液晶电视机', NULL, 'http://139.199.125.60/xmds4a_43.png', 6000.00, 3, 18000.00, '2019-03-18 13:21:41', NULL);
INSERT INTO `em_order_item` VALUES ('67608189121867776', 'user1', '67608188983455744', '123456', '小米笔记本', NULL, 'http://139.199.125.60/bijiben13.3.jpg', 5500.00, 2, 11000.00, '2019-03-18 13:30:48', NULL);
INSERT INTO `em_order_item` VALUES ('67608189134450688', 'user1', '67608188983455744', '12000', 'Xiaomi/小米 小米电视4A 43英寸4S PRO智能网络4K超清液晶电视机', NULL, 'http://139.199.125.60/xmds4a_43.png', 6000.00, 3, 18000.00, '2019-03-18 13:30:48', NULL);
INSERT INTO `em_order_item` VALUES ('67622760402399232', 'user1', '67622760251404288', '123456', '小米笔记本', NULL, 'http://139.199.125.60/bijiben13.3.jpg', 5500.00, 2, 11000.00, '2019-03-18 14:28:42', NULL);
INSERT INTO `em_order_item` VALUES ('67622760410787840', 'user1', '67622760251404288', '12000', 'Xiaomi/小米 小米电视4A 43英寸4S PRO智能网络4K超清液晶电视机', NULL, 'http://139.199.125.60/xmds4a_43.png', 6000.00, 3, 18000.00, '2019-03-18 14:28:42', NULL);
INSERT INTO `em_order_item` VALUES ('68283102245695488', 'user1', '68283102115672064', '123456', '小米笔记本', NULL, 'http://139.199.125.60/bijiben13.3.jpg', 5500.00, 2, 11000.00, '2019-03-20 10:12:40', NULL);
INSERT INTO `em_order_item` VALUES ('68283102287638528', 'user1', '68283102115672064', '12000', 'Xiaomi/小米 小米电视4A 43英寸4S PRO智能网络4K超清液晶电视机', NULL, 'http://139.199.125.60/xmds4a_43.png', 6000.00, 3, 18000.00, '2019-03-20 10:12:40', NULL);
INSERT INTO `em_order_item` VALUES ('68293565490671616', 'user1', '68293565322899456', '123456', '小米笔记本', NULL, 'http://139.199.125.60/bijiben13.3.jpg', 5500.00, 2, 11000.00, '2019-03-20 10:54:15', NULL);
INSERT INTO `em_order_item` VALUES ('68293565532614656', 'user1', '68293565322899456', '12000', 'Xiaomi/小米 小米电视4A 43英寸4S PRO智能网络4K超清液晶电视机', NULL, 'http://139.199.125.60/xmds4a_43.png', 6000.00, 3, 18000.00, '2019-03-20 10:54:15', NULL);
INSERT INTO `em_order_item` VALUES ('68315112938942464', 'user1', '68315112766976000', '123456', '小米笔记本', NULL, 'http://139.199.125.60/bijiben13.3.jpg', 55.00, 2, 110.00, '2019-03-20 12:19:52', NULL);
INSERT INTO `em_order_item` VALUES ('68315112951525376', 'user1', '68315112766976000', '12000', 'Xiaomi/小米 小米电视4A 43英寸4S PRO智能网络4K超清液晶电视机', NULL, 'http://139.199.125.60/xmds4a_43.png', 60.00, 3, 180.00, '2019-03-20 12:19:52', NULL);
INSERT INTO `em_order_item` VALUES ('70953690491793408', 'user1', '70953690462433280', '123456', '小米笔记本', NULL, 'http://139.199.125.60/bijiben13.3.jpg', 55.00, 2, 110.00, '2019-03-27 19:04:38', NULL);
INSERT INTO `em_order_item` VALUES ('70953690500182016', 'user1', '70953690462433280', '12000', 'Xiaomi/小米 小米电视4A 43英寸4S PRO智能网络4K超清液晶电视机', NULL, 'http://139.199.125.60/xmds4a_43.png', 60.00, 3, 180.00, '2019-03-27 19:04:38', NULL);
INSERT INTO `em_order_item` VALUES ('70960625073008640', 'user1', '70960625056231424', '123456', '小米笔记本', NULL, 'http://139.199.125.60/bijiben13.3.jpg', 55.00, 2, 110.00, '2019-03-27 19:32:11', NULL);
INSERT INTO `em_order_item` VALUES ('70960625081397248', 'user1', '70960625056231424', '12000', 'Xiaomi/小米 小米电视4A 43英寸4S PRO智能网络4K超清液晶电视机', NULL, 'http://139.199.125.60/xmds4a_43.png', 60.00, 3, 180.00, '2019-03-27 19:32:11', NULL);
INSERT INTO `em_order_item` VALUES ('70968953585020928', '1', '70968953576632320', '123456', '小米笔记本', NULL, 'http://139.199.125.60/bijiben13.3.jpg', 55.00, 2, 110.00, '2019-03-27 20:05:17', NULL);
INSERT INTO `em_order_item` VALUES ('70968953593409536', '1', '70968953576632320', '12000', 'Xiaomi/小米 小米电视4A 43英寸4S PRO智能网络4K超清液晶电视机', NULL, 'http://139.199.125.60/xmds4a_43.png', 60.00, 3, 180.00, '2019-03-27 20:05:17', NULL);
INSERT INTO `em_order_item` VALUES ('71289697636462592', '1', '71289697623879680', '13212313213', '变形金刚领袖战争钢锁淤泥嚎叫飞镖铁渣组合机器恐龙男孩玩具', NULL, 'http://139.199.125.60/bxjg.jpg', 2800.00, 1, 2800.00, '2019-03-28 17:19:48', NULL);
INSERT INTO `em_order_item` VALUES ('71356596890120192', '1', '71356596848177152', '13212123211', '小米笔记本', NULL, 'http://139.199.125.60/bijiben13.3.jpg', 5500.00, 10, 55000.00, '2019-03-28 21:45:38', NULL);
INSERT INTO `em_order_item` VALUES ('71357023572471808', '1', '71357023555694592', '13211223658', 'Xiaomi/小米 小米电视4A 43英寸4S PRO智能网络4K超清液晶电视机', NULL, 'http://139.199.125.60/xmds4a_43.png', 2200.00, 1, 2200.00, '2019-03-28 21:47:20', NULL);
INSERT INTO `em_order_item` VALUES ('71357779901952000', '1', '71357779885174784', '13211223658', 'Xiaomi/小米 小米电视4A 43英寸4S PRO智能网络4K超清液晶电视机', NULL, 'http://139.199.125.60/xmds4a_43.png', 2200.00, 1, 2200.00, '2019-03-28 21:50:20', NULL);
INSERT INTO `em_order_item` VALUES ('71358347651330048', '1', '71358347634552832', '13211223658', 'Xiaomi/小米 小米电视4A 43英寸4S PRO智能网络4K超清液晶电视机', NULL, 'http://139.199.125.60/xmds4a_43.png', 2200.00, 1, 2200.00, '2019-03-28 21:52:36', NULL);
INSERT INTO `em_order_item` VALUES ('71359610136834048', '1', '71359610011004928', '13211223658', 'Xiaomi/小米 小米电视4A 43英寸4S PRO智能网络4K超清液晶电视机', NULL, 'http://139.199.125.60/xmds4a_43.png', 2200.00, 1, 2200.00, '2019-03-28 21:57:37', NULL);
COMMIT;

-- ----------------------------
-- Table structure for em_seller_comment
-- ----------------------------
DROP TABLE IF EXISTS `em_seller_comment`;
CREATE TABLE `em_seller_comment` (
  `seller_comment_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `order_item_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `comment` varchar(500) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `comment_type` tinyint(4) NOT NULL DEFAULT '1',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`seller_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of em_seller_comment
-- ----------------------------
BEGIN;
INSERT INTO `em_seller_comment` VALUES ('1111', '333', '189', 'afadsfasdfdsfs', 5, '1995-08-29 11:00:00', '2000-08-29 11:00:00');
COMMIT;

-- ----------------------------
-- Table structure for em_shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `em_shopping_cart`;
CREATE TABLE `em_shopping_cart` (
  `cart_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `item_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `item_title` varchar(256) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `stock_id` int(11) NOT NULL,
  `attr_vals` text COLLATE utf8_unicode_ci COMMENT '尺寸:XL 颜色:红色……',
  `attr_img` varchar(256) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `price` decimal(15,2) NOT NULL DEFAULT '0.00',
  `amount` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of em_shopping_cart
-- ----------------------------
BEGIN;
INSERT INTO `em_shopping_cart` VALUES ('72263733669789696', '37849334754447360', '小米MIX3', '42346568078196736', 2, '8G+128G 黑色', 'http://139.199.125.60/商品图片/Mix3/mix3_attr_2.jpg', 3599.00, 1);
COMMIT;

-- ----------------------------
-- Table structure for em_shufflingFigureData
-- ----------------------------
DROP TABLE IF EXISTS `em_shufflingFigureData`;
CREATE TABLE `em_shufflingFigureData` (
  `shuffling_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `source_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `img_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sorted` int(4) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `item_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`shuffling_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of em_shufflingFigureData
-- ----------------------------
BEGIN;
INSERT INTO `em_shufflingFigureData` VALUES ('72440981693542400', '/goodsdetail', 'http://139.199.125.60/test/xmad2.jpg', 1, '2019-03-31 08:34:36', '2019-03-31 08:34:36', '37905485735006208');
INSERT INTO `em_shufflingFigureData` VALUES ('72441102372057088', '/goodsdetail', 'http://139.199.125.60/test/xmad5.jpg', 2, '2019-03-31 08:35:05', '2019-03-31 08:35:05', '67296995131658240');
INSERT INTO `em_shufflingFigureData` VALUES ('72441218462003200', '/goodsdetail', 'http://139.199.125.60/test/xmad4.jpg', 3, '2019-03-31 08:35:32', '2019-03-31 08:35:32', '67290731974627328');
COMMIT;

-- ----------------------------
-- Table structure for em_user_info
-- ----------------------------
DROP TABLE IF EXISTS `em_user_info`;
CREATE TABLE `em_user_info` (
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `user_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0-普通用户 1-管理员\n',
  `real_name` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `telephone` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `address` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `email` varchar(256) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `gender` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0-保密,1-男,2-女',
  `avatar_url` varchar(256) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '默认为：空白头像地址',
  `birthday` datetime DEFAULT NULL,
  `hometown` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_index` (`user_name`) USING BTREE,
  UNIQUE KEY `email_index` (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of em_user_info
-- ----------------------------
BEGIN;
INSERT INTO `em_user_info` VALUES ('15540173587796053430', 'user', 0, '', '17855824130', '', '3333@qq.com', 1, '', NULL, '');
INSERT INTO `em_user_info` VALUES ('15540174371775745217', 'chaikai', 0, '柴凯', '13312222222', '浙江省/宁波市/鄞州区/', '444@qq.com', 1, '', '1995-08-29 11:00:00', '浙江省/衢州市/江山市/');
INSERT INTO `em_user_info` VALUES ('71907093032079360', '柴凯', 1, '张三', '17855824139', '天津市,天津,河西区', '363853018@qq.com', 0, 'https://raw.githubusercontent.com/XYY1010/WebImgSrc/master/test/3.jpg', '2019-03-11 11:00:00', '内蒙古,乌海市,乌达区');
COMMIT;

-- ----------------------------
-- Table structure for em_user_password
-- ----------------------------
DROP TABLE IF EXISTS `em_user_password`;
CREATE TABLE `em_user_password` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `encrpt_password` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of em_user_password
-- ----------------------------
BEGIN;
INSERT INTO `em_user_password` VALUES (27, '71907093032079360', '1111');
INSERT INTO `em_user_password` VALUES (28, '15540173587796053430', 'E10ADC3949BA59ABBE56E057F20F883E');
INSERT INTO `em_user_password` VALUES (29, '15540174371775745217', '96E79218965EB72C92A549DD5A330112');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
