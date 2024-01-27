

package com.saas.titan.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.saas.titan.modules.sys.entity.SysUserEntity;
import com.saas.titan.modules.sys.vo.SysUserSaveVo;


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


}
