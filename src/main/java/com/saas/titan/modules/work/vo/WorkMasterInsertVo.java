package com.saas.titan.modules.work.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author yigeoooo
 * @since date 2024/2/10
 */
@Data
public class WorkMasterInsertVo {

    /**
     * 打卡时间
     */
    private LocalDate time;
    /**
     * 工作内容
     */
    private String work;

}
