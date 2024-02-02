package com.saas.titan.modules.icon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * 
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-02 17:10:47
 */
@Data
@TableName("icon_master")
public class IconMasterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * icon主键
	 */
	@TableId
	private String iconId;
	/**
	 * icon图标名
	 */
	private String menuIcon;
	/**
	 * 图标状态
	 */
	private Boolean status;

}
