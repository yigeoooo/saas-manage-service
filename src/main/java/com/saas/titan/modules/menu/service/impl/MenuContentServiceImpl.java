package com.saas.titan.modules.menu.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.common.utils.ShiroUtils;
import com.saas.titan.common.utils.TreeNodeUtils;
import com.saas.titan.modules.menu.dao.MenuContentDao;
import com.saas.titan.modules.menu.dao.MenuMasterDao;
import com.saas.titan.modules.menu.entity.MenuContentEntity;
import com.saas.titan.modules.menu.entity.MenuMasterEntity;
import com.saas.titan.modules.menu.service.MenuContentService;
import com.saas.titan.modules.menu.vo.MenuContentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("menuContentService")
public class MenuContentServiceImpl extends ServiceImpl<MenuContentDao, MenuContentEntity> implements MenuContentService {

    @Autowired
    private MenuContentDao menuContentDao;

    @Autowired
    private MenuMasterDao menuMasterDao;

    @Override
    public List<Tree<String>> getTreeList() {
        //获取当前登录人的角色id
        String roleId = ShiroUtils.getRoleId();
        //查询该角色下所含有的菜单权限
        //条件构造
        QueryWrapper<MenuContentEntity> query = new QueryWrapper<>();
        query.eq(TableField.MenuContentMaster.ROLE_ID, roleId);
        query.orderByAsc(TableField.MenuContentMaster.SORT);
        List<MenuContentEntity> list = menuContentDao.selectList(query);
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
    @DSTransactional
    public void givePermission(MenuContentVo vo) {
        //menuId查询menu信息
        List<String> data = vo.getData();
        String roleId = vo.getRoleId();
        List<MenuContentEntity> list = new ArrayList<>();
        data.forEach(item -> {
            QueryWrapper<MenuMasterEntity> query = new QueryWrapper<>();
            query.eq(TableField.MenuMaster.MENU_ID, item);
            MenuMasterEntity entity = menuMasterDao.selectOne(query);
            //赋值MenuContentEntity
            MenuContentEntity from = MenuContentEntity.from(entity, roleId);
            list.add(from);
        });
        //删除之前权限
        QueryWrapper<MenuContentEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(TableField.MenuContentMaster.ROLE_ID, roleId);
        menuContentDao.delete(queryWrapper);
        //插入
        this.saveBatch(list);
    }
}
