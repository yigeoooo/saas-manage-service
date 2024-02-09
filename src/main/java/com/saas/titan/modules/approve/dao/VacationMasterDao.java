package com.saas.titan.modules.approve.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.modules.approve.dto.VacationMasterAllPageDto;
import com.saas.titan.modules.approve.dto.VacationMasterPageDto;
import com.saas.titan.modules.approve.entity.VacationMasterEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 请假申请主表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-09 14:04:27
 */
@Repository
@Mapper
@DS("datasource2")
public interface VacationMasterDao extends BaseMapper<VacationMasterEntity> {

    Page<VacationMasterPageDto> getPage(@Param("page") Page<VacationMasterEntity> page,
                                        QueryWrapper<VacationMasterEntity> ew);

    Page<VacationMasterAllPageDto> getAllPage(@Param("page") Page<VacationMasterEntity> page,
                                              QueryWrapper<VacationMasterEntity> ew);

}
