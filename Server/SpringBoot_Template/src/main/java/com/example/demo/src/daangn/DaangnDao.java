package com.example.demo.src.daangn;

import com.example.demo.src.daangn.model.GetInfoProfileRes;
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
}
