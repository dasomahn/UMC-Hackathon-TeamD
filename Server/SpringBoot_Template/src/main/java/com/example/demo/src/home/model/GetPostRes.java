package com.example.demo.src.home.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class GetPostRes {
    private int idx;
    private int sellerIdx;
//    private int regionIdx;
    private String region;
    private float manner;

    private String type;
    private String title;
    private int categoryIdx;
    private Timestamp createdAt;
    private String content;
    private String imgURL;

    private int price;
    private String wantNego;
}
