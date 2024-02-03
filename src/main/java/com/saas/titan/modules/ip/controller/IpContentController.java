package com.saas.titan.modules.ip.controller;

import com.saas.titan.modules.ip.service.IpContentService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
