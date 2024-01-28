package com.saas.titan.modules.department.vo;

import com.saas.titan.common.pojo.vo.BasicsVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 接参对象
 * @author yigeoooo
 * @since date 2024/1/28
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DepartmentVo extends BasicsVo {
    /**
     * 科室编码
     */
    private String departmentCode;
    /**
     * 科室名
     */
    private String departmentName;

}
