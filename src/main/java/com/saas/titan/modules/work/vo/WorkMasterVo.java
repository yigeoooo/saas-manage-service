package com.saas.titan.modules.work.vo;

import com.saas.titan.common.pojo.vo.BasicsVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yigeoooo
 * @since date 2024/2/10
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WorkMasterVo extends BasicsVo {

    /**
     * 角色id
     */
    private String userId;

}
