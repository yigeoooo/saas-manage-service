package com.saas.titan.modules.icon.controller;



import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.icon.entity.IconMasterEntity;
import com.saas.titan.modules.icon.service.IconMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-02 17:10:47
 */
@RestController
@RequestMapping("/icon-master")
public class IconMasterController {
    @Autowired
    private IconMasterService iconMasterService;

    /**
     * 分页查询icon图标
     * @return 统一返回值
     */
    @GetMapping("/page")
    public ResultInfo<List<IconMasterEntity>> getPage() {
        return ResultInfo.build(iconMasterService.getList());
    }
}
