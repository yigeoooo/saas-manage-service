package com.saas.titan.modules.department.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.department.dto.DepartmentDto;
import com.saas.titan.modules.department.vo.DepartmentInsertVo;
import com.saas.titan.modules.department.vo.DepartmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.saas.titan.modules.department.service.DepartmentMasterService;




/**
 * 科室信息表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-01-28 11:15:31
 */
@RestController
@RequestMapping("/department-master")
public class DepartmentMasterController {

    @Autowired
    private DepartmentMasterService departmentMasterService;

    /**
     * 分页条件查询
     * @param departmentVo 接参vo
     * @return ResultInfo 统一返回值
     */
    @PostMapping("/page")
    public ResultInfo<Page<DepartmentDto>> getPage(@RequestBody DepartmentVo departmentVo) {
        return ResultInfo.build(departmentMasterService.page(departmentVo));
    }

    /**
     * 新建科室信息
     * @param params 接参对象
     * @return ResultInfo 统一返回值
     */
    @PostMapping("/insert")
    public ResultInfo<Object> insert(@RequestBody DepartmentInsertVo params) {
        try {
            departmentMasterService.insert(params);
            return ResultInfo.build(true);
        } catch (Exception e) {
            return ResultInfo.build(e);
        }
    }

    /**
     * 根据id逻辑删除科室
     * @param id 主键
     * @return ResultInfo 统一返回值
     */
    @DeleteMapping("/{id}")
    public ResultInfo<Object> delete(@PathVariable("id") String id) {
        try {
            departmentMasterService.removeById(id);
            return ResultInfo.build(true);
        } catch (Exception e) {
            return ResultInfo.build(e);
        }
    }

}
