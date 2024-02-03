package com.saas.titan.modules.ip.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.ip.dto.IpContentEchartsCountDto;
import com.saas.titan.modules.ip.dto.IpContentEchartsListDto;
import com.saas.titan.modules.ip.entity.IpContentEntity;
import com.saas.titan.modules.ip.service.IpContentService;
import com.saas.titan.modules.ip.vo.IpContentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *ip从表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-03 11:02:07
 */
@RestController
@RequestMapping("/ip-content")
public class IpContentController {
    @Autowired
    private IpContentService ipContentService;

    /**
     * 分页查询信息
     * @param vo 接参对象
     * @return 统一返回值
     */
    @PostMapping("/page")
    public ResultInfo<Page<IpContentEntity>> page(@RequestBody IpContentVo vo) {
        return ResultInfo.build(ipContentService.page(vo));
    }

    /**
     * 获取Echarts图信息
     * @param hostName 主机名
     * @return 统一返回值
     */
    @GetMapping("/countInfo/{hostName}")
    public ResultInfo<List<IpContentEchartsListDto>> getCount(@PathVariable("hostName") String hostName) {
        return ResultInfo.build(ipContentService.getInfo(hostName));
    }

    /**
     * 直方图数据
     * @param hostName 主机名
     * @return 统一返回值
     */
    @GetMapping("/{hostName}")
    public ResultInfo<IpContentEchartsCountDto> getInfo(@PathVariable("hostName") String hostName) {
        return ResultInfo.build(ipContentService.getEcharts(hostName));
    }

}
