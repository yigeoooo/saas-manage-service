package com.saas.titan.modules.approve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.common.utils.ShiroUtils;
import com.saas.titan.common.utils.StringUtils;
import com.saas.titan.modules.approve.dto.VacationMasterAllPageDto;
import com.saas.titan.modules.approve.dto.VacationMasterPageDto;
import com.saas.titan.modules.approve.service.VacationMasterService;
import com.saas.titan.modules.approve.vo.VacationMasterInsertVo;
import com.saas.titan.modules.approve.vo.VacationPageVo;
import com.saas.titan.modules.sys.dao.SysUserDao;
import com.saas.titan.modules.sys.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.saas.titan.modules.approve.dao.VacationMasterDao;
import com.saas.titan.modules.approve.entity.VacationMasterEntity;

import java.time.LocalDate;
import java.util.List;


@Service("vacationMasterService")
public class VacationMasterServiceImpl extends ServiceImpl<VacationMasterDao, VacationMasterEntity> implements VacationMasterService {

    @Autowired
    private VacationMasterDao vacationMasterDao;

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public void insert(VacationMasterInsertVo vo) {
        //实体类构建
        VacationMasterEntity entity = new VacationMasterEntity();
        //获取开始与结束时间
        List<String> time = vo.getTime();
        entity.setBeginTime(LocalDate.parse(time.get(0)));
        entity.setEndTime(LocalDate.parse(time.get(1)));

        entity.setTypes(vo.getTypes());
        entity.setUserId(ShiroUtils.getUserId());
        entity.setDays(vo.getDays());
        entity.setReason(vo.getReason());
        entity.setStatus(Constant.STR_ZERO);
        entity.setInsertTime(LocalDate.now());
        //插入
        vacationMasterDao.insert(entity);
    }

    @Override
    public Page<VacationMasterPageDto> getPage(BasicsVo vo) {
        Page<VacationMasterEntity> page = new Page<>(vo.getPage(), vo.getSize());
        QueryWrapper<VacationMasterEntity> query = new QueryWrapper<>();
        query.eq(TableField.VacationMaster.USER_ID, ShiroUtils.getUserId());
        query.orderByDesc(TableField.VacationMaster.INSERT_TIME);
        return vacationMasterDao.getPage(page, query);
    }

    @Override
    public Page<VacationMasterAllPageDto> getAllPage(BasicsVo vo) {
        Page<VacationMasterEntity> page = new Page<>(vo.getPage(), vo.getSize());
        QueryWrapper<VacationMasterEntity> query = new QueryWrapper<>();
        query.orderByDesc(TableField.VacationMaster.INSERT_TIME);
        query.eq(TableField.VacationMaster.STATUS, Constant.STR_ZERO);
        Page<VacationMasterAllPageDto> pages = vacationMasterDao.getAllPage(page, query);
        List<VacationMasterAllPageDto> records = pages.getRecords();
        records.forEach(item -> {
            QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(TableField.VacationMaster.USER_ID, item.getUserId());
            SysUserEntity entity = sysUserDao.selectOne(queryWrapper);
            item.setUserName(entity.getUserName());
        });
        pages.setRecords(records);
        return pages;
    }

    @Override
    public Page<VacationMasterPageDto> getList(VacationPageVo vo) {
        Page<VacationMasterEntity> page = new Page<>(vo.getPage(), vo.getSize());
        QueryWrapper<VacationMasterEntity> query = new QueryWrapper<>();
        query.orderByDesc(TableField.VacationMaster.INSERT_TIME);
        if (StringUtils.isNotBlank(vo.getStatus())) {
            query.eq(TableField.VacationMaster.STATUS, vo.getStatus());
        } else {
            query.eq(TableField.VacationMaster.STATUS, Constant.STR_ONE)
                    .or()
                    .eq(TableField.VacationMaster.STATUS, Constant.STR_TWO);
        }
        Page<VacationMasterPageDto> pages = vacationMasterDao.getList(page, query);
        List<VacationMasterPageDto> records = pages.getRecords();
        records.forEach(item -> {
            QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(TableField.VacationMaster.USER_ID, item.getUserId());
            SysUserEntity entity = sysUserDao.selectOne(queryWrapper);
            item.setUserName(entity.getUserName());
        });
        pages.setRecords(records);
        return pages;
    }

    @Override
    public void passStatus(String userId) {
        vacationMasterDao.passStatus(userId);
    }

    @Override
    public void rejectStatus(String userId) {
        vacationMasterDao.rejectStatus(userId);
    }

}
