

package com.saas.titan.modules.sys.service.impl;

import com.saas.titan.modules.sys.dao.SysUserDao;
import com.saas.titan.modules.sys.dao.SysUserTokenDao;
import com.saas.titan.modules.sys.entity.SysUserEntity;
import com.saas.titan.modules.sys.entity.SysUserTokenEntity;
import com.saas.titan.modules.sys.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserTokenDao sysUserTokenDao;


    @Override
    public SysUserTokenEntity queryByToken(String token, String type) {
        return sysUserTokenDao.queryByToken(token, type);
    }

    @Override
    public SysUserEntity queryUser(String userId) {
        return sysUserDao.selectById(userId);
    }


}
