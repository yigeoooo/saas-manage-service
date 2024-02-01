package com.saas.titan.modules.menu.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.modules.menu.dto.MenuMasterDto;
import com.saas.titan.modules.menu.service.MenuMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.saas.titan.modules.menu.dao.MenuMasterDao;
import com.saas.titan.modules.menu.entity.MenuMasterEntity;



@Service("menuMasterService")
public class MenuMasterServiceImpl extends ServiceImpl<MenuMasterDao, MenuMasterEntity> implements MenuMasterService {

    @Autowired
    private MenuMasterDao menuMasterDap;

    @Override
    public Page<MenuMasterDto> getMenuList(BasicsVo vo) {
        //构筑分页对象
        Page<MenuMasterDto> page = new Page<>();
        page.setCurrent(vo.getPage());
        page.setSize(vo.getSize());
        return menuMasterDap.selectMenuList(page);
    }
}
