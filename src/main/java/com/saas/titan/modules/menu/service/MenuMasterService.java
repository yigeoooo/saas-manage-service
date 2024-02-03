package com.saas.titan.modules.menu.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.modules.menu.dto.MenuMasterDto;
import com.saas.titan.modules.menu.entity.MenuMasterEntity;
import com.saas.titan.modules.menu.vo.MenuMasterAddVo;

import java.util.List;


/**
 * 菜单主档表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 15:59:09
 */
public interface MenuMasterService extends IService<MenuMasterEntity> {

    /**
     * 查询菜单信息
     * @return Page page对象
     */
    Page<MenuMasterDto> getMenuList(BasicsVo vo);

    /**
     * 获取menuList
     * @return List
     */
    List<Tree<String>> getTreeList();

    /**
     * 新增菜单
     * @param vo 接参对象
     */
    void insert(MenuMasterAddVo vo);

}

