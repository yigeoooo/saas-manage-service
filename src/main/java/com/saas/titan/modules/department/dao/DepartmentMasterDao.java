package com.saas.titan.modules.department.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.modules.department.dto.DepartmentDto;
import com.saas.titan.modules.department.entity.DepartmentMasterEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 科室信息表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-01-28 11:15:31
 */
@Repository
@Mapper
public interface DepartmentMasterDao extends BaseMapper<DepartmentMasterEntity> {

    Page<DepartmentDto> getPage(@Param("page") Page<DepartmentMasterEntity> page,
                                @Param("ew") QueryWrapper<DepartmentMasterEntity> ew);

}
