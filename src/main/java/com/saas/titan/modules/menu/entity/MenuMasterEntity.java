package com.saas.titan.modules.menu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 菜单主档表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 15:59:09
 */
@Data
@TableName("menu_master")
public class MenuMasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private String menuId;
	/**
	 * 父级菜单id(0则无父级菜单)
	 */
	private String parentMenuId;
	/**
	 * 菜单路径
	 */
	private String menuPath;
	/**
	 * 菜单名
	 */
	private String menuName;
	/**
	 * 菜单图标
	 */
	private String menuIcon;
	/**
	 * 插入时间
	 */
	private LocalDateTime insertTime;
	/**
	 * 插入人id
	 */
	private String insertUserId;
	/**
	 * 最近更新时间
	 */
	private LocalDateTime updateTime;
	/**
	 * 最近更信人id
	 */
	private String updateUserId;
	/**
	 * 排序标识符
	 */
	private Long sort;
	/**
	 * 逻辑删除标识符(1删除，正常)
	 */
	@TableLogic
	private String isDeleted;

}
