package com.saas.titan.modules.ip.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

/**
 * ip主档表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-03 11:02:07
 */
@Data
@TableName("ip_master")
public class IpMasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * 主机名或ip地址
	 */
	private String hostName;
	/**
	 * 插入时间
	 */
	private LocalDate insertTime;
	/**
	 * 插入人
	 */
	private String insertUserId;
	/**
	 * 封禁状态（1：正常，0：封禁）
	 */
	private Boolean banStatus;

}
