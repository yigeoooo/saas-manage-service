package com.saas.titan.modules.work.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author yigeoooo
 * @since date 2024/2/10
 */
@Data
public class WorkMasterDto {

    /**
     * 系统用户id
     */
    private String userId;
    /**
     * 系统用户名
     */
    private String userName;
    /**
     * 角色
     */
    private String role;
    /**
     * 打卡时间
     */
    private LocalDate time;
    /**
     * 工作内容
     */
    private String work;

}
