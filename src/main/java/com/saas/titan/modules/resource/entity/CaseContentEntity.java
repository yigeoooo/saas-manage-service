package com.saas.titan.modules.resource.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 案件内容表
 * 
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-05 10:18:49
 */
@Data
@TableName("case_content")
public class CaseContentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private String id;
	/**
	 * resource_id
	 */
	private String resourceId;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 内容
	 */
	private String content;

}
