package com.saas.titan.modules.sys.controller;

import com.saas.titan.common.exception.BusinessException;
import com.saas.titan.common.utils.MessageCode;
import com.saas.titan.common.utils.ResultInfo;
import com.saas.titan.common.utils.SaltUtils;
import com.saas.titan.modules.sys.dto.TokenDto;
import com.saas.titan.modules.sys.entity.SysUserEntity;
import com.saas.titan.modules.sys.service.SysCaptchaService;
import com.saas.titan.modules.sys.service.SysUserService;
import com.saas.titan.modules.sys.service.SysUserTokenService;
import com.saas.titan.modules.sys.vo.SysLoginVo;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

/**
 * @author yigeoooo
 * @since date 2024/1/27
 */
@RestController
@RequestMapping("/sys")
public class SysLoginController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysCaptchaService sysCaptchaService;

    @Autowired
    private SysUserTokenService sysUserTokenService;

    /**
     * 驗證碼
     */
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //獲取圖片驗證碼
        BufferedImage image = sysCaptchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }


    /**
     * 系统用户登录
     * @param form 接参对象
     * @return ResultInfo
     */
    @PostMapping("/login")
    public ResultInfo<TokenDto> login(@RequestBody SysLoginVo form) {
//        校验验证码
        boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if (!captcha) {
            throw new BusinessException(MessageCode.LoginMessage.VERIFICATION_CODE_PARAM_ERROR);
        }
        // 用戶信息
        SysUserEntity user = sysUserService.queryByLoginId(form.getLoginId());
        // 帳號不存在、密碼錯誤
        if (user == null || !user.getPassword().equals(SaltUtils.getUserPasswordBySalt(form.getPassword(), user.getSalt()))) {
            throw new BusinessException(MessageCode.LoginMessage.ACCOUNT_PASSWORD_PARAM_ERROR);
        }
        user.setUpdateUserId(form.getLoginId());
        user.setUpdateTime(new Date());
        sysUserService.updateById(user);
        //生成token，并保存到數據庫
        TokenDto dto = sysUserTokenService.createTempToken(user.getUserId());
        dto.setUserName(user.getUserName());
        if (user.getInitialPassword().equals(SaltUtils.getUserPasswordBySalt(form.getPassword(), user.getSalt()))){
            dto.setEditPassword(Boolean.TRUE);
        }
        return ResultInfo.build(dto);
    }

    /**
     * 发送郵件验证码
     * @param email 邮箱
     * @return ResultInfo
     */
    @GetMapping("/{email}/{captcha}/{uuid}")
    public ResultInfo<String> sendEmail(@PathVariable("email") String email,
                                        @PathVariable("captcha") String captcha,
                                        @PathVariable("uuid") String uuid) {
        sysUserService.sendEmail(email, captcha, uuid);
        return ResultInfo.build();
    }

    /**
     * 邮箱验证登录
     * @param email 邮箱
     * @return ResultInfo
     */
    @GetMapping("/login/{email}/{code}")
    public ResultInfo<TokenDto> loginByEmail(@PathVariable("email") String email,
                                             @PathVariable("code") String code) {
        return ResultInfo.build(sysUserService.loginByEmail(email, code));
    }
}
