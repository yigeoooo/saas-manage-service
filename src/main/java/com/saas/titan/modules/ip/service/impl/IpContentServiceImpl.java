package com.saas.titan.modules.ip.service.impl;

import com.saas.titan.modules.ip.service.IpContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.saas.titan.modules.ip.dao.IpContentDao;
import com.saas.titan.modules.ip.entity.IpContentEntity;



@Service("ipContentService")
public class IpContentServiceImpl extends ServiceImpl<IpContentDao, IpContentEntity> implements IpContentService {

    @Autowired
    private IpContentDao ipContentDao;

}
