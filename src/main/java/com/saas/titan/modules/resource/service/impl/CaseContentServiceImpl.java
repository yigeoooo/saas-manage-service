package com.saas.titan.modules.resource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.exception.BusinessException;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.modules.resource.dao.CommonResourceDao;
import com.saas.titan.modules.resource.dto.CaseContentDto;
import com.saas.titan.modules.resource.entity.CommonResourceEntity;
import com.saas.titan.modules.resource.service.CaseContentService;
import com.saas.titan.modules.resource.vo.CaseContentAddVo;
import com.saas.titan.modules.resource.vo.CaseContentVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.saas.titan.modules.resource.dao.CaseContentDao;
import com.saas.titan.modules.resource.entity.CaseContentEntity;



@Service("caseContentService")
public class CaseContentServiceImpl extends ServiceImpl<CaseContentDao, CaseContentEntity> implements CaseContentService {

    @Autowired
    private CaseContentDao caseContentDao;
    @Autowired
    private CommonResourceDao commonResourceDao;

    @Override
    public void insert(CaseContentAddVo vo) {
        //校验是否主表存在信息
        QueryWrapper<CommonResourceEntity> query = new QueryWrapper<>();
        query.eq(TableField.CommonResource.RESOURCE_ID, vo.getResourceId());
        Integer count = commonResourceDao.selectCount(query);
        if (count == Constant.ZERO) {
            throw new BusinessException("不存在该资源！");
        }
        //实体类构建
        CaseContentEntity entity =  new CaseContentEntity();
        entity.setResourceId(vo.getResourceId());
        entity.setAuthor(vo.getAuthor());
        entity.setTitle(vo.getTitle());
        entity.setContent(vo.getContent());
        //插入
        caseContentDao.insert(entity);
    }

    @Override
    public Page<CaseContentDto> page(CaseContentVo vo) {
        //构建分页对象
        Page<CaseContentEntity> page = new Page<>(vo.getPage(), vo.getSize());
        //构筑条件
        QueryWrapper<CaseContentEntity> query = new QueryWrapper<>();
        if (StringUtils.isNotBlank(vo.getTitle())) {
            query.like("cc." + TableField.CaseContent.TITLE, vo.getTitle());
        }
        if (StringUtils.isNotBlank(vo.getAuthor())) {
            query.like("cc." + TableField.CaseContent.AUTHOR, vo.getAuthor());
        }
        query.eq(TableField.CommonResource.IS_DELETED, Constant.STR_ZERO);
        query.eq(TableField.CommonResource.STATUS, Constant.ONE);
        return caseContentDao.getPage(page, query);
    }
}
