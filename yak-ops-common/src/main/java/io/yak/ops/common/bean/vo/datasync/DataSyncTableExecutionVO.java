package io.yak.ops.common.bean.vo.datasync;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * Root Execution 内某张表的执行状态与当前 / 最终 Attempt 指标镜像。
 *
 * @author weifuwan
 * @since 2026-10-08
 */
@Data
public class DataSyncTableExecutionVO {

    /** 稳定表级执行 ID。 */
    private String id;

    /** Root 创建时冻结的 Route ID。 */
    private String routeId;

    /** Root 创建时冻结的表顺序。 */
    private Integer routeOrder;

    /** PLANNED / PENDING / RUNNING / RETRY_WAITING / 终态。 */
    private String status;

    /** 此表当前或最后一次 Attempt 序号。 */
    private Integer currentAttempt;

    /** 此表当前或最终 Attempt 读取量。 */
    private Long readRows;

    /** 此表当前或最终 Attempt 写入量。 */
    private Long writeRows;

    /** 此表第一次实际开始运行的时间。 */
    private LocalDateTime startTime;

    /** 此表结束时间。 */
    private LocalDateTime finishTime;

    /** 此表失败码。 */
    private Integer errorCode;

    /** 此表失败时脱敏的错误信息。 */
    private String errorMessage;
}
