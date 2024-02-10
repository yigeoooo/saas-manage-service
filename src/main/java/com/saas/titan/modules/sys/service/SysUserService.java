

package com.saas.titan.modules.sys.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.modules.sys.dto.SysUserDto;
import com.saas.titan.modules.sys.dto.TokenDto;
import com.saas.titan.modules.sys.entity.SysUserEntity;
import com.saas.titan.modules.sys.vo.SysUserSaveVo;
import com.saas.titan.modules.sys.vo.SysUserVo;


/**
 * 系統用戶
 *
 * @author Mark
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 根據用戶登陸ID，查詢系統用戶
     */
    SysUserEntity queryByLoginId(String loginId);

    /**
     * 保存用戶
     */
    boolean saveUser(SysUserSaveVo user);

    /**
     * 发送email验证码
     * @param email
     */
    void sendEmail(String email, String captcha, String uuid);

    /**
     * 邮箱验证登录
     * @param email 邮箱
     * @return TokenDto
     */
    TokenDto loginByEmail(String email, String code);

    /**
     * 分页查询系统用户
     * @return Page
     */
    Page<SysUserDto> getPage(SysUserVo vo);
}
