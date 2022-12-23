package com.example.demo.src.daangn;

import com.example.demo.src.daangn.model.GetInfoProfileRes;
import com.example.demo.src.daangn.model.GetInfoReviewRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DaangnDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DaangnDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 나의당근 프로필 상단 (기분정보 부분)
    public GetInfoProfileRes getProfileInfo(int idx) {
        String getRegion = "select S.*, User.nickname, User.manner" +
                " from RegionSettings as S, User " +
                "where User.idx = ? and S.userIdx = ?";

        String getBadgeNum = "(select count(*) from BadgeCollection" +
                " where userIdx = ? and status = 'ACTIVE') as badgeNum";
        String getItemNum = "(select count(*) from SellPost" +
                " where sellerIdx = ? and status in ('ACTIVE', 'SOLD')) as itemNum";

        String query = "select R.*, " +
                getBadgeNum + ", " +
                getItemNum +
                " from (" + getRegion + ") as R";

        return this.jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new GetInfoProfileRes(
                        rs.getInt("idx"),
                        rs.getString("nickname"),
                        rs.getFloat("manner"),

                        rs.getString("region1"),
                        rs.getInt("region1verify"),
                        rs.getString("region2"),
                        rs.getInt("region2verify"),

                        rs.getInt("badgeNum"),
                        rs.getInt("itemNum")
                        ), idx, idx, idx, idx);
    }

    // 나의당근 프로필 하단 (리뷰관련 부분)
    public GetInfoReviewRes getReviewInfo(int idx) {
        String getCount = "select " +
                "count(*) as reviewNum, " +
                "count(if(overall = 'BAD', 0, 1)) AS goodFeedback" +
                " from Review where postIdx in" +
                " (select idx from SellPost where sellerIdx = ?)";

        String getKeyword = "select " +
                "count(*) as feedbackNum, " +
                "count(if(isCome, 1, 0)) AS isComeNum, " +
                "count(if(isNice, 1, 0)) AS isNiceNum, " +
                "count(if(onTime, 1, 0)) AS onTimeNum, " +
                "count(if(isFast, 1, 0)) AS isFastNum" +
                " from ReviewKeyword where postIdx in" +
                " (select idx from SellPost where sellerIdx = ?)";

        String query = "select F.*, K.* from " +
                "(" + getCount + ") as F, " +
                "(" + getKeyword + ") as K";

        System.out.println(query);

        return this.jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new GetInfoReviewRes(
                        rs.getInt("goodFeedback"),
                        rs.getInt("feedbackNum"),
                        rs.getInt("isComeNum"),
                        rs.getInt("isNiceNum"),
                        rs.getInt("onTimeNum"),
                        rs.getInt("isFastNum"),
                        rs.getInt("reviewNum")
                ), idx, idx);

    }

}
