package com.saas.titan.modules.ip.dao;

import com.saas.titan.modules.ip.entity.IpMasterEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ip主档表
 * 
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-03 11:02:07
 */
@Repository
@Mapper
public interface IpMasterDao extends BaseMapper<IpMasterEntity> {
	
}
