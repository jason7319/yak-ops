package io.yak.ops.common.bean.vo.datasync;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * 单条 Table Execution 下某次 Runtime Attempt 的审计读模型。
 *
 * @author weifuwan
 * @since 2026-10-08
 */
@Data
public class DataSyncTableAttemptVO {

    /** 尝试 ID。 */
    private String id;

    /** 所属 Table Execution ID。 */
    private String tableExecutionId;

    /** 此表内尝试序号。 */
    private Integer attemptNo;

    /** PENDING / RUNNING / 终态。 */
    private String status;

    /** 此次尝试读取量。 */
    private Long readRows;

    /** 此次尝试写入量。 */
    private Long writeRows;

    /** 本次尝试开始时间。 */
    private LocalDateTime startTime;

    /** 本次尝试结束时间。 */
    private LocalDateTime finishTime;

    /** 错误码。 */
    private Integer errorCode;

    /** 脱敏错误信息。 */
    private String errorMessage;
}
