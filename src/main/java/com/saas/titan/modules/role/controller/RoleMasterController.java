package com.saas.titan.modules.role.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.role.dto.RoleMasterDto;
import com.saas.titan.modules.role.service.RoleMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}
