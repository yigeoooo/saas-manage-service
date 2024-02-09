package com.saas.titan.modules.approve.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

/**
 * 请假申请主表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-09 14:04:27
 */
@Data
@TableName("vacation_master")
public class VacationMasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * sys_user主键
	 */
	private String userId;
	/**
	 * 请假类型（0:事假，1:婚假，2:丧假，3:病假，4:调休）
	 */
	private String types;
	/**
	 * 开始时间
	 */
	private LocalDate beginTime;
	/**
	 * 结束时间
	 */
	private LocalDate endTime;
	/**
	 * 共计天数
	 */
	private Long days;
	/**
	 * 请假理由
	 */
	private String reason;
	/**
	 * 插入时间
	 */
	private LocalDate insertTime;
	/**
	 * 状态（0:未受理，1:通过，2：驳回）
	 */
	private String status;

}
