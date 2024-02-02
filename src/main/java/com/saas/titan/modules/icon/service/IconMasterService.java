package com.saas.titan.modules.icon.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.modules.icon.entity.IconMasterEntity;

import java.util.Map;

/**
 *
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-02 17:10:47
 */
public interface IconMasterService extends IService<IconMasterEntity> {
    /**
     * 分页查询图标信息
     * @param vo 接参对象
     * @return IconMasterEntity
     */
    Page<IconMasterEntity> getList(BasicsVo vo);
}

