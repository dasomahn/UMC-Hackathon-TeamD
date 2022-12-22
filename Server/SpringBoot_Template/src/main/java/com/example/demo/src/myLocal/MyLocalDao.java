package com.example.demo.src.myLocal;

import com.example.demo.src.myLocal.model.GetLocalRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyLocalDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MyLocalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 동네생활 홈 화면 (글 조회)
    public List<GetLocalRes> getLocal() {
        String getCurRegion = "select " +
                "CASE " +
                "WHEN selected = 1 then region1 " +
                "WHEN selected = 2 then region2 " +
                "END as regionIdx " +
                "FROM RegionSettings where userIdx = 1"; // 우선 user 1번으로 하드코딩
        String getRegionRange = "select Region.idx from Region, (" + getCurRegion + ") AS S " +
                "WHERE Region.idx BETWEEN (S.regionIdx - 1) AND (S.regionIdx + 1)";


        String getPostTable  = "select * from LocalPost where status = 'ACTIVE'" +
                " and regionIdx in (" + getRegionRange + ")";

        String query = "select U.nickname, P.*, C.name as cateName, R.name as region" +
                " from User as U, (" + getPostTable + ") as P, LocalCategory as C, Region as R" +
                " where P.userIdx = U.idx and P.categoryIdx = C.idx and P.regionIdx = R.idx";

        System.out.println("query = " + query);
        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new GetLocalRes(
                        rs.getInt("idx"),
                        rs.getInt("categoryIdx"),
                        rs.getString("cateName"),
                        rs.getString("content"),

                        rs.getInt("userIdx"),
                        rs.getString("nickname"),
//                        rs.getInt("regionIdx"),
                        rs.getString("region"),
                        rs.getTimestamp("createdAt"),
                        rs.getString("imgURL")
                ));
    }
}
