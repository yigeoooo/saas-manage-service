package com.saas.titan.modules.menu.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yigeoooo
 * @since date 2024/2/1
 */
@Data
public class MenuContentVo {

    private String roleId;

    private List<String> data = new ArrayList<>();
}
