package com.saas.titan.modules.approve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.common.utils.DateUtils;
import com.saas.titan.common.utils.ShiroUtils;
import com.saas.titan.modules.approve.dto.VacationMasterPageDto;
import com.saas.titan.modules.approve.service.VacationMasterService;
import com.saas.titan.modules.approve.vo.VacationMasterInsertVo;
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
        query.eq(TableField.ApproveMaster.USER_ID, ShiroUtils.getUserId());
        query.orderByDesc(TableField.ApproveMaster.INSERT_TIME);
        return vacationMasterDao.getPage(page, query);
    }
}
