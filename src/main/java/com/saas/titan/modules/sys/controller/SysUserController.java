package com.saas.titan.modules.sys.controller;

import com.saas.titan.common.exception.BusinessException;
import com.saas.titan.common.utils.MessageCode;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.common.validator.ValidatorUtils;
import com.saas.titan.common.validator.group.AddGroup;
import com.saas.titan.modules.sys.service.SysUserService;
import com.saas.titan.modules.sys.vo.SysUserSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.saas.titan.common.utils.ShiroUtils.getLoginId;

/**
 * @author yigeoooo
 * @since date 2024/1/27
 */
@RestController
@RequestMapping("/system/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 用戶管理-保存用戶
     */
    @PostMapping("/save")
    public ResultInfo<String> save(@RequestBody SysUserSaveVo user) {
        ValidatorUtils.validateEntity(user, AddGroup.class);
        user.setInsertUserId(getLoginId());
        boolean result = sysUserService.saveUser(user);
        if (result) {
            return ResultInfo.build();
        } else {
            throw new BusinessException(MessageCode.CommonMessage.PARAM_ERROR);
        }

    }

}
