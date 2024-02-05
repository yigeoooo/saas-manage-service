package com.saas.titan.modules.resource.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.resource.dto.CaseContentDto;
import com.saas.titan.modules.resource.service.CaseContentService;
import com.saas.titan.modules.resource.vo.CaseContentAddVo;
import com.saas.titan.modules.resource.vo.CaseContentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 新增case案例
     * @param vo 接参对象
     * @return 统一返回值
     */
    @PostMapping("/insert")
    public ResultInfo<String> insert(@RequestBody CaseContentAddVo vo) {
        caseContentService.insert(vo);
        return ResultInfo.build();
    }

    /**
     * 分页条件查询
     * @param vo 接参对象
     * @return 统一返回值
     */
    @PostMapping("/page")
    public ResultInfo<Page<CaseContentDto>> page(@RequestBody CaseContentVo vo) {
        return ResultInfo.build(caseContentService.page(vo));
    }

}
