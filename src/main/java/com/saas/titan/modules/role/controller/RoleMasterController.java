package com.saas.titan.modules.role.controller;

import com.saas.titan.modules.role.service.RoleMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





/**
 * 角色主档
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 16:43:52
 */
@RestController
@RequestMapping("role-master")
public class RoleMasterController {

    @Autowired
    private RoleMasterService roleMasterService;



}
