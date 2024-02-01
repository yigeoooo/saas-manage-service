package com.saas.titan.modules.menu.controller;



import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.menu.service.MenuContentService;
import com.saas.titan.modules.menu.vo.MenuContentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 菜单权限表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 16:19:51
 */
@RestController
@RequestMapping("/menu-content")
public class MenuContentController {

    @Autowired
    private MenuContentService menuContentService;

    /**
     * 获取menuList
     * @return ResultInfo 统一返回值
     */
    @GetMapping("/list")
    public ResultInfo<List<Tree<String>>> getMenuList() {
        return ResultInfo.build(menuContentService.getTreeList());
    }

    /**
     * 赋权
     * @param vo 接参对象
     * @return ResultInfo 统一返回值
     */
    @PostMapping("/permission")
    public ResultInfo<String> givePermission(@RequestBody MenuContentVo vo) {
        menuContentService.givePermission(vo);
        return ResultInfo.build();
    }
}
