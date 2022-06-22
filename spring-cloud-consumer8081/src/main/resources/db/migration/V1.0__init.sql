SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for provider
-- ----------------------------
DROP TABLE IF EXISTS `provider`;
CREATE TABLE `provider`
(
    `id`          bigint                                                        NOT NULL COMMENT '主键',
    `consumer_id` bigint                                                        NOT NULL COMMENT '消费表主键',
    `count`       int                                                           NOT NULL COMMENT '数量',
    `version`     tinyint                                                       NOT NULL DEFAULT 1 COMMENT '版本号',
    `create_time` datetime                                                      NOT NULL COMMENT '开始时间',
    `update_time` datetime                                                      NOT NULL COMMENT '结束时间',
    `deleted`     tinyint                                                       NOT NULL DEFAULT 0 COMMENT '逻辑删除(1、逻辑已删除 0、逻辑未删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '提供表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of provider
-- ----------------------------
-- ----------------------------
-- Table structure for consumer
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer`
(
    `id`          bigint                                                        NOT NULL COMMENT '主键',
    `count`       int                                                           NOT NULL COMMENT '数量',
    `version`     tinyint                                                       NOT NULL DEFAULT 1 COMMENT '版本号',
    `create_time` datetime                                                      NOT NULL COMMENT '开始时间',
    `update_time` datetime                                                      NOT NULL COMMENT '结束时间',
    `deleted`     tinyint                                                       NOT NULL DEFAULT 0 COMMENT '逻辑删除(1、逻辑已删除 0、逻辑未删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '消费表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumer
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
