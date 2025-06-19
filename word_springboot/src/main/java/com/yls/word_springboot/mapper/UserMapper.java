package com.yls.word_springboot.mapper;

import com.yls.word_springboot.dto.UserDTO;
import com.yls.word_springboot.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {


    @Select("SELECT *  FROM users")
    List<User> getAllUser();

    @Insert("insert into users(username,password,email,role,created_at,updated_at) " +
            "values (#{username},#{BCpssword},#{email},#{role},now(),now())")
    void addUser(String username, String BCpssword, String email, String role);

    @Select("select username,email,password,role from users where username = #{username} ")
    UserDTO findByUserName(String username);


    @Update("update users set username=#{username},email=#{email},status=#{isActive},updated_at=#{updatedAt} where id =#{userId}")
    void updateUser(User user);

    @Update("update users set password=#{encode} where username=#{username}")
    void updatePwd(String encode,String username);
}
