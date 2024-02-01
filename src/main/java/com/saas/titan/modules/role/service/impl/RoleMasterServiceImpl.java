package com.saas.titan.modules.role.service.impl;

import com.saas.titan.modules.role.service.RoleMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.saas.titan.modules.role.dao.RoleMasterDao;
import com.saas.titan.modules.role.entity.RoleMasterEntity;



@Service("roleMasterService")
public class RoleMasterServiceImpl extends ServiceImpl<RoleMasterDao, RoleMasterEntity> implements RoleMasterService {

    @Autowired
    private RoleMasterDao roleMasterDao;

}
