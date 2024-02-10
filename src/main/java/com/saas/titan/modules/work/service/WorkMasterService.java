package com.saas.titan.modules.work.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.modules.work.dto.WorkMasterDto;
import com.saas.titan.modules.work.entity.WorkMasterEntity;
import com.saas.titan.modules.work.vo.WorkMasterInsertVo;
import com.saas.titan.modules.work.vo.WorkMasterVo;


/**
 * 员工打卡主档表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-10 11:42:30
 */
public interface WorkMasterService extends IService<WorkMasterEntity> {

    /**
     * 新增打卡信息
     * @param vo 接参对象
     */
    void insert(WorkMasterInsertVo vo);

    /**
     * 查询个人打卡记录
     * @return Page
     */
    Page<WorkMasterDto> getList(BasicsVo vo);

    /**
     * 过滤条件查询所有员工打卡信息
     * @return Page
     */
    Page<WorkMasterDto> getPage(WorkMasterVo vo);

}

