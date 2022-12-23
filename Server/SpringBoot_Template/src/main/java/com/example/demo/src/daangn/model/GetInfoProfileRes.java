package com.example.demo.src.daangn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetInfoProfileRes {
    private int idx;
    private String nickname;
    private float manner;

    private String region1;
    private int region1verify;
    private String region2;
    private int region2verify;

    private int badgeNum;
    private int itemNum;
}
