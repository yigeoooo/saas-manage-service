package com.saas.titan.modules.ip.service.impl;

import com.saas.titan.modules.ip.service.IpMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.saas.titan.modules.ip.dao.IpMasterDao;
import com.saas.titan.modules.ip.entity.IpMasterEntity;


@Service("ipMasterService")
public class IpMasterServiceImpl extends ServiceImpl<IpMasterDao, IpMasterEntity> implements IpMasterService {

    @Autowired
    private IpMasterDao ipMasterDao;

}
