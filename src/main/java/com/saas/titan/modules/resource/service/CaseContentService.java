package com.saas.titan.modules.resource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.modules.resource.entity.CaseContentEntity;
import com.saas.titan.modules.resource.vo.CaseContentAddVo;


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

}

