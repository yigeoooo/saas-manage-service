package com.saas.titan.modules.ip.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yigeoooo
 * @since date 2024/2/3
 */
@Data
public class EchartsDto {

    private String name;

    private String type;

    private String stack;

    private List<Integer> data = new ArrayList<>();

}
