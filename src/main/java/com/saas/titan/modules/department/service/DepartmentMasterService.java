package com.saas.titan.modules.department.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.modules.department.dto.DepartmentDto;
import com.saas.titan.modules.department.entity.DepartmentMasterEntity;
import com.saas.titan.modules.department.vo.DepartmentEditVo;
import com.saas.titan.modules.department.vo.DepartmentInsertVo;
import com.saas.titan.modules.department.vo.DepartmentVo;

/**
 * 科室信息表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-01-28 11:15:31
 */
public interface DepartmentMasterService extends IService<DepartmentMasterEntity> {

    /**
     * 条件分页查询科室
     * @param departmentVo 接参vo
     * @return Page 分页对象
     */
    Page<DepartmentDto> page(DepartmentVo departmentVo);

    /**
     * 新建科室
     * @param param 接参对象
     */
    void insert(DepartmentInsertVo param);

    /**
     * 根据id查询信息
     * @param id 主键
     * @return DepartmentDto dto对象
     */
    DepartmentDto getInfoById(String id);

    /**
     * 编辑科室信息
     * @param vo 接参vo对象
     */
    void edit(DepartmentEditVo vo);

}

