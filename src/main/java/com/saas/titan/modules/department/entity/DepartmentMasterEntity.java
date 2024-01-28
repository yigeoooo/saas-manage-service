package com.saas.titan.modules.department.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;

import com.saas.titan.common.utils.ShiroUtils;
import com.saas.titan.modules.department.vo.DepartmentInsertVo;
import lombok.Builder;
import lombok.Data;

/**
 * 科室信息表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-01-28 11:15:31
 */
@Data
@TableName("department_master")
@Builder
public class DepartmentMasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主鍵id
	 */
	@TableId
	private String id;
	/**
	 * 科室名
	 */
	private String departmentName;
	/**
	 * 科室編碼
	 */
	private String departmentCode;
	/**
	 * 主管醫生
	 */
	private String manager;
	/**
	 * 排序標識符
	 */
	private Long sort;
	/**
	 * 插入時間
	 */
	private LocalDate insertTime;
	/**
	 * 更新時間
	 */
	private LocalDate updateTime;
	/**
	 * 邏輯刪除標識符
	 */
	private String isDeleted;
	/**
	 * 插入人id
	 */
	private String insertUserId;
	/**
	 * 更新人id
	 */
	private String updateUserId;

	/**
	 * 构建对象
	 * @param vo 接参对象
	 * @param departmentCode 科室编码
	 * @return DepartmentMasterEntity 实体类对象
	 */
	public static DepartmentMasterEntity from(DepartmentInsertVo vo, String departmentCode) {
		return DepartmentMasterEntity
				.builder()
				.departmentName(vo.getDepartmentName())
				.departmentCode(departmentCode)
				.manager(vo.getManager())
				.updateTime(LocalDate.now())
				.insertUserId(ShiroUtils.getLoginId())
				.updateUserId(ShiroUtils.getLoginId())
				.build();
	}

}
