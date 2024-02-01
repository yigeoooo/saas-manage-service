package com.saas.titan.modules.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.saas.titan.modules.menu.dao.MenuContentDao;
import com.saas.titan.modules.menu.entity.MenuContentEntity;
import com.saas.titan.modules.menu.service.MenuContentService;
import org.springframework.stereotype.Service;


@Service("menuContentService")
public class MenuContentServiceImpl extends ServiceImpl<MenuContentDao, MenuContentEntity> implements MenuContentService {



}
