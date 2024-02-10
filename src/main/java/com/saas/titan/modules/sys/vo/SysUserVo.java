package com.saas.titan.modules.sys.vo;

import com.saas.titan.common.pojo.vo.BasicsVo;
import lombok.Data;

/**
 * @author yigeoooo
 * @since date 2024/2/10
 */
@Data
public class SysUserVo extends BasicsVo {

    private String roleName;

    private String userName;

}
