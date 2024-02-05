package com.saas.titan.modules.resource.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.saas.titan.modules.resource.entity.CommonResourceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 上传资源主表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-05 10:18:48
 */
@Repository
@Mapper
@DS("datasource2")
public interface CommonResourceDao extends BaseMapper<CommonResourceEntity> {

}
