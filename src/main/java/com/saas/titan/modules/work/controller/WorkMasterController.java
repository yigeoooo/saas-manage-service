package com.saas.titan.modules.work.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.work.dto.WorkMasterDto;
import com.saas.titan.modules.work.service.WorkMasterService;
import com.saas.titan.modules.work.vo.WorkMasterInsertVo;
import com.saas.titan.modules.work.vo.WorkMasterVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.saas.titan.modules.work.entity.WorkMasterEntity;




/**
 * 员工打卡主档表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-10 11:42:30
 */
@RestController
@RequestMapping("/work-master")
public class WorkMasterController {

    @Autowired
    private WorkMasterService workMasterService;

    /**
     * 新增打卡信息
     * @param vo 接参对象
     * @return 统一返回值
     */
    @PostMapping("/inert")
    public ResultInfo<String> insert(@RequestBody WorkMasterInsertVo vo) {
        workMasterService.insert(vo);
        return ResultInfo.build();
    }

    /**
     * 分页查询登陆人人打卡信息
     * @param vo 接参对象
     * @return 统一返回值
     */
    @PostMapping("/page")
    public ResultInfo<Page<WorkMasterDto>> getList(@RequestBody BasicsVo vo) {
        return ResultInfo.build(workMasterService.getList(vo));
    }

    /**
     * 分页查询个人打卡信息
     * @param vo 接参对象
     * @return 统一返回值
     */
    @PostMapping("/list")
    public ResultInfo<Page<WorkMasterDto>> getAllList(@RequestBody WorkMasterVo vo) {
        return ResultInfo.build(workMasterService.getPage(vo));
    }

}
