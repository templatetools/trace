package org.food.safety.trace.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * Created by tom on 2017/10/9.
 */
@Getter
@Setter
public class Token {
    public static final String ADMIN = "admin";
    /**
     * 组织id
     */
    private String organizationId;

    /**
     * 用户id
     */
    private String userId;

    public Token(String token) {
        if (null != token && token.indexOf(File.separator) > -1){
            String[] tokens = token.split(File.separator);
            organizationId = tokens[0];
            userId = tokens[1];
        }else{
            throw new RuntimeException(token + "token parse error!");
        }
    }
}
