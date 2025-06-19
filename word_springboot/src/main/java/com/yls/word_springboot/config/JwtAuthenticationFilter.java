package com.yls.word_springboot.config;

import com.yls.word_springboot.Util.JwtUtil;
import com.yls.word_springboot.Util.UserContext;
import com.yls.word_springboot.dto.UserDTO;
import com.yls.word_springboot.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;


    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7); // 移除 "Bearer " 前缀
            UserContext.clear();
            logger.debug("接受授权头: {}", header);
            try {
                String username = jwtUtil.getUsernameFromToken(token); // 使用 token 提取用户名
                logger.debug("从令牌中提取用户名: {}", username);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    logger.debug("加载用户的详细信息: {}", userDetails);
                    if (jwtUtil.verifyToken(token) != null) { // 使用 token 验证

                        UserDTO userDTO = userService.findByUserName(username);

                        if(userDTO != null) {
                            UserContext.setUser(userDTO);
                        }
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        logger.debug("用户身份验证集: {}", username);
                    } else {
                        logger.warn("令牌验证失败: {}", token);
                    }
                } else {
                    logger.debug("不需要身份验证或已设置身份验证");
                }
            } catch (Exception e) {
                logger.error("令牌处理错误: {}", e.getMessage());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "无效或过期令牌: " + e.getMessage());
                return;
            }
        } else {
            logger.warn("没有找到有效的授权标头: {}", header == null ? "null" : header);
            UserContext.clear();
        }
        chain.doFilter(request, response);
    }
}
