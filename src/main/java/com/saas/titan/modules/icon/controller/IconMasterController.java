package com.saas.titan.modules.icon.controller;



import com.saas.titan.modules.icon.service.IconMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





/**
 *
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-02 17:10:47
 */
@RestController
@RequestMapping("icon-master")
public class IconMasterController {
    @Autowired
    private IconMasterService iconMasterService;


}
