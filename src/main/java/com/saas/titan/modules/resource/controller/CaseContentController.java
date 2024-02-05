package com.saas.titan.modules.resource.controller;


import com.saas.titan.modules.resource.service.CaseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





/**
 * 案件内容表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-05 10:18:49
 */
@RestController
@RequestMapping("/case-content")
public class CaseContentController {

    @Autowired
    private CaseContentService caseContentService;



}
