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
        String query = "select * from SellPost where ~";
        // active상태, 설정한 동네 근처에 있는 게시글만하게 추가
        // 좋아요수, 채팅수도 가져오기?
        return this.jdbcTemplate.query(simpleQuery,
                (rs, rowNum) -> new GetHomeRes(
                        rs.getInt("idx"),
                        rs.getString("title"),
                        rs.getInt("regionIdx"),
                        rs.getDate("createdAt"),
                        rs.getString("imgUrl")
                ));
    }
}
