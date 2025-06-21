package com.yls.word_springboot.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Data
@Validated
public class User {
    @NotNull
    private Long userId;
    @Pattern(regexp = "^\\S{5,16}$", message = "用户名需要匹配正则表达式 '^\\S{5,16}$'")
    private String username;
    @Email
    private String email;
    @JsonIgnore
    @Pattern(regexp = "^\\S{5,16}$", message = "密码需要匹配正则表达式 '^\\S{5,16}$'")
    private String password;
    private String role;
    private boolean isActive;
    private String avatar;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
