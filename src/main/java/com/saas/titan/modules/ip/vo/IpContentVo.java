package com.saas.titan.modules.ip.vo;

import com.saas.titan.common.pojo.vo.BasicsVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yigeoooo
 * @since date 2024/2/3
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class IpContentVo extends BasicsVo {
    /**
     * 主机名
     */
    private String hostName;
    /**
     * 请求方法
     */
    private String requestMethod;
    /**
     * 请求端口号
     */
    private String requestPort;
    /**
     * 时间段
     */
    private List<String> time = new ArrayList<>();

}
