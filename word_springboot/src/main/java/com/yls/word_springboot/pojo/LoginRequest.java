package com.yls.word_springboot.pojo;

import jakarta.validation.constraints.Pattern;

public class LoginRequest {
    @Pattern(regexp = "^\\S{5,16}$", message = "用户名需要匹配正则表达式 '^\\S{5,16}$'")
    private String username;

    @Pattern(regexp = "^\\S{5,16}$", message = "密码需要匹配正则表达式 '^\\S{5,16}$'")
    private String password;

    // getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}