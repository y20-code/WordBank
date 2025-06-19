package com.yls.word_springboot.Util;

import com.yls.word_springboot.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserContext {
    // ThreadLocal 存储当前线程的 UserDTO
    private static final ThreadLocal<UserDTO> CURRENT_USER = new ThreadLocal<>();

    // 设置当前用户
    public static void setUser(UserDTO user) {
        CURRENT_USER.set(user);
    }

    // 获取当前用户
    public static UserDTO getUser() {
        return CURRENT_USER.get();
    }

    // 清除 ThreadLocal（防止内存泄漏）
    public static void clear() {
        CURRENT_USER.remove();
    }
}
