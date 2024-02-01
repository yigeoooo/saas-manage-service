package com.saas.titan.modules.menu.dao;

import com.saas.titan.modules.menu.entity.MenuContentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 菜单权限表
 * 
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 16:19:51
 */
@Repository
@Mapper
public interface MenuContentDao extends BaseMapper<MenuContentEntity> {
	
}
