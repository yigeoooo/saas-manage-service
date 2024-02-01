package com.saas.titan.modules.menu.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.modules.menu.dto.MenuMasterDto;
import com.saas.titan.modules.menu.entity.MenuMasterEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 菜单主档表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 15:59:09
 */
@Repository
@Mapper
public interface MenuMasterDao extends BaseMapper<MenuMasterEntity> {

    Page<MenuMasterDto> selectMenuList(@Param("page") Page<MenuMasterDto> page);

}
