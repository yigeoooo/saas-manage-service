package com.saas.titan.modules.resource.vo;

import lombok.Data;

/**
 * @author yigeoooo
 * @since date 2024/2/5
 */
@Data
public class CaseContentAddVo {

    /**
     * 資源ID
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
