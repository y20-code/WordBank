package com.yls.word_springboot.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Word {

    private Long id;

    private String word;

    private String phonetic;

    private String meaning;

    private String example;

    private Difficulty difficulty;

    private String category;

    private Integer status;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}

// 枚举类，用于 difficulty 字段
enum Difficulty {
    EASY, MEDIUM, HARD
}