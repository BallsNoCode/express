/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : express

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 04/05/2022 19:13:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iddefault` int NULL DEFAULT 0,
  `user_id` int NOT NULL,
  `area` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, '张三a', '地址修改测试', 0, 7, '天津市天津市河西区', '13333333333');
INSERT INTO `address` VALUES (2, '李四', '陕西省西安市碑林区太白立交红星美凯龙四单元1201', 0, 7, '陕西省西安市', '13333333333');
INSERT INTO `address` VALUES (3, '帅哥', '爱送哪送哪', 1, 7, '北京市北京市东城区', '13333333333');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int NULL DEFAULT 0,
  `type` int NULL DEFAULT 1,
  `logintime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '0a6bd236b808f7e47c95b8b3a9ce452e', 0, 0, '2022-03-27 22:37:29');
INSERT INTO `admin` VALUES (2, 'user', '0a6bd236b808f7e47c95b8b3a9ce452e', 0, 1, '2022-03-27 22:37:31');
INSERT INTO `admin` VALUES (3, 'user1', '0a6bd236b808f7e47c95b8b3a9ce452e', 0, 1, NULL);

-- ----------------------------
-- Table structure for balance
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
CREATE TABLE `balance`  (
  `b_id` int NOT NULL AUTO_INCREMENT,
  `b_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `balance` decimal(19, 4) NULL DEFAULT NULL,
  `integral` int NULL DEFAULT NULL,
  `b_state` int NULL DEFAULT NULL,
  PRIMARY KEY (`b_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of balance
-- ----------------------------
INSERT INTO `balance` VALUES (1, '13333333333', 934.0000, 5496, 0);
INSERT INTO `balance` VALUES (2, '16666666666', 500.0000, 2000, 0);
INSERT INTO `balance` VALUES (3, '16675982450', 0.0000, 0, 0);

-- ----------------------------
-- Table structure for cdk
-- ----------------------------
DROP TABLE IF EXISTS `cdk`;
CREATE TABLE `cdk`  (
  `k_id` int NOT NULL AUTO_INCREMENT,
  `k_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `k_integral` int NULL DEFAULT NULL,
  `k_money` decimal(19, 4) NULL DEFAULT NULL,
  `k_state` int NULL DEFAULT NULL,
  PRIMARY KEY (`k_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cdk
-- ----------------------------
INSERT INTO `cdk` VALUES (1, '12344', 50, 100.0000, 1);
INSERT INTO `cdk` VALUES (2, NULL, NULL, NULL, 1);
INSERT INTO `cdk` VALUES (3, 'CBrUktTl1dHaWh1q9m', 10, 5.0000, 0);
INSERT INTO `cdk` VALUES (4, 'vca6Xiqp3rM7s2ymnA', 10, 10.0000, 0);
INSERT INTO `cdk` VALUES (5, '0B4PzbEGEFgCG2Dphe', 5, 20.0000, 0);
INSERT INTO `cdk` VALUES (6, 'h1nOq83sQLBXPwxvUa', 8, 22.0000, 0);
INSERT INTO `cdk` VALUES (7, 'n0UELIzWegp8940YHr', 6, 20.0000, 0);
INSERT INTO `cdk` VALUES (8, 'n9iekO6u8GK5dbwYop', 9, 55.0000, 0);
INSERT INTO `cdk` VALUES (9, 'CLkPfiZHWs4B7j6iLL', 10, 88.0000, 0);
INSERT INTO `cdk` VALUES (10, 'kEGGNCtJdmZA7mH4EE', 88, 888.0000, 0);
INSERT INTO `cdk` VALUES (11, 'ruZzDNPl5PHdOF7TZC', 666, 666.0000, 0);

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon`  (
  `c_id` int NOT NULL AUTO_INCREMENT,
  `c_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c_money` decimal(19, 4) NULL DEFAULT NULL,
  `c_condition` decimal(19, 4) NULL DEFAULT NULL,
  `c_cost` decimal(19, 4) NULL DEFAULT NULL,
  `c_integral` int NULL DEFAULT NULL,
  `c_state` int NULL DEFAULT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of coupon
-- ----------------------------
INSERT INTO `coupon` VALUES (3, '13333333333', 10.0000, 10.1000, 2.0000, 1000, 1);
INSERT INTO `coupon` VALUES (4, '', 10.0000, 10.1000, 2.0000, 1000, 1);
INSERT INTO `coupon` VALUES (5, NULL, 15.0000, 40.0000, 5.0000, 2000, 0);
INSERT INTO `coupon` VALUES (6, NULL, 15.0000, 40.0000, 5.0000, 2000, 0);
INSERT INTO `coupon` VALUES (7, NULL, 20.0000, 50.0000, 8.0000, 3000, 0);
INSERT INTO `coupon` VALUES (8, NULL, 10.0000, 10.1000, 2.0000, 1000, 0);
INSERT INTO `coupon` VALUES (9, '13333333333', 20.0000, 50.0000, 8.0000, 3000, 1);
INSERT INTO `coupon` VALUES (11, '13333333333', 10.0000, 25.0000, 2.0000, 20, 1);

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory`  (
  `e_id` int NOT NULL AUTO_INCREMENT,
  `e_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recipients` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `in_time` datetime NULL DEFAULT NULL,
  `out_time` datetime NULL DEFAULT NULL,
  `is_sent` int NULL DEFAULT 0,
  `e_state` int NULL DEFAULT NULL,
  PRIMARY KEY (`e_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of inventory
-- ----------------------------
INSERT INTO `inventory` VALUES (1, '773155659870426', '张三88', '13333333333', '申通快递', 'B2-09-12', '2022-02-25 21:40:27', '2022-03-27 19:45:02', 0, 1);
INSERT INTO `inventory` VALUES (2, '178552', '张三', '17777777777', 'test', '5555', '2022-02-24 22:06:55', '2022-03-27 22:06:58', 0, 1);
INSERT INTO `inventory` VALUES (3, '657657465', '张三', '12222222222', 'test', '5557', '2022-02-25 22:48:40', NULL, 0, 0);
INSERT INTO `inventory` VALUES (4, '78797', 'ss', '14444444444', 'test', '7777', '2022-02-25 22:49:02', NULL, 0, 0);
INSERT INTO `inventory` VALUES (5, '23123', '123', '13333333333', 'rr', 'A2-12-11', '2022-02-25 22:49:19', NULL, 0, 2);
INSERT INTO `inventory` VALUES (6, '6666', '1234', '16666666666', 'dd', '4545', '2022-02-25 22:49:41', NULL, 0, 3);
INSERT INTO `inventory` VALUES (7, '8765567', '11', '16675664777', 'aa', '4777', '2022-03-27 21:09:18', NULL, 0, 2);
INSERT INTO `inventory` VALUES (8, '76767', '121', '13333333333', 'aa', '2312', '2022-03-27 21:10:30', '2022-04-26 11:28:02', 0, 1);
INSERT INTO `inventory` VALUES (9, 'SF4687678786', '张三', '13333333333', '顺丰快递', 'A1-01-02', '2022-03-27 19:42:49', NULL, 0, 3);
INSERT INTO `inventory` VALUES (10, 'SF32132131', 'test', '13333333333', '顺丰速运', 'A1-01-03', '2022-04-24 20:45:54', NULL, 0, 2);
INSERT INTO `inventory` VALUES (11, 'SF12313546576', '李四', '16675982450', '顺丰速运', 'G7-3-1', '2022-03-31 13:11:32', NULL, 0, 0);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `message` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `state` int NULL DEFAULT 0,
  `type` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, '你有快递未领取，请尽快领取！', '13333333333', '2022-03-26 19:57:18', 0, 0);
INSERT INTO `message` VALUES (2, '由于疫情原因，快递服务暂停，开放时间另行通知，若造成不便敬请谅解！', NULL, '2022-03-26 21:03:37', 0, 1);
INSERT INTO `message` VALUES (3, '你有快递超时未取已退回，有疑问请联系快递公司', '13333333333', '2022-03-26 21:22:22', 0, 0);
INSERT INTO `message` VALUES (4, '你有快递到达站点，取件码：A2-02-11,请尽快领取！', '13333333333', '2022-03-26 22:05:15', 0, 0);
INSERT INTO `message` VALUES (8, 'sssss', '13333333388', '2022-03-31 07:19:52', 0, 0);
INSERT INTO `message` VALUES (9, 'tttt', NULL, '2022-03-31 07:25:59', 0, 1);

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay`  (
  `uid` int NOT NULL,
  `payPassword` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay
-- ----------------------------
INSERT INTO `pay` VALUES (6, '2e068ac929f0631fc990f6cc66928ce5');
INSERT INTO `pay` VALUES (7, '2e068ac929f0631fc990f6cc66928ce5');

-- ----------------------------
-- Table structure for transport
-- ----------------------------
DROP TABLE IF EXISTS `transport`;
CREATE TABLE `transport`  (
  `t_id` int NOT NULL AUTO_INCREMENT,
  `t_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sent_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sent_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sent_location` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pick_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pick_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pick_location` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `t_cost` decimal(19, 4) NULL DEFAULT NULL,
  `t_state` int NULL DEFAULT 0,
  `t_time` datetime NULL DEFAULT NULL,
  `t_ispay` int NULL DEFAULT 0,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 88 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of transport
-- ----------------------------
INSERT INTO `transport` VALUES (1, '123123123', '张三', '13333333333', '北京', '王五6', '18888888888', '广东省广州市', '顺丰速运', 20.0000, 0, '2022-03-29 21:25:08', 0);
INSERT INTO `transport` VALUES (2, '496526827', '张三', '18888888888', '北京', '李四', '18888888888', '广东', '顺丰速运', 25.0000, 0, '2022-03-27 21:31:38', 0);
INSERT INTO `transport` VALUES (35, '511717428016', '张三', '18888888888', 'test', '李四', '13360721887', 'test', '明亮物流', 66.0000, 0, '2022-03-27 21:31:41', 0);
INSERT INTO `transport` VALUES (37, '193680071594', '张三', '13333333333', 'test', '李四', '16675982450', '广东省东莞市高埗镇', '顺丰速运', 33.0000, 1, '2022-03-27 21:31:44', 1);
INSERT INTO `transport` VALUES (56, '401919588149', '张三', '13333333333', 'test', '李四', '18888888888', 'test', '圆通速递', 18.0000, 0, '2022-03-27 21:31:47', 0);
INSERT INTO `transport` VALUES (58, '4124', NULL, NULL, 'test', NULL, NULL, NULL, 'sf', NULL, 0, NULL, 0);
INSERT INTO `transport` VALUES (59, '31231', NULL, NULL, NULL, NULL, NULL, NULL, 'ss', NULL, 0, NULL, 0);
INSERT INTO `transport` VALUES (60, '321312', NULL, NULL, NULL, NULL, NULL, NULL, '21312', NULL, 0, NULL, 0);
INSERT INTO `transport` VALUES (61, '432414', NULL, NULL, NULL, NULL, NULL, NULL, '3213', NULL, 0, NULL, 0);
INSERT INTO `transport` VALUES (62, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '341314', NULL, 0, NULL, 0);
INSERT INTO `transport` VALUES (63, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '4124124', NULL, 0, NULL, 0);
INSERT INTO `transport` VALUES (64, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '543', NULL, 0, NULL, 0);
INSERT INTO `transport` VALUES (65, '3938402578791542', 'test', '18888888888', 'test', 'test', '13333333333', 'test', '顺丰速运', NULL, 0, '2022-03-29 14:08:02', 0);
INSERT INTO `transport` VALUES (66, 'tt', NULL, NULL, NULL, NULL, NULL, NULL, 'tt', NULL, 0, NULL, 0);
INSERT INTO `transport` VALUES (67, '656490470553', NULL, NULL, NULL, NULL, NULL, NULL, 'testRun', NULL, 0, '2022-03-31 13:11:57', 0);
INSERT INTO `transport` VALUES (68, '670694232268', NULL, NULL, NULL, NULL, NULL, NULL, 'testRun', NULL, 0, '2022-04-01 15:41:59', 0);
INSERT INTO `transport` VALUES (69, '443322509493', NULL, NULL, NULL, NULL, NULL, NULL, 'testRun', NULL, 0, '2022-04-01 15:48:28', 0);
INSERT INTO `transport` VALUES (70, '735372343498', NULL, NULL, NULL, NULL, NULL, NULL, 'testRun', NULL, 0, '2022-04-01 15:50:20', 0);
INSERT INTO `transport` VALUES (71, '331943557304', NULL, NULL, NULL, NULL, NULL, NULL, 'testRun', NULL, 0, '2022-04-01 15:54:16', 0);
INSERT INTO `transport` VALUES (72, '204971039866', NULL, NULL, NULL, NULL, NULL, NULL, 'testRun', NULL, 0, '2022-04-02 08:46:25', 0);
INSERT INTO `transport` VALUES (73, '761107256931', '李四', '13333333333', 'tset', '张三', '16666666666', 'test', '民航快递', 18.0000, 0, NULL, 0);
INSERT INTO `transport` VALUES (74, '536197277447', NULL, NULL, NULL, NULL, NULL, NULL, 'testRun', NULL, 0, '2022-04-12 08:18:27', 0);
INSERT INTO `transport` VALUES (75, '758028861484', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);
INSERT INTO `transport` VALUES (76, '809722123411', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);
INSERT INTO `transport` VALUES (77, '265665926650', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);
INSERT INTO `transport` VALUES (78, '339483601292', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);
INSERT INTO `transport` VALUES (79, '504208157212', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);
INSERT INTO `transport` VALUES (80, '295119144510', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);
INSERT INTO `transport` VALUES (81, '745970110085', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);
INSERT INTO `transport` VALUES (82, '529899162356', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);
INSERT INTO `transport` VALUES (83, '286876786877', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);
INSERT INTO `transport` VALUES (84, '577596223505', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);
INSERT INTO `transport` VALUES (85, '841881642616', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);
INSERT INTO `transport` VALUES (86, '130689204509', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);
INSERT INTO `transport` VALUES (87, '554592796179', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);
INSERT INTO `transport` VALUES (88, '022608994974', NULL, NULL, NULL, NULL, NULL, NULL, 'sf', NULL, 0, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_id` int NOT NULL AUTO_INCREMENT,
  `u_username` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_idCard` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_trueName` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_sex` int NULL DEFAULT NULL,
  `u_age` int NULL DEFAULT NULL,
  `u_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_createtime` datetime NULL DEFAULT NULL,
  `u_logintime` datetime NULL DEFAULT NULL,
  `u_state` int NULL DEFAULT NULL,
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '帅哥', '5465456ee', '441900200207012614', '张三', 0, 18, '16675664777', '2022-02-13 21:15:06', '2022-03-02 13:03:52', 0);
INSERT INTO `user` VALUES (2, 'user', '123456', '111111111', '李四', 0, 18, '16666666666', '2022-02-13 21:15:37', '2022-04-26 03:32:23', 0);
INSERT INTO `user` VALUES (3, 'tt', '123456', '46767676', 'test', 0, 18, '17777777777', '2022-02-28 21:43:43', '2022-02-28 21:43:47', 0);
INSERT INTO `user` VALUES (4, 'aa', '123456', '23213123', 'ee', 0, 18, '12222222222', '2022-02-28 21:44:08', '2022-02-28 21:44:11', 0);
INSERT INTO `user` VALUES (5, 'tt', '213123', '2312312', 'tt', 0, 18, '14444444444', '2022-02-28 21:44:42', '2022-02-28 21:44:45', 0);
INSERT INTO `user` VALUES (6, 'uu', '21312312', '21312321', 'yy', 1, 24, '18888888888', '2022-02-28 21:45:57', '2022-04-26 03:29:33', 0);
INSERT INTO `user` VALUES (7, 'dadada', '123456', '4646546', '啦啦啦', 0, 18, '13333333333', '2022-03-03 22:01:47', '2022-05-04 10:09:01', 0);
INSERT INTO `user` VALUES (11, NULL, NULL, NULL, NULL, NULL, NULL, '16675982450', '2022-03-05 11:03:22', '2022-03-11 09:05:06', 0);
INSERT INTO `user` VALUES (12, NULL, NULL, NULL, NULL, NULL, NULL, '19842747279', '2022-03-11 09:05:42', '2022-03-11 09:12:10', 0);
INSERT INTO `user` VALUES (13, NULL, NULL, NULL, NULL, NULL, NULL, '15627574074', '2022-03-11 09:32:33', '2022-03-11 09:32:33', 0);

SET FOREIGN_KEY_CHECKS = 1;
