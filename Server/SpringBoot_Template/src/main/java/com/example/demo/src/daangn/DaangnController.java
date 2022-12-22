package com.example.demo.src.daangn;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.daangn.model.GetInfoProfileRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app/daangn")
public class DaangnController {

    private final DaangnProvider daangnProvider;

    @Autowired
    public DaangnController(DaangnProvider daangnProvider) {
        this.daangnProvider = daangnProvider;
    }

    /**
     * 프로필 기본정보 API
     * [GET] /info/profile
     * */
    @ResponseBody
    @GetMapping("/info/profile")
    public BaseResponse<GetInfoProfileRes> getProfileInfo() {
        try {
            GetInfoProfileRes getInfoProfileRes = daangnProvider.getProfileInfo();
            return new BaseResponse<>(getInfoProfileRes);
        }
        catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}
