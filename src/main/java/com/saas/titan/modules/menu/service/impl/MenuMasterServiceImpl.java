package com.saas.titan.modules.menu.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.common.utils.TreeNodeUtils;
import com.saas.titan.modules.menu.dto.MenuMasterDto;
import com.saas.titan.modules.menu.service.MenuMasterService;
import com.saas.titan.modules.menu.vo.MenuMasterAddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.saas.titan.modules.menu.dao.MenuMasterDao;
import com.saas.titan.modules.menu.entity.MenuMasterEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("menuMasterService")
public class MenuMasterServiceImpl extends ServiceImpl<MenuMasterDao, MenuMasterEntity> implements MenuMasterService {

    @Autowired
    private MenuMasterDao menuMasterDao;

    @Override
    public Page<MenuMasterDto> getMenuList(BasicsVo vo) {
        //构筑分页对象
        Page<MenuMasterDto> page = new Page<>();
        page.setCurrent(vo.getPage());
        page.setSize(vo.getSize());
        Page<MenuMasterDto> menuMasterDtoPage = menuMasterDao.selectMenuList(page);
        return menuMasterDtoPage;
    }

    @Override
    public List<Tree<String>> getTreeList() {
        List<MenuMasterEntity> list = menuMasterDao.selectList(null);
        List<TreeNode<String>> res = CollUtil.newArrayList();
        list.forEach(item -> {
            TreeNode<String> node = new TreeNode<>();
            node.setId(item.getMenuId());
            node.setParentId(item.getParentMenuId());
            node.setName(item.getMenuName());
            Map<String, Object> map = new HashMap<>();
            map.put(TableField.MenuContentMaster.MENU_PATH, item.getMenuPath());
            map.put(TableField.MenuContentMaster.MENU_ICON, item.getMenuIcon());
            node.setExtra(map);
            res.add(node);
        });
        return TreeNodeUtils.getTree(res);
    }

    @Override
    public void insert(MenuMasterAddVo vo) {
        //构建实体类对象
        MenuMasterEntity entity = MenuMasterEntity.fromAdd(vo);
        //插入
        menuMasterDao.insert(entity);
    }
}
