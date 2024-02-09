package com.saas.titan.modules.approve.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.modules.approve.dto.VacationMasterAllPageDto;
import com.saas.titan.modules.approve.dto.VacationMasterPageDto;
import com.saas.titan.modules.approve.entity.VacationMasterEntity;
import com.saas.titan.modules.approve.vo.VacationMasterInsertVo;


/**
 * 请假申请主表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-09 14:04:27
 */
public interface VacationMasterService extends IService<VacationMasterEntity> {
    /**
     * 新建请假信息
     * @param vo 接参对象
     */
    void insert(VacationMasterInsertVo vo);

    /**
     * 分页查询请假信息
     * @param vo 接参对象
     * @return page 分页对象
     */
    Page<VacationMasterPageDto> getPage(BasicsVo vo);

    /**
     *
     * @param vo 接参对象
     * @return page 分页对象
     */
    Page<VacationMasterAllPageDto> getAllPage(BasicsVo vo);

}

