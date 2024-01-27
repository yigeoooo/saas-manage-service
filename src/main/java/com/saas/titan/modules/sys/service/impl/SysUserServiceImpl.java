

package com.saas.titan.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.exception.BusinessException;
import com.saas.titan.common.utils.MessageCode;
import com.saas.titan.common.utils.SaltUtils;
import com.saas.titan.common.utils.StringUtils;
import com.saas.titan.modules.sys.dao.SysUserDao;
import com.saas.titan.modules.sys.entity.SysUserEntity;
import com.saas.titan.modules.sys.service.SysUserService;
import com.saas.titan.modules.sys.verify.GoogleAuthenticator;
import com.saas.titan.modules.sys.vo.SysUserSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.saas.titan.common.utils.ShiroUtils.getLoginId;


/**
 * 系統用戶
 *
 * @author Mark
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {


    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 根據用戶登陸ID，查詢系統用戶
     * @param loginId 傳入參數
     * @return 返回對象
     */
    @Override
    public SysUserEntity queryByLoginId(String loginId) {
        return baseMapper.queryByLoginId(loginId);
    }

    @Override
    public boolean saveUser(SysUserSaveVo userForm) {
        // 檢查登錄帳號是否重複
        checkLoginId(userForm);
        SysUserEntity user = new SysUserEntity();
        user.setLoginId(userForm.getLoginId());
        user.setUserName(userForm.getUserName());
        user.setTelephone(userForm.getTelephone());
        user.setEmail(userForm.getEmail());
        Date sysDate = new Date();
        user.setSalt(SaltUtils.getSaltKey());
        // 根據加密鹽生成用戶最終密碼
        user.setPassword((SaltUtils.getUserPasswordBySalt(userForm.getPassword(),user.getSalt())));
        user.setInsertUserId(getLoginId());
        user.setUpdateUserId(getLoginId());
        user.setInsertTime(sysDate);
        user.setUpdateTime(sysDate);
        user.setInitialPassword(userForm.getInitialPassword());
        user.setUserId(IdWorker.getIdStr(user));
        //設置GoogleKey
        user.setGoogleKey(GoogleAuthenticator.generateSecretKey());

        return baseMapper.insert(user)>0;
    }

    /**
     * 检查登录账号是否重复
     */
    private void checkLoginId(SysUserSaveVo user) {
        if (user.getLoginId() == null || user.getLoginId().isEmpty()) {
            return;
        }

        Integer loginIdNum = baseMapper.queryByLoginIdNum(user.getLoginId(),user.getUserId());

        //判斷是否有重複登錄用戶名
        if (loginIdNum != null && loginIdNum >0) {
            throw new BusinessException(MessageCode.LoginMessage.LOGIN_ACCOUNT_DUPLICATE);
        }
    }


}
