package com.saas.titan.modules.resource.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

/**
 * 上传资源主表
 *
 * @author yigeoooo
 * @email 632084210@qq.com
 * @date 2024-02-05 10:18:48
 */
@Data
@TableName("common_resource")
public class CommonResourceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 資源ID
	 */
	@TableId
	private String resourceId;
	/**
	 * 文件存儲路徑
	 */
	private String filePath;
	/**
	 * 文件名稱
	 */
	private String fileName;
	/**
	 * 文件後綴
	 */
	private String fileSuffix;
	/**
	 * 文件大小(kb)
	 */
	private String fileSize;
	/**
	 * 逻辑删除标识符
	 */
	@TableLogic
	private String isDeleted;
	/**
	 * 更新者
	 */
	private String updateUserId;
	/**
	 * 更新時間
	 */
	private LocalDate updateTime;
	/**
	 * 創建者
	 */
	private String insertUserId;
	/**
	 * 創建時間
	 */
	private LocalDate insertTime;
	/**
	 * 状态
	 */
	private Boolean status;

}
