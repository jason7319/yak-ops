-- v1.3 development draft. V4/V5/V6 must be squashed before release freeze.
-- V1/V2/V3 are already published and remain immutable.
CREATE TABLE yak_ops_data_sync_table_attempt (
    id VARCHAR(64) NOT NULL COMMENT '表级Attempt主键，由应用雪花算法生成',
    workspace_id VARCHAR(64) NOT NULL COMMENT '所属工作空间ID',
    table_execution_id VARCHAR(64) NOT NULL COMMENT '关联Table Execution ID，不使用物理外键',
    attempt_no INT UNSIGNED NOT NULL COMMENT '单表内Attempt序号，从1开始',
    status TINYINT UNSIGNED NOT NULL COMMENT '尝试状态：1等待，2运行中，3成功，4失败，5已取消，6丢失',
    read_rows BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '本Attempt读取行数',
    write_rows BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '本Attempt写入行数，不表示事务提交确认',
    start_time DATETIME(3) NULL COMMENT '实际开始时间',
    finish_time DATETIME(3) NULL COMMENT '进入终态时间',
    error_code INT UNSIGNED NULL COMMENT '结构化错误码',
    error_message VARCHAR(1000) NULL COMMENT '脱敏错误消息',
    create_time DATETIME(3) NOT NULL COMMENT '创建时间',
    update_time DATETIME(3) NOT NULL COMMENT '更新时间',
    create_by VARCHAR(64) NOT NULL COMMENT '创建人标识',
    update_by VARCHAR(64) NOT NULL COMMENT '更新人标识',
    PRIMARY KEY (id),
    UNIQUE KEY uk_ops_data_sync_table_attempt_table_no (workspace_id, table_execution_id, attempt_no)
) ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8mb4
  COLLATE=utf8mb4_unicode_ci
  COMMENT='数据同步表级Attempt历史表';
