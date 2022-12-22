package com.example.demo.src.home;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.home.model.GetHomeRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        List<GetHomeRes> getHomeResList = homeProvider.getHome();
        return new BaseResponse<>(getHomeResList);
    }
}
