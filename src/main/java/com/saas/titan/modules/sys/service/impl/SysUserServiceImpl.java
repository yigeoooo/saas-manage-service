

package com.saas.titan.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.saas.titan.common.constant.Constant;
import com.saas.titan.common.exception.BusinessException;
import com.saas.titan.common.pojo.entity.ToEmail;
import com.saas.titan.common.utils.*;
import com.saas.titan.modules.sys.dao.SysUserDao;
import com.saas.titan.modules.sys.dto.TokenDto;
import com.saas.titan.modules.sys.entity.SysUserEntity;
import com.saas.titan.modules.sys.service.SysCaptchaService;
import com.saas.titan.modules.sys.service.SysUserService;
import com.saas.titan.modules.sys.service.SysUserTokenService;
import com.saas.titan.modules.sys.verify.GoogleAuthenticator;
import com.saas.titan.modules.sys.vo.SysUserSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private MailUtils mailUtils;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private SysUserTokenService sysUserTokenService;

    @Autowired
    private SysCaptchaService sysCaptchaService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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

    @Override
    public void sendEmail(String email, String captcha, String uuid) {
        //email是否存在
        checkEmail(email);
        //check图像验证码
        boolean bo = sysCaptchaService.validate(uuid, captcha);
        if (!bo) {
            throw new BusinessException(MessageCode.LoginMessage.VERIFICATION_CODE_PARAM_ERROR);
        }
        //生成随机验证码
        String code = StringUtils.getUUID().substring(Constant.ZERO, Constant.SIX);
        ToEmail toEmail = new ToEmail();
        String[] toPerson = {email};
        toEmail.setTos(toPerson);
        String title = "TITAN后台管理系统";
        String content = "本次您的登录验证码为" + code;
        toEmail.setSubject(title);
        toEmail.setContent(content);
        //存储验证码到redis,5分钟后过期
        redisUtils.set(email, code, Constant.FIVE);
        mailUtils.commonEmail(toEmail);
    }

    @Override
    public TokenDto loginByEmail(String email, String code) {
        //檢驗郵箱是否存在
        SysUserEntity entity = checkEmail(email);
        String redisCode = redisUtils.get(email);
        //检验验证码是否正确
        if (!code.equals(redisCode)) {
            throw new BusinessException("邮箱验证码错误！");
        }
        //生成token令牌
        TokenDto dto = sysUserTokenService.createTempToken(entity.getUserId());
        dto.setUserName(entity.getUserName());
        return dto;
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

    /**
     * 檢驗郵箱是否存在
     * @param email 邮箱
     */
    public SysUserEntity checkEmail(String email) {
        QueryWrapper<SysUserEntity> query = new QueryWrapper<>();
        query.eq("email", email);
        SysUserEntity sysUserEntity = sysUserDao.selectOne(query);
        if (sysUserEntity == null) {
            throw new BusinessException("该邮箱不存在！");
        }
        return sysUserEntity;
    }
}
