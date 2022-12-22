package com.example.demo.src.home;

import com.example.demo.src.home.model.*;
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

        String getPostTable = "select * from SellPost where status = 'ACTIVE'" + // active 상태
                " and regionIdx in (" + getRegionRange + ")"; // 설정한 동네 근처

        String query = "select R.name, P.* from Region as R, (" + getPostTable + ") as P" +
                " where R.idx = P.regionIdx";
        /*
        select * from SellPost
         where status = 'ACTIVE' and regionIdx in (
            select Region.idx from Region, (
                select regionRange, CASE
                    WHEN selected = 1 then region1
                    WHEN selected = 2 then region2 END as regionIdx FROM RegionSettings where userIdx = 1) AS S
            WHERE Region.idx BETWEEN (S.regionIdx - S.regionRange) AND (S.regionIdx + S.regionRange) )
         를 이제 한번 더 감싼
         */

        // 좋아요수, 채팅수도 가져오기!
        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new GetHomeRes(
                        rs.getInt("idx"),
                        rs.getString("imgURL"),
                        rs.getString("title"),
//                        rs.getInt("regionIdx"),
                        rs.getString("name"),
                        rs.getTimestamp("createdAt"),
                        rs.getString("type"),
                        rs.getInt("price")
                ));
    }

    // 물건 상세 보기
    public GetPostRes getPostByIdx(int idx) {
        String query = "select P.*, User.manner, Region.name, User.nickname, C.name as cateName" +
                " from SellPost as P, User, Region, SellCategory as C" +
                " where P.idx = ? and P.status = 'ACTIVE'" +
                " and P.sellerIdx = User.idx and P.regionIdx = Region.idx and P.categoryIdx = C.idx";

        return this.jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new GetPostRes(
                        rs.getInt("idx"),
                        rs.getInt("sellerIdx"),
                        rs.getString("nickname"),
                        rs.getString("name"),
                        rs.getFloat("manner"),

                        rs.getString("type"),
                        rs.getString("title"),
                        rs.getInt("categoryIdx"),
                        rs.getString("cateName"),
                        rs.getTimestamp("createdAt"),
                        rs.getString("content"),
                        rs.getString("imgUrl"),

                        rs.getInt("price"),
                        rs.getString("wantNego")

                ), idx);
    }
    
    // 카테고리 전체 조회
    public List<GetCateRes> getAllCate() {
        String query = "select idx, name from SellCategory where status = 'ACTIVE'";
        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new GetCateRes(
                        rs.getInt("idx"),
                        rs.getString("name")
                ));
    }

    // 홈 검색
    // getHome()과 동일해서 합치는게 좋을지 의문
    public List<GetHomeRes> getHomeSearch(String keyword) {
        String getCurRegion = "select regionRange, " +
                "CASE " +
                "WHEN selected = 1 then region1 " +
                "WHEN selected = 2 then region2 " +
                "END as regionIdx " +
                "FROM RegionSettings where userIdx = 1"; // 우선 user 1번으로 하드코딩
        String getRegionRange = "select Region.idx from Region, (" + getCurRegion + ") AS S " +
                "WHERE Region.idx BETWEEN (S.regionIdx - S.regionRange) AND (S.regionIdx + S.regionRange)";


        String getPostTable = "select * from SellPost where status = 'ACTIVE'" + // active 상태
                " and regionIdx in (" + getRegionRange + ")" + // 설정한 동네 근처
                " and title LIKE \"%" + keyword +"%\""; // 글 검색

        String query = "select R.name, P.* from Region as R, (" + getPostTable + ") as P" +
                " where R.idx = P.regionIdx";
        return this.jdbcTemplate.query(query,
                (rs, rowNum) -> new GetHomeRes(
                        rs.getInt("idx"),
                        rs.getString("imgURL"),
                        rs.getString("title"),
//                        rs.getInt("regionIdx"),
                        rs.getString("name"),
                        rs.getTimestamp("createdAt"),
                        rs.getString("type"),
                        rs.getInt("price")
                ));
    }
}
