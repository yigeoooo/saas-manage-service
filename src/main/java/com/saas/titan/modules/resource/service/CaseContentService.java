package com.saas.titan.modules.resource.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.modules.resource.dto.CaseContentDto;
import com.saas.titan.modules.resource.entity.CaseContentEntity;
import com.saas.titan.modules.resource.vo.CaseContentAddVo;
import com.saas.titan.modules.resource.vo.CaseContentVo;


/**
 * 案件内容表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-05 10:18:49
 */
public interface CaseContentService extends IService<CaseContentEntity> {
    /**
     * 新增case案例
     * @param vo 接参对象
     */
    void insert(CaseContentAddVo vo);

    /**
     * 分页查询content
     * @param vo 接参对象
     * @return page对象
     */
    Page<CaseContentDto> page(CaseContentVo vo);

}

