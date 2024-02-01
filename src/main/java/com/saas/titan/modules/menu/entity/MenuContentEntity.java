package com.saas.titan.modules.menu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 菜单权限表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-01 16:19:51
 */
@Data
@TableName("menu_content")
public class MenuContentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private String id;
	/**
	 * 用户id
	 */
	private String roleId;
	/**
	 * 菜单id
	 */
	private String menuId;
	/**
	 * 父级菜单id(0则无父级菜单)
	 */
	private String parentMenuId;
	/**
	 * 菜单名
	 */
	private String menuName;
	/**
	 * 菜单路径
	 */
	private String menuPath;
	/**
	 * 菜单图标
	 */
	private String menuIcon;

}
