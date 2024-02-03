package com.saas.titan.modules.ip.vo;

import com.saas.titan.common.pojo.vo.BasicsVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yigeoooo
 * @since date 2024/2/3
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class IpMasterVo extends BasicsVo {

    /**
     * 主机名或ip地址
     */
    private String hostName;

    /**
     * 封禁状态（1：正常，0：封禁）
     */
    private Boolean banStatus;

}
