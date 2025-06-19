package com.yls.word_springboot.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Data
@Validated
public class User {
    @NotNull
    private Long userId;

    private String username;
    @Email
    private String email;
    private String password;
    private String role;
    private boolean isActive;
    private String avatar;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
