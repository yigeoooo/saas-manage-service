package com.saas.titan.modules.ip.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

/**
 *
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-03 11:02:07
 */
@Data
@TableName("ip_content")
public class IpContentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主机名或ip地址
	 */
	@TableId
	private String hostName;
	/**
	 * 请求路径
	 */
	private String requestUrl;
	/**
	 * 请求方式
	 */
	private String requestMethod;
	/**
	 * 请求端口号
	 */
	private String requestPort;
	/**
	 * 发生时间
	 */
	private LocalDate insertTime;

}
