package com.yls.word_springboot.exception;

import com.yls.word_springboot.pojo.Result;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public Result<String> handleGeneralException(Exception e) {
        return Result.error("服务器错误: " + e.getMessage());
    }
}
