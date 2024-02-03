package com.saas.titan.modules.ip.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.modules.ip.dto.IpContentEchartsCountDto;
import com.saas.titan.modules.ip.dto.IpContentEchartsListDto;
import com.saas.titan.modules.ip.entity.IpContentEntity;
import com.saas.titan.modules.ip.vo.IpContentVo;

import java.util.List;


/**
 *
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-03 11:02:07
 */
public interface IpContentService extends IService<IpContentEntity> {
    /**
     * 分页查询请求信息
     * @param vo 接参对象
     * @return page对象
     */
    Page<IpContentEntity> page(IpContentVo vo);

    /**
     * 查询信息
     * @param hostName 主机名
     * @return IpContentEchartsCountDto dto
     */
    List<IpContentEchartsListDto> getInfo(String hostName);

    /**
     * @param hostName 主机名
     * @return dto
     */
    IpContentEchartsCountDto getEcharts(String hostName);

}

