package com.example.demo.src.daangn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetInfoReviewRes {
    private int goodFeedback;
    private int feedbackNum;

    private int isComeNum;
    private int isNiceNum;
    private int onTimeNum;
    private int isFastNum;
    private int reviewNum;
}
