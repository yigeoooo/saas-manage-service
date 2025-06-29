

package com.saas.titan.modules.sys.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.saas.titan.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author Mark
 */
@Component
@Mapper
//数据源1
@DS("datasource1")
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    /**
     * 根据用户登陆ID，查询系统用户
     */
    SysUserEntity queryByLoginId(String loginId);

    /**
     * 根据用户登陆ID，查询数据库内是否有相同的登陆账号
     */

    /**
     * 根据用户登陆ID，查询系统用户
     */
    List<SysUserEntity> queryUserList(Map<String, Object> params);

    /**
     * 根据主鍵用户ID，查詢系統用戶名稱（無刪除標志）
     */
    SysUserEntity queryByUserId(String userId);

    /**
     * 根据用户登陆ID，查询数据库内是否有相同的登陆账号
     */
    Integer queryByLoginIdNum(String loginId, String userId);
}
