package com.saas.titan.modules.ip.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.common.utils.DateUtils;
import com.saas.titan.modules.ip.service.IpContentService;
import com.saas.titan.modules.ip.vo.IpContentVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.saas.titan.modules.ip.dao.IpContentDao;
import com.saas.titan.modules.ip.entity.IpContentEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service("ipContentService")
public class IpContentServiceImpl extends ServiceImpl<IpContentDao, IpContentEntity> implements IpContentService {

    @Autowired
    private IpContentDao ipContentDao;

    @Override
    public Page<IpContentEntity> page(IpContentVo vo) {
        //构筑分页对象
        Page<IpContentEntity> page = new Page<>();
        page.setCurrent(vo.getPage());
        page.setSize(vo.getSize());
        //条件拼接
        QueryWrapper<IpContentEntity> query = new QueryWrapper<>();
        if (StringUtils.isNotBlank(vo.getHostName())) {
            query.eq(TableField.IpContent.HOST_NAME, vo.getHostName());
        }
        if (StringUtils.isNotBlank(vo.getRequestMethod())) {
            query.eq(TableField.IpContent.REQUEST_METHOD, vo.getRequestMethod());
        }
        if (StringUtils.isNotBlank(vo.getRequestPort())) {
            query.eq(TableField.IpContent.REQUEST_PORT, vo.getRequestPort());
        }
        List<String> time = vo.getTime();
        if (!(time.isEmpty())) {
            Date start = DateUtils.stringToDate(time.get(0), "yyyy-MM-dd");
            Date end = DateUtils.stringToDate(time.get(1), "yyyy-MM-dd");
            query.ge(TableField.IpContent.INSERT_TIME, start);
            query.le(TableField.IpContent.INSERT_TIME, end);
        }
        return ipContentDao.selectPage(page, query);
    }
}
