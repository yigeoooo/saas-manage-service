package com.saas.titan.modules.icon.service.impl;

import com.saas.titan.modules.icon.service.IconMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.saas.titan.modules.icon.dao.IconMasterDao;
import com.saas.titan.modules.icon.entity.IconMasterEntity;



@Service("iconMasterService")
public class IconMasterServiceImpl extends ServiceImpl<IconMasterDao, IconMasterEntity> implements IconMasterService {

   @Autowired
    private IconMasterDao iconMasterDao;

}
