package com.saas.titan.modules.role.dao;

import com.saas.titan.modules.role.entity.RoleMasterEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
	
}
