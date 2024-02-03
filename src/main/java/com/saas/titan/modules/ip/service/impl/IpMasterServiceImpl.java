package com.saas.titan.modules.ip.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.common.utils.StringUtils;
import com.saas.titan.modules.ip.service.IpMasterService;
import com.saas.titan.modules.ip.vo.IpMasterVo;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.saas.titan.modules.ip.dao.IpMasterDao;
import com.saas.titan.modules.ip.entity.IpMasterEntity;


@Service("ipMasterService")
public class IpMasterServiceImpl extends ServiceImpl<IpMasterDao, IpMasterEntity> implements IpMasterService {

    @Autowired
    private IpMasterDao ipMasterDao;

    @Override
    public Page<IpMasterEntity> getIpMasterList(IpMasterVo vo) {
        //构筑分页对象
        Page<IpMasterEntity> page = new Page<>();
        page.setCurrent(vo.getPage());
        page.setSize(vo.getSize());
        //条件拼接
        QueryWrapper<IpMasterEntity> query = new QueryWrapper<>();
        if (StringUtils.isNotBlank(vo.getHostName())) {
            query.eq(TableField.IpMaster.HOST_NAME, vo.getHostName());
        }
        query.eq(TableField.IpMaster.BAN_STATUS, vo.getBanStatus());
        return ipMasterDao.selectPage(page, query);
    }
}
