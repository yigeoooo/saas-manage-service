package com.saas.titan.modules.menu.service.impl;

import com.saas.titan.modules.menu.service.MenuMasterService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.saas.titan.modules.menu.dao.MenuMasterDao;
import com.saas.titan.modules.menu.entity.MenuMasterEntity;



@Service("menuMasterService")
public class MenuMasterServiceImpl extends ServiceImpl<MenuMasterDao, MenuMasterEntity> implements MenuMasterService {

}
