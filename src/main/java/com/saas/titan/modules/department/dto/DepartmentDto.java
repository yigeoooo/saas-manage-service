package com.saas.titan.modules.department.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * 查询封装对象
 * @author yigeoooo
 * @since date 2024/1/28
 */
@Data
public class DepartmentDto {

    /**
     * 主鍵id
     */
    private String id;
    /**
     * 科室名
     */
    private String departmentName;
    /**
     * 科室編碼
     */
    private String departmentCode;
    /**
     * 主管醫生
     */
    private String manager;
    /**
     * 插入時間
     */
    private LocalDate insertTime;



}
