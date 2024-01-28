package com.saas.titan.modules.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saas.titan.modules.department.service.DepartmentMasterService;




/**
 * 科室信息表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-01-28 11:15:31
 */
@RestController
@RequestMapping("department-master")
public class DepartmentMasterController {

    @Autowired
    private DepartmentMasterService departmentMasterService;


}
