package com.saas.titan.modules.work.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

/**
 * 员工打卡主档表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-10 11:42:30
 */
@Data
@TableName("work_master")
public class WorkMasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * 系统用户id
	 */
	private String userId;
	/**
	 * 打卡时间
	 */
	private LocalDate time;
	/**
	 * 工作内容
	 */
	private String work;

}
