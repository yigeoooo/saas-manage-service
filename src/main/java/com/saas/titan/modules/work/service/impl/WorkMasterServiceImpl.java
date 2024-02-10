package com.saas.titan.modules.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.common.utils.ShiroUtils;
import com.saas.titan.modules.role.dao.RoleMasterDao;
import com.saas.titan.modules.role.entity.RoleMasterEntity;
import com.saas.titan.modules.sys.dao.SysUserDao;
import com.saas.titan.modules.sys.entity.SysUserEntity;
import com.saas.titan.modules.work.dto.WorkMasterDto;
import com.saas.titan.modules.work.service.WorkMasterService;
import com.saas.titan.modules.work.vo.WorkMasterInsertVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.saas.titan.modules.work.dao.WorkMasterDao;
import com.saas.titan.modules.work.entity.WorkMasterEntity;

import java.util.List;


@Service("workMasterService")
public class WorkMasterServiceImpl extends ServiceImpl<WorkMasterDao, WorkMasterEntity> implements WorkMasterService {

    @Autowired
    private WorkMasterDao workMasterDao;

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private RoleMasterDao roleMasterDao;

    @Override
    public void insert(WorkMasterInsertVo vo) {
        //实体类构建
        WorkMasterEntity entity = new WorkMasterEntity();
        entity.setWork(vo.getWork());
        entity.setTime(vo.getTime());
        entity.setUserId(ShiroUtils.getUserId());
        //插入
        workMasterDao.insert(entity);
    }

    @Override
    public Page<WorkMasterDto> getList(BasicsVo vo) {
        //构筑分页对象
        Page<WorkMasterDto> page = new Page<>(vo.getPage(), vo.getSize());
        //条件构造
        QueryWrapper<WorkMasterDto> query = new QueryWrapper<>();
        query.eq(TableField.WorkMaster.USER_ID, ShiroUtils.getUserId());
        query.orderByDesc(TableField.WorkMaster.TIME);
        Page<WorkMasterDto> pages = workMasterDao.getList(page, query);
        List<WorkMasterDto> records = pages.getRecords();
        records.forEach(item -> {
            QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(TableField.WorkMaster.USER_ID, item.getUserId());
            SysUserEntity entity = sysUserDao.selectOne(queryWrapper);
            item.setUserName(entity.getUserName());
            //查询角色名
            String roleId = entity.getRoleId();
            QueryWrapper<RoleMasterEntity> ew = new QueryWrapper<>();
            ew.eq(TableField.RoleMaster.ROLE_ID, roleId);
            RoleMasterEntity roleMasterEntity = roleMasterDao.selectOne(ew);
            item.setRole(roleMasterEntity.getRoleName());
        });
        pages.setRecords(records);
        return pages;
    }
}
