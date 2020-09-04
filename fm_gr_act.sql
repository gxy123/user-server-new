/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : fm_user_center

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 25/08/2020 16:53:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fm_gr_act
-- ----------------------------
DROP TABLE IF EXISTS `fm_gr_act`;
CREATE TABLE `fm_gr_act`  (
  `id` bigint(11) NOT NULL,
  `action_id` bigint(11) NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_public` int(2) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `des` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '接口' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_gr_act_b
-- ----------------------------
DROP TABLE IF EXISTS `fm_gr_act_b`;
CREATE TABLE `fm_gr_act_b`  (
  `id` bigint(11) NOT NULL,
  `action_map_id` bigint(11) NULL DEFAULT NULL,
  `action_id` bigint(11) NULL DEFAULT NULL,
  `btn_id` bigint(11) NULL DEFAULT NULL,
  `menu_id` bigint(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_gr_dept
-- ----------------------------
DROP TABLE IF EXISTS `fm_gr_dept`;
CREATE TABLE `fm_gr_dept`  (
  `id` bigint(11) NOT NULL,
  `dept_id` bigint(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` bigint(11) NULL DEFAULT NULL,
  `owner` bigint(11) NULL DEFAULT NULL COMMENT '负责人',
  `des` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_gr_menu
-- ----------------------------
DROP TABLE IF EXISTS `fm_gr_menu`;
CREATE TABLE `fm_gr_menu`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(11) NULL DEFAULT NULL,
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` bigint(11) NULL DEFAULT NULL,
  `level` int(2) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表共三级' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_gr_menu_btn
-- ----------------------------
DROP TABLE IF EXISTS `fm_gr_menu_btn`;
CREATE TABLE `fm_gr_menu_btn`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `btn_id` bigint(11) NULL DEFAULT NULL,
  `btn_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_id` bigint(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_gr_role
-- ----------------------------
DROP TABLE IF EXISTS `fm_gr_role`;
CREATE TABLE `fm_gr_role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(11) NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `des` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_gr_role_m
-- ----------------------------
DROP TABLE IF EXISTS `fm_gr_role_m`;
CREATE TABLE `fm_gr_role_m`  (
  `id` bigint(11) NOT NULL,
  `role_menu_id` bigint(11) NULL DEFAULT NULL,
  `role_id` bigint(11) NULL DEFAULT NULL,
  `menu_id` bigint(11) NULL DEFAULT NULL,
  `parent_id` bigint(11) NULL DEFAULT NULL,
  `btn_id` bigint(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_gr_user
-- ----------------------------
DROP TABLE IF EXISTS `fm_gr_user`;
CREATE TABLE `fm_gr_user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NULL DEFAULT NULL,
  `open_id` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pass_word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `header_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(2) NULL DEFAULT NULL COMMENT '是否是后台用户0:不是，1:是',
  `state` int(2) NULL DEFAULT NULL COMMENT '是否注销0：否，1：是',
  `des` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_gr_user_d
-- ----------------------------
DROP TABLE IF EXISTS `fm_gr_user_d`;
CREATE TABLE `fm_gr_user_d`  (
  `id` bigint(11) NOT NULL,
  `user_id` bigint(11) NULL DEFAULT NULL COMMENT '用户',
  `dept_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fm_gr_user_r
-- ----------------------------
DROP TABLE IF EXISTS `fm_gr_user_r`;
CREATE TABLE `fm_gr_user_r`  (
  `id` bigint(11) NOT NULL,
  `user_role_id` bigint(11) NULL DEFAULT NULL,
  `user_id` bigint(11) NULL DEFAULT NULL,
  `role_id` bigint(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与角色关联表' ROW_FORMAT = Dynamic;
CREATE TABLE `oauth_client_details` (
`client_id` varchar(255) NOT NULL,
`resource_ids` varchar(255) DEFAULT NULL,
`client_secret` varchar(255) DEFAULT NULL,
`scope` varchar(255) DEFAULT NULL,
`authorized_grant_types` varchar(255) DEFAULT NULL,
`web_server_redirect_uri` varchar(255) DEFAULT NULL,
`authorities` varchar(255) DEFAULT NULL,
`access_token_validity` int(11) DEFAULT NULL,
`refresh_token_validity` int(11) DEFAULT NULL,
`additional_information` text,
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`archived` tinyint(1) DEFAULT '0',
`trusted` tinyint(1) DEFAULT '0',
`autoapprove` varchar(255) DEFAULT 'false',
PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oauth_access_token` (
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`token_id` varchar(255) DEFAULT NULL,
`token` blob,
`authentication_id` varchar(255) DEFAULT NULL,
`user_name` varchar(255) DEFAULT NULL,
`client_id` varchar(255) DEFAULT NULL,
`authentication` blob,
`refresh_token` varchar(255) DEFAULT NULL,
KEY `token_id_index` (`token_id`),
KEY `authentication_id_index` (`authentication_id`),
KEY `user_name_index` (`user_name`),
KEY `client_id_index` (`client_id`),
KEY `refresh_token_index` (`refresh_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oauth_code` (
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`code` varchar(255) DEFAULT NULL,
`authentication` blob,
KEY `code_index` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oauth_refresh_token` (
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`token_id` varchar(255) DEFAULT NULL,
`token` blob,
`authentication` blob,
KEY `token_id_index` (`token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_traveller` (
`orderId` varchar(32) NOT NULL DEFAULT '',
`travellerId` varchar(32) NOT NULL DEFAULT '',
PRIMARY KEY (`orderId`,`travellerId`),
KEY `travellerId` (`travellerId`),
CONSTRAINT `order_traveller_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`),
CONSTRAINT `order_traveller_ibfk_2` FOREIGN KEY (`travellerId`) REFERENCES `traveller` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
