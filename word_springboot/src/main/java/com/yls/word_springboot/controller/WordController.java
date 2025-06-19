package com.yls.word_springboot.controller;

import com.yls.word_springboot.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class WordController {

    @GetMapping("/words")
    public Result<String> getAllWord(){
        return Result.success("返回所有的文章数据");
    }
}
