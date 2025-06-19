package com.yls.word_springboot.service.impl;

import com.yls.word_springboot.Util.UserContext;
import com.yls.word_springboot.dto.UserDTO;
import com.yls.word_springboot.mapper.UserMapper;
import com.yls.word_springboot.pojo.Result;
import com.yls.word_springboot.pojo.User;
import com.yls.word_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDTO findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void addUser(String username, String password, String email, String role) {
        //密码加密
        String BCpssword = passwordEncoder.encode(password);
        userMapper.addUser(username, BCpssword, email, role);
    }

    @Override
    public void updateUser(User user) {
        user.setUpdatedAt(LocalDateTime.now());
        userMapper.updateUser(user);
    }

    @Override
    public void updatePwd(String newPwd) {
        String username = UserContext.getUser().getUsername();
        String encode = passwordEncoder.encode(newPwd);

        userMapper.updatePwd(encode,username);
    }

    @Override
    public List<User> findAllUser() {
        return  userMapper.getAllUser();
    }


}
