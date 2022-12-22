package com.example.demo.src.myLocal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class GetLocalRes {
    private int idx;
    private int categoryIdx;
    private String cateName;
    private String content;

    private int userIdx;
    private String nickname;
//    private int regionIdx;
    private String region;
    private Timestamp createdAt;
    private String imgURL;
    // interested/like, reply/comment 제외
}