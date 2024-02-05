package com.saas.titan.modules.resource.dto;

import lombok.Data;

/**
 * @author yigeoooo
 * @since date 2024/2/5
 */
@Data
public class CaseContentDto {

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
    /**
     * 状态
     */
    private boolean status;

}
