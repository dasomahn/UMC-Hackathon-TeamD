package com.example.demo.src.home;

import com.example.demo.src.home.model.GetHomeRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HomeDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public HomeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    // 홈 화면 (글 조회)
    public List<GetHomeRes> getHome() {
        String simpleQuery = "select * from SellPost";
        String getCurRegion = "select regionRange, " +
                "CASE " +
                "WHEN selected = 1 then region1 " +
                "WHEN selected = 2 then region2 " +
                "END as regionIdx " +
                "FROM RegionSettings where userIdx = 1"; // 우선 user 1번으로 하드코딩
        String getRegionRange = "select Region.idx from Region, (" + getCurRegion + ") AS S " +
                "WHERE Region.idx BETWEEN (S.regionIdx - S.regionRange) AND (S.regionIdx + S.regionRange)";


        String query = "select * from SellPost where status = 'ACTIVE'" + // active 상태
                " and regionIdx in (" + getRegionRange + ")"; // 설정한 동네 근처
        /*
        select * from SellPost
         where status = 'ACTIVE' and regionIdx in (
            select Region.idx from Region, (
                select regionRange, CASE
                    WHEN selected = 1 then region1
                    WHEN selected = 2 then region2 END as regionIdx FROM RegionSettings where userIdx = 1) AS S
            WHERE Region.idx BETWEEN (S.regionIdx - S.regionRange) AND (S.regionIdx + S.regionRange) )
         */

        // 좋아요수, 채팅수도 가져오기!
        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new GetHomeRes(
                        rs.getInt("idx"),
                        rs.getString("title"),
                        rs.getInt("regionIdx"),
                        rs.getDate("createdAt"),
                        rs.getString("imgUrl")
                ));
    }
}
