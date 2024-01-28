package com.saas.titan.modules.sys.dto;


import lombok.Data;

@Data
public class TokenDto {

    private String token;

    private String expire;

    private String userName;

    private Boolean editPassword = Boolean.FALSE;
}
