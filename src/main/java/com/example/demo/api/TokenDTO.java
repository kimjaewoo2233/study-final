package com.example.demo.api;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TokenDTO {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private String user_key;

}
