package com.saas.titan.modules.resource.service.impl;

import com.saas.titan.modules.resource.service.CaseContentService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.saas.titan.modules.resource.dao.CaseContentDao;
import com.saas.titan.modules.resource.entity.CaseContentEntity;



@Service("caseContentService")
public class CaseContentServiceImpl extends ServiceImpl<CaseContentDao, CaseContentEntity> implements CaseContentService {


}
