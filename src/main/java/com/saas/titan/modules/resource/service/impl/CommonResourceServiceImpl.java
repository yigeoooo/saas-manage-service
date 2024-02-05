package com.saas.titan.modules.resource.service.impl;

import com.saas.titan.modules.resource.service.CommonResourceService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.saas.titan.modules.resource.dao.CommonResourceDao;
import com.saas.titan.modules.resource.entity.CommonResourceEntity;


@Service("commonResourceService")
public class CommonResourceServiceImpl extends ServiceImpl<CommonResourceDao, CommonResourceEntity> implements CommonResourceService {


}
