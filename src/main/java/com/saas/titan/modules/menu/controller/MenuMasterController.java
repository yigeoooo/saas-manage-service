package com.saas.titan.modules.menu.controller;


import com.saas.titan.modules.menu.service.MenuMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




/**
 * 菜单主档表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 15:59:09
 */
@RestController
@RequestMapping("menu-master")
public class MenuMasterController {

    @Autowired
    private MenuMasterService menuMasterService;


}
