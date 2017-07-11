package com.sinzoro.test.vo;

import com.sinzoro.common.common.Authority;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserVO {
    
    private String id;
    private String password;
    private String email;
    private String name;
    
    private Authority authority;
}
