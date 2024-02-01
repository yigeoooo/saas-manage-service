package com.saas.titan.modules.menu.controller;


import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.menu.dto.MenuMasterDto;
import com.saas.titan.modules.menu.service.MenuMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 菜单主档表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 15:59:09
 */
@RestController
@RequestMapping("/menu-master")
public class MenuMasterController {

    @Autowired
    private MenuMasterService menuMasterService;

    /**
     * 分页查询菜单
     * @param vo vo对象
     * @return 统一返回值对象
     */
    @PostMapping("/page")
    public ResultInfo<Page<MenuMasterDto>> getMenuList(@RequestBody BasicsVo vo) {
        return ResultInfo.build(menuMasterService.getMenuList(vo));
    }

    /**
     * 查询所有菜单列表
     * @return ResultInfo
     */
    @GetMapping("/list")
    public ResultInfo<List<Tree<String>>> getAll() {
        return ResultInfo.build(menuMasterService.getTreeList());
    }


}
