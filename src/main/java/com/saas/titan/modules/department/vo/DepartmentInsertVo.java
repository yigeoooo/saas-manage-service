package com.saas.titan.modules.department.vo;

import lombok.Data;

/**
 * 新增接参对象
 * @author yigeoooo
 * @since date 2024/1/28
 */
@Data
public class DepartmentInsertVo {
    /**
     * 科室名
     */
    private String departmentName;
    /**
     * key生成科室编码
     */
    private String key;
    /**
     * 主任医生
     */
    private String manager;

}
