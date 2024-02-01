package com.saas.titan.modules.menu.service;


import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.modules.menu.entity.MenuContentEntity;

import java.util.List;

/**
 * 菜单权限表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 16:19:51
 */
public interface MenuContentService extends IService<MenuContentEntity> {
    /**
     * 获取menuList
     * @return List
     */
    List<Tree<String>> getTreeList();

}

