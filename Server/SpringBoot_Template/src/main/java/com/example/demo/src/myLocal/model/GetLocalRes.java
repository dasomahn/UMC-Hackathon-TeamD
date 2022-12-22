package com.example.demo.src.myLocal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class GetLocalRes {
    private int idx;
    private int categoryIdx;
    private String content;

    private String nickname;
    private int regionIdx;
    private Date createdAt;
    private String imgURL;
    // interested/like, reply/comment 제외
}