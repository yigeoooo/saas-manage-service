package com.saas.titan.modules.resource.vo;

import com.saas.titan.common.pojo.vo.BasicsVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yigeoooo
 * @since date 2024/2/5
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CaseContentVo extends BasicsVo {

    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;

}
