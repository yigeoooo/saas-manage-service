package com.saas.titan.modules.ip.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.ip.entity.IpContentEntity;
import com.saas.titan.modules.ip.service.IpContentService;
import com.saas.titan.modules.ip.vo.IpContentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




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

}
