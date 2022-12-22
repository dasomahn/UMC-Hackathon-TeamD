package com.example.demo.src.home;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.home.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/app/home")
public class HomeController {

    private final HomeProvider homeProvider;
    private final HomeService homeService;

    @Autowired
    public HomeController(HomeProvider homeProvider, HomeService homeService){
        this.homeProvider = homeProvider;
        this.homeService = homeService;
    }

    @ResponseBody
    @GetMapping("") // 홈 화면
    public BaseResponse<List<GetHomeRes>> getHome() {
        try {
            List<GetHomeRes> getHomeResList = homeProvider.getHome();
            return new BaseResponse<>(getHomeResList);
        }
        catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    /**
     * 물건 상세보기 API (글 번호로 보기)
     * [GET] /:postIdx
     * */
    @ResponseBody
    @GetMapping("/{postIdx}")
    public BaseResponse<GetPostRes> getPostByIdx(@PathVariable("postIdx") int idx) {
        try {
            System.out.println("idx = " + idx);
            GetPostRes getPostRes = homeProvider.getPostByIdx(idx);
            return new BaseResponse<>(getPostRes);
        }
        catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    /**
     * 카테고리 API (종류 조회?)
     * [GET] /category
     * */
    @ResponseBody
    @GetMapping("/category")
    public BaseResponse<List<GetCateRes>> getAllCate() {
        try {
            List<GetCateRes> getCateResList = homeProvider.getAllCate();
            return new BaseResponse<>(getCateResList);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    /**
     * 검색 API // 카테고리 기능 아직 x
     * [GET] /search?keyword=()
     * */
    @ResponseBody
    @GetMapping("/search")
    public BaseResponse<List<GetHomeRes>> getHomeSearch(@RequestParam(value="keyword") String keyword) {
        try {
            List<GetHomeRes> getHomeResList = homeProvider.getHomeSearch(keyword);
            return new BaseResponse<>(getHomeResList);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

}
