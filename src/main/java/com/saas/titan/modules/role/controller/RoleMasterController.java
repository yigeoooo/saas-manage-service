package com.saas.titan.modules.role.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.role.dto.RoleMasterDto;
import com.saas.titan.modules.role.dto.RoleMasterListDto;
import com.saas.titan.modules.role.service.RoleMasterService;
import com.saas.titan.modules.role.vo.RoleMasterAddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 角色主档
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 16:43:52
 */
@RestController
@RequestMapping("/role-master")
public class RoleMasterController {

    @Autowired
    private RoleMasterService roleMasterService;

    /**
     * 获取角色列表
     * @param vo 接参对象
     * @return 统一返回值
     */
    @PostMapping("/page")
    public ResultInfo<Page<RoleMasterDto>> getRoleList(@RequestBody BasicsVo vo) {
        return ResultInfo.build(roleMasterService.getRoleList(vo));
    }

    /**
     * 修改角色状态
     * @param roleId 角色id
     * @return 统一返回值
     */
    @GetMapping("/status/{roleId}")
    public ResultInfo<String> changeStatus(@PathVariable("roleId") String roleId) {
        roleMasterService.changeStatus(roleId);
        return ResultInfo.build();
    }

    /**
     * 新增角色
     * @param vo 接参对象
     * @return 统一返回值
     */
    @PostMapping("/insert")
    public ResultInfo<String> insert(@RequestBody RoleMasterAddVo vo) {
        roleMasterService.insertRole(vo);
        return ResultInfo.build();
    }

    /**
     * 刪除角色
     * @param id id
     * @return 统一返回值
     */
    @DeleteMapping("/{id}")
    public ResultInfo<String> delete(@PathVariable("id") String id) {
        roleMasterService.deleted(id);
        return ResultInfo.build();
    }

    /**
     * 角色下拉框資源
     * @return 统一返回值
     */
    @GetMapping("/list")
    public ResultInfo<List<RoleMasterListDto>> getList() {
        return ResultInfo.build(roleMasterService.getList());
    }

}
