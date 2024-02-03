package com.saas.titan.modules.ip.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.modules.ip.entity.IpMasterEntity;
import com.saas.titan.modules.ip.vo.IpMasterVo;

/**
 * ip主档表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-03 11:02:07
 */
public interface IpMasterService extends IService<IpMasterEntity> {
    /**
     * 查询ip列表
     * @param vo 接参对象
     * @return 分页对象
     */
    Page<IpMasterEntity> getIpMasterList(IpMasterVo vo);

    /**
     * 修改封禁状态
     * @param id 主键
     */
    void changeStatus(String id);

}

