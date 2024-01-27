package com.saas.titan.modules.sys.dto;


import lombok.Data;

@Data
public class TokenDto {

    private String token;

    private String expire;

    private Boolean editPassword = Boolean.FALSE;
}
