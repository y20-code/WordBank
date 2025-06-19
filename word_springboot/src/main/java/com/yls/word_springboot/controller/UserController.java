package com.yls.word_springboot.controller;

import com.yls.word_springboot.Util.JwtUtil;
import com.yls.word_springboot.Util.UserContext;
import com.yls.word_springboot.dto.UserDTO;
import com.yls.word_springboot.pojo.Result;
import com.yls.word_springboot.pojo.User;
import com.yls.word_springboot.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;


    //注册用户
    @PostMapping("/users")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password, String email, String role){
        UserDTO u = userService.findByUserName(username);
        if(u==null){
            userService.addUser(username,password,email,role);
            return Result.success();
        }else {
            //占用
            return Result.error("用户名以被占用");
        }
    }


    //用户登录
    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password){

        UserDTO byUserName = userService.findByUserName(username);
        if(byUserName==null){
            return Result.error("没有该用户");
        }

        if (passwordEncoder.matches(password, byUserName.getPassword())){
            //获取令牌
            String token = jwtUtil.generateToken(username);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }

    //根据username查询用户
    @GetMapping("/user/userInfo")
    public Result findByUsername(/*@RequestHeader(name = "Authorization") String token*/){
        UserDTO username = UserContext.getUser();
        UserDTO userDTO = userService.findByUserName(username.getUsername());
        return Result.success(userDTO);
    }

    //获取所有用户
    @GetMapping("/user")
    public Result<List<User>> getUser(){
        List<User> allUser = userService.findAllUser();
        return Result.success(allUser);
    }

    //更新用户
    @PutMapping("/user")
    public Result updateUser(@RequestBody User user){
        userService.updateUser(user);
        return Result.success("更新成功·");
    }

    //修改密码
    @PatchMapping("updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params){
        //1.校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");


        if(!passwordEncoder.matches(oldPwd,UserContext.getUser().getPassword())){
            return Result.error("原密码错误");
        }

        if(!newPwd.equals(rePwd)){
            return Result.error("两次密码不一致");
        }

        userService.updatePwd(newPwd);
        return Result.success("修改成功");

    }


}
