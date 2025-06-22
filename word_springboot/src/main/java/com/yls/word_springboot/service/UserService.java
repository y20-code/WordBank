package com.yls.word_springboot.service;

import com.yls.word_springboot.dto.UserDTO;
import com.yls.word_springboot.pojo.Result;
import com.yls.word_springboot.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDTO findByUserName(String username);

    void addUser(String username, String password, String email, String role);

    void updateUser(User user);

    void updatePwd(String newPwd);

    List<User> findAllUser();

    void updateActive(Long userId, Boolean active);
}
