package com.saas.titan.modules.role.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author yigeoooo
 * @since date 2024/2/1
 */
@Data
public class RoleMasterDto {
    /**
     * 主键id
     */
    private String roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 插入人id
     */
    private String insertUserId;
    /**
     * 插入时间
     */
    private LocalDate insertTime;
    /**
     * 状态 1：开启，0关闭
     */
    private boolean status;

}
