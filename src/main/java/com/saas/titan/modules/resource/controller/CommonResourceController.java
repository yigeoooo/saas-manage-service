package com.saas.titan.modules.resource.controller;


import com.saas.titan.modules.resource.service.CommonResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




/**
 * 上传资源主表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-05 10:18:48
 */
@RestController
@RequestMapping("/common-resource")
public class CommonResourceController {
    @Autowired
    private CommonResourceService commonResourceService;


}
