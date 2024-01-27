

package com.saas.titan.modules.sys.service;


/**
 * 用戶Token
 *
 * @author yaomingjian
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.modules.sys.dto.TokenDto;
import com.saas.titan.modules.sys.entity.SysUserTokenEntity;


public interface SysUserTokenService extends IService<SysUserTokenEntity> {

    /**
     * 生成token
     *
     * @param userId 用戶ID
     */
    TokenDto createToken(String userId);

    /**
     * 生成臨時token
     *
     * @param userId 用戶ID
     */
    TokenDto createTempToken(String userId);

    /**
     * 退出，修改token值
     *
     * @param userId 用戶ID
     */
    void logout(String userId);

}
