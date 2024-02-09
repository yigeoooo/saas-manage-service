package com.saas.titan.modules.approve.vo;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yigeoooo
 * @since date 2024/2/9
 */
@Data
public class VacationMasterInsertVo {

    /**
     * 请假类型（0:事假，1:婚假，2:丧假，3:病假，4:调休）
     */
    private String types;
    /**
     * 开始时间与结束时间数组
     */
    private List<String> time = new ArrayList<>();
    /**
     * 共计天数
     */
    private Long days;
    /**
     * 请假理由
     */
    private String reason;

}
