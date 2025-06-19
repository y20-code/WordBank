package com.yls.word_springboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private String role;
} 