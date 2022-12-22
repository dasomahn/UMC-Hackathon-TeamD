package com.example.demo.src.home;

import com.example.demo.src.home.model.GetHomeRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HomeProvider {
    private final HomeDao homeDao;

    @Autowired
    public HomeProvider(HomeDao homeDao) {
        this.homeDao = homeDao;
    }

    // Home화면 (거래글 list)
    public List<GetHomeRes> getHome() {
        return homeDao.getHome();
    }

}
