package com.example.demo.src.myLocal;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.myLocal.model.GetLocalRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/app/myLocal")
public class MyLocalController {

    private final MyLocalProvider myLocalProvider;

    @Autowired
    public MyLocalController(MyLocalProvider myLocalProvider) {
        this.myLocalProvider = myLocalProvider;
    }

    @ResponseBody
    @GetMapping("") // 동네생활 첫 화면
    public BaseResponse<List<GetLocalRes>> getLocal() {
        try {
            List<GetLocalRes> getLocalResList = myLocalProvider.getLocal();
            return new BaseResponse<>(getLocalResList);
        }
        catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}
