package com.saas.titan.modules.resource.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.modules.resource.dto.CaseContentDto;
import com.saas.titan.modules.resource.entity.CaseContentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 案件内容表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-05 10:18:49
 */
@Repository
@Mapper
@DS("datasource2")
public interface CaseContentDao extends BaseMapper<CaseContentEntity> {

    Page<CaseContentDto> getPage(@Param("page")Page<CaseContentEntity> page,
                                 @Param("ew")QueryWrapper<CaseContentEntity> ew);

}
