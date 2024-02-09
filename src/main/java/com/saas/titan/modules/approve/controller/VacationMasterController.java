package com.saas.titan.modules.approve.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.approve.dto.VacationMasterAllPageDto;
import com.saas.titan.modules.approve.dto.VacationMasterPageDto;
import com.saas.titan.modules.approve.service.VacationMasterService;
import com.saas.titan.modules.approve.vo.VacationMasterInsertVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




/**
 * 请假申请主表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-09 14:04:27
 */
@RestController
@RequestMapping("/vacation-master")
public class VacationMasterController {

    @Autowired
    private VacationMasterService vacationMasterService;

    /**
     * 插入请假信息
     * @param vo 接参对象
     * @return 统一返回值
     */
    @PostMapping("/insert")
    public ResultInfo<String> insert(@RequestBody VacationMasterInsertVo vo) {
        vacationMasterService.insert(vo);
        return ResultInfo.build();
    }

    /**
     * 分页查询请假信息
     * @param vo 接参对象
     * @return 统一返回值
     */
    @PostMapping("/page")
    public ResultInfo<Page<VacationMasterPageDto>> getPage(@RequestBody BasicsVo vo) {
        return ResultInfo.build(vacationMasterService.getPage(vo));
    }

    /**
     * 请假审批列表
     * @param vo 接参对象
     * @return 统一返回值
     */
    @PostMapping("/allPage")
    public ResultInfo<Page<VacationMasterAllPageDto>> getAllPage(@RequestBody BasicsVo vo) {
        return ResultInfo.build(vacationMasterService.getAllPage(vo));
    }

}
