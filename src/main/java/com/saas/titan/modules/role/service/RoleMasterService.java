package com.saas.titan.modules.role.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.modules.role.dto.RoleMasterDto;
import com.saas.titan.modules.role.entity.RoleMasterEntity;


/**
 * 角色主档
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 16:43:52
 */
public interface RoleMasterService extends IService<RoleMasterEntity> {
    /**
     * 查询角色列表
      * @param vo 接参对象
     * @return Page 分页对象
     */
    Page<RoleMasterDto> getRoleList(BasicsVo vo);

    /**
     * 根据roleId修改角色状态
     * @param roleId 主键roleId
     */
    void changeStatus(String roleId);

}

