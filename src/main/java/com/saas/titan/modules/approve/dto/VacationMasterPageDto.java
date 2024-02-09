package com.saas.titan.modules.approve.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author yigeoooo
 * @since date 2024/2/9
 */
@Data
public class VacationMasterPageDto {
    /**
     * 系统用户id
     */
    private String userId;
    /**
     * 系统用户名
     */
    private String userName;
    /**
     * 请假类型（0:事假，1:婚假，2:丧假，3:病假，4:调休）
     */
    private String types;
    /**
     * 开始时间
     */
    private LocalDate beginTime;
    /**
     * 结束时间
     */
    private LocalDate endTime;
    /**
     * 共计天数
     */
    private Long days;
    /**
     * 请假理由
     */
    private String reason;
    /**
     * 状态（0:未受理，1:通过，2：驳回）
     */
    private String status;

}
