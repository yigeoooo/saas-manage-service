package com.saas.titan.modules.ip.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.tableField.TableField;
import com.saas.titan.common.utils.DateUtils;
import com.saas.titan.modules.ip.dto.EchartsDto;
import com.saas.titan.modules.ip.dto.IpContentEchartsCountDto;
import com.saas.titan.modules.ip.dto.IpContentEchartsListDto;
import com.saas.titan.modules.ip.service.IpContentService;
import com.saas.titan.modules.ip.vo.IpContentVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.saas.titan.modules.ip.dao.IpContentDao;
import com.saas.titan.modules.ip.entity.IpContentEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service("ipContentService")
public class IpContentServiceImpl extends ServiceImpl<IpContentDao, IpContentEntity> implements IpContentService {

    @Autowired
    private IpContentDao ipContentDao;

    private static final String GET_METHOD = "GET";

    private static final String POST_METHOD = "POST";

    private static final String DELETE_METHOD = "DELETE";

    private static final String PUT_METHOD = "PUT";

    private static final String PATCH_METHOD = "PATCH";

    private static final String LINE = "line";

    private static final String TOTAL = "Total";

    private static final String PATTERN = "yyyy-MM-dd";

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
            query.eq(TableField.IpContent.REQUEST_PORT, vo.getRequestPort().toUpperCase());
        }
        List<String> time = vo.getTime();
        if (!(time.isEmpty())) {
            Date start = DateUtils.stringToDate(time.get(Constant.ZERO), PATTERN);
            Date end = DateUtils.stringToDate(time.get(Constant.ONE), PATTERN);
            query.ge(TableField.IpContent.INSERT_TIME, start);
            query.le(TableField.IpContent.INSERT_TIME, end);
        }
        return ipContentDao.selectPage(page, query);
    }

    @Override
    public List<IpContentEchartsListDto> getInfo(String hostName) {
        IpContentEchartsListDto getDto = getListDto(hostName, GET_METHOD);
        IpContentEchartsListDto postDto = getListDto(hostName, POST_METHOD);
        IpContentEchartsListDto deleteDto = getListDto(hostName, DELETE_METHOD);
        IpContentEchartsListDto patchDto = getListDto(hostName, PATCH_METHOD);
        IpContentEchartsListDto putDto = getListDto(hostName, PUT_METHOD);
        return Arrays.asList(getDto, postDto, deleteDto, patchDto, putDto);
    }

    @Override
    public IpContentEchartsCountDto getEcharts(String hostName) {
        //返回值
        IpContentEchartsCountDto dto = new IpContentEchartsCountDto();
        //获取过去七天日期
        List<LocalDate> days = getDays();
        dto.setDayList(days);
        //封装具体数据
        List<EchartsDto> list = new ArrayList<>();
        list.add(getDto(GET_METHOD, hostName));
        list.add(getDto(POST_METHOD, hostName));
        list.add(getDto(DELETE_METHOD, hostName));
        list.add(getDto(PUT_METHOD, hostName));
        list.add(getDto(PATCH_METHOD, hostName));
        dto.setList(list);
        return dto;
    }

    private IpContentEchartsListDto getListDto(String hostName, String method) {
        QueryWrapper<IpContentEntity> query = new QueryWrapper<>();
        query.eq(TableField.IpContent.HOST_NAME, hostName);
        query.eq(TableField.IpContent.REQUEST_METHOD, method);
        LocalDate now = LocalDate.now();
        query.ge(TableField.IpContent.INSERT_TIME, now.plusDays(-Constant.ONE));
        query.le(TableField.IpContent.INSERT_TIME, now.plusDays(Constant.ONE));
        Integer value = ipContentDao.selectCount(query);
        IpContentEchartsListDto dto = new IpContentEchartsListDto();
        dto.setValue(value);
        dto.setName(method);
        return dto;
    }

    private List<LocalDate> getDays() {
        LocalDate now = LocalDate.now();
        return Arrays.asList(
                now.plusDays(-Constant.SIX),
                now.plusDays(-Constant.FIVE),
                now.plusDays(-Constant.FUOR),
                now.plusDays(-Constant.THREE),
                now.plusDays(-Constant.TWO),
                now.plusDays(-Constant.ONE),
                now);
    }

    private EchartsDto getDto(String method, String hostName) {
        EchartsDto dto = new EchartsDto();
        dto.setName(method);
        dto.setType(LINE);
        dto.setStack(TOTAL);
        //查询该方法过去七天数据
        List<Integer> list = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (int i = Constant.SIX; i >= Constant.ZERO; i--) {
            QueryWrapper<IpContentEntity> query = new QueryWrapper<>();
            query.eq(TableField.IpContent.HOST_NAME, hostName);
            query.eq(TableField.IpContent.REQUEST_METHOD, method);
            query.eq(TableField.IpContent.INSERT_TIME, now.plusDays(-i));
            Integer count = ipContentDao.selectCount(query);
            list.add(count);
        }
        dto.setData(list);
        return dto;
    }
}
