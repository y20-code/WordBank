package com.yls.word_springboot;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.yls.word_springboot.Util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class JwtTest {

    @Autowired
    private JwtUtil jwtUtil;

    @Test
    public void test() {
        HashMap<String, String> claims = new HashMap<>();
        claims.put("id", "1");
        claims.put("username", "yls");
        String token = jwtUtil.generateToken(claims.get("username"));
        System.out.println(token);
    }

    @Test
    public void test2() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJxd2VydHl1aW9wIiwiaWF0IjoxNzUwMjM0NzM2LCJleHAiOjE3NTAzMjExMzZ9.qOj-0Hq6OXnkMGpFBDIHTwGFzBTiEb4Q3q2SW6mRDBM";


        String usernameFromToken = jwtUtil.getUsernameFromToken(token);
        System.out.println(usernameFromToken);



    }
}
