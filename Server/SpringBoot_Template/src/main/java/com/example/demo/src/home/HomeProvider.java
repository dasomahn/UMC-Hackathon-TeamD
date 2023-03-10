package com.example.demo.src.home;

import com.example.demo.config.BaseException;
import com.example.demo.src.home.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

@Service
@Transactional(readOnly = true)
public class HomeProvider {
    private final HomeDao homeDao;

    @Autowired
    public HomeProvider(HomeDao homeDao) {
        this.homeDao = homeDao;
    }

    // Home화면 (거래글 list) GET
    public List<GetHomeRes> getHome() throws BaseException {
        try {
            List<GetHomeRes> getHomeResList = homeDao.getHome();
            return getHomeResList;
        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    // 물건 상세 보기 - idx로 GET
    public GetPostRes getPostByIdx(int idx) throws BaseException {
        try {
            GetPostRes getPostRes = homeDao.getPostByIdx(idx);
            return getPostRes;
        } catch (EmptyResultDataAccessException e) {
            throw new BaseException(POST_UNAVAILABLE_ERROR);
        } catch (Exception e) {
            System.out.println(e);
            throw new BaseException(DATABASE_ERROR);
        }
    }

    // 카테고리 종류 조회 GET
    public List<GetCateRes> getAllCate() throws BaseException {
        try {
            List<GetCateRes> getCateResList = homeDao.getAllCate();
            return getCateResList;
        } catch (Exception e) {
            throw new BaseException((DATABASE_ERROR));
        }

    }

    // 키워드 검색 GET
    public List<GetHomeRes> getHomeSearch(String keyword) throws BaseException {
        try {
            List<GetHomeRes> getHomeResList = homeDao.getHomeSearch(keyword);
            return getHomeResList;
        } catch (Exception e) {
            System.out.println(e);
            throw new BaseException((DATABASE_ERROR));
        }
    }

}
