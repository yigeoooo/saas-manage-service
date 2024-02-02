package com.saas.titan.modules.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.modules.role.dto.RoleMasterDto;
import com.saas.titan.modules.role.service.RoleMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.saas.titan.modules.role.dao.RoleMasterDao;
import com.saas.titan.modules.role.entity.RoleMasterEntity;



@Service("roleMasterService")
public class RoleMasterServiceImpl extends ServiceImpl<RoleMasterDao, RoleMasterEntity> implements RoleMasterService {

    @Autowired
    private RoleMasterDao roleMasterDao;

    @Override
    public Page<RoleMasterDto> getRoleList(BasicsVo vo) {
        //构筑分页对象
        Page<RoleMasterDto> page = new Page<>();
        page.setCurrent(vo.getPage());
        page.setSize(vo.getSize());
        return roleMasterDao.getRoleList(page);
    }

    @Override
    public void changeStatus(String roleId) {
        //修改
        roleMasterDao.changeStatus(roleId);
    }
}
