package com.saas.titan.modules.department.vo;

import lombok.Data;

/**
 * 編輯部门信息接参对象
 * @author yigeoooo
 * @since date 2024/1/31
 */
@Data
public class DepartmentEditVo {
    /**
     * 主键id
     */
    private String id;
    /**
     * 科室名
     */
    private String departmentName;
    /**
     *负责医生
     */
    private String manager;

}
