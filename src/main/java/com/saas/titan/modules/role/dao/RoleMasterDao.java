package com.saas.titan.modules.role.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.modules.role.dto.RoleMasterDto;
import com.saas.titan.modules.role.dto.RoleMasterListDto;
import com.saas.titan.modules.role.entity.RoleMasterEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色主档
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 16:43:52
 */
@Repository
@Mapper
public interface RoleMasterDao extends BaseMapper<RoleMasterEntity> {

    Page<RoleMasterDto> getRoleList(@Param("page") Page<RoleMasterDto> page);

    Integer changeStatus(@Param("roleId") String roleId);

    List<RoleMasterListDto> getList();

}
