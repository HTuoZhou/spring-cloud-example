SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consumer
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer`
(
    `id`          bigint   NOT NULL COMMENT '主键',
    `count`       int      NOT NULL COMMENT '数量',
    `version`     tinyint  NOT NULL DEFAULT 1 COMMENT '版本号',
    `create_time` datetime NOT NULL COMMENT '开始时间',
    `update_time` datetime NOT NULL COMMENT '结束时间',
    `deleted`     tinyint  NOT NULL DEFAULT 0 COMMENT '逻辑删除(1、逻辑已删除 0、逻辑未删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '消费表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for provider
-- ----------------------------
DROP TABLE IF EXISTS `provider`;
CREATE TABLE `provider`
(
    `id`          bigint   NOT NULL COMMENT '主键',
    `consumer_id` bigint   NOT NULL COMMENT '消费表主键',
    `count`       int      NOT NULL COMMENT '数量',
    `version`     tinyint  NOT NULL DEFAULT 1 COMMENT '版本号',
    `create_time` datetime NOT NULL COMMENT '开始时间',
    `update_time` datetime NOT NULL COMMENT '结束时间',
    `deleted`     tinyint  NOT NULL DEFAULT 0 COMMENT '逻辑删除(1、逻辑已删除 0、逻辑未删除)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '提供表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`
(
    `branch_id`     bigint                                                  NOT NULL COMMENT 'branch transaction id',
    `xid`           varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'global transaction id',
    `context`       varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'undo_log context,such as serialization',
    `rollback_info` longblob                                                NOT NULL COMMENT 'rollback info',
    `log_status`    int                                                     NOT NULL COMMENT '0:normal status,1:defense status',
    `log_created`   datetime(6)                                             NOT NULL COMMENT 'create datetime',
    `log_modified`  datetime(6)                                             NOT NULL COMMENT 'modify datetime',
    UNIQUE INDEX `ux_undo_log` (`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = 'AT transaction mode undo table'
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
