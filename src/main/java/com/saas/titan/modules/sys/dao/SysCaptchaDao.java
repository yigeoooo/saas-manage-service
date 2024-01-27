

package com.saas.titan.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.saas.titan.modules.sys.entity.SysCaptchaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 验证码
 *
 * @author Mark
 */
@Mapper
public interface SysCaptchaDao extends BaseMapper<SysCaptchaEntity> {

}
