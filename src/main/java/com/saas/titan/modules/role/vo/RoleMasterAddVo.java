package com.saas.titan.modules.role.vo;

import lombok.Data;

/**
 * @author yigeoooo
 * @since date 2024/2/2
 */
@Data
public class RoleMasterAddVo {

    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 状态 1：开启，0关闭
     */
    private boolean status;
    /**
     * 排序标识符
     */
    private Long sort;

}
