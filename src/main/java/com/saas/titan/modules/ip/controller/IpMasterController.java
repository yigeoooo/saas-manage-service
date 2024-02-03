package com.saas.titan.modules.ip.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.ip.entity.IpMasterEntity;
import com.saas.titan.modules.ip.service.IpMasterService;
import com.saas.titan.modules.ip.vo.IpMasterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * ip主档表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-03 11:02:07
 */
@RestController
@RequestMapping("/ip-master")
public class IpMasterController {
    @Autowired
    private IpMasterService ipMasterService;

    /**
     * 查询访问主机列表
     * @param vo 接参对象
     * @return 统一返回值
     */
    @PostMapping("/page")
    public ResultInfo<Page<IpMasterEntity>> getPage(@RequestBody IpMasterVo vo) {
        return ResultInfo.build(ipMasterService.getIpMasterList(vo));
    }

    /**
     * 修改封禁状态
     * @param id 主键
     * @return 统一返回值
     */
    @GetMapping("/{id}")
    public ResultInfo<String> changStatus(@PathVariable("id") String id) {
        ipMasterService.changeStatus(id);
        return ResultInfo.build();
    }
}
