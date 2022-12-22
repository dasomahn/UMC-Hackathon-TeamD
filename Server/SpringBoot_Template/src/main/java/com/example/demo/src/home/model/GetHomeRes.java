package com.example.demo.src.home.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class GetHomeRes {
    private int idx;
    private String  imgURL;
    private String title;
//    private int regionIdx;
    private String region;
    private Timestamp createdAt;
    private String type;
    private int price;

    /*
    private int favNum;
    private int chatNum;
     */
}