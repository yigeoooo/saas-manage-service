package com.saas.titan.modules.role.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

/**
 * 角色主档
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 16:43:52
 */
@Data
@TableName("role_master")
public class RoleMasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private String roleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 插入人id
	 */
	private String insertUserId;
	/**
	 * 插入时间
	 */
	private LocalDate insertTime;
	/**
	 * 最近更新人id
	 */
	private String updateUserId;
	/**
	 * 最近更新时间
	 */
	private LocalDate updateTime;
	/**
	 * 排序标识符
	 */
	private Long sort;
	/**
	 * 状态 1：开启，0关闭
	 */
	private boolean status;
	/**
	 * 逻辑删除标识符（0：正常，1：删除）
	 */
	@TableLogic
	private String isDeleted;

}
