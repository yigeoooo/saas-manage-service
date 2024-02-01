package com.saas.titan.modules.menu.controller;



import com.saas.titan.modules.menu.service.MenuContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




/**
 * 菜单权限表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 16:19:51
 */
@RestController
@RequestMapping("menu-content")
public class MenuContentController {
    @Autowired
    private MenuContentService menuContentService;


}
