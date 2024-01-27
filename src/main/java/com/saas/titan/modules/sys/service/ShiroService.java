

package com.saas.titan.modules.sys.service;



import com.saas.titan.modules.sys.entity.SysUserEntity;
import com.saas.titan.modules.sys.entity.SysUserTokenEntity;


/**
 * shiro相關接口
 *
 * @author Mark
 */
public interface ShiroService {


    SysUserTokenEntity queryByToken(String token, String type);

    SysUserEntity queryUser(String userId);

}
