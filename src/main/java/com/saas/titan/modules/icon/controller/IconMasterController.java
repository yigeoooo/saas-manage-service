package com.saas.titan.modules.icon.controller;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.saas.titan.common.pojo.vo.BasicsVo;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.modules.icon.entity.IconMasterEntity;
import com.saas.titan.modules.icon.service.IconMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





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
     * @param vo
     * @return 统一返回值
     */
    @PostMapping("/page")
    public ResultInfo<Page<IconMasterEntity>> getPage(@RequestBody BasicsVo vo) {
        return ResultInfo.build(iconMasterService.getList(vo));
    }
}
