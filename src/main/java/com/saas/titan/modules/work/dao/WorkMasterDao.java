package com.saas.titan.modules.work.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.modules.work.dto.WorkMasterDto;
import com.saas.titan.modules.work.entity.WorkMasterEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 员工打卡主档表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-10 11:42:30
 */
@Repository
@Mapper
@DS("datasource2")
public interface WorkMasterDao extends BaseMapper<WorkMasterEntity> {

    Page<WorkMasterDto> getList(@Param("page") Page<WorkMasterDto> page,
                                @Param("ew") QueryWrapper<WorkMasterDto> ew);

}
