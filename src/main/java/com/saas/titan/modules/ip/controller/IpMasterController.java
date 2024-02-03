package com.saas.titan.modules.ip.controller;

import com.saas.titan.modules.ip.service.IpMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




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

}
