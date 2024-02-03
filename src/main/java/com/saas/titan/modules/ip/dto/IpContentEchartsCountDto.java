package com.saas.titan.modules.ip.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yigeoooo
 * @since date 2024/2/3
 */
@Data
public class IpContentEchartsCountDto {

    private List<LocalDate> dayList = new ArrayList<>();

    private List<EchartsDto> list = new ArrayList<>();

}
