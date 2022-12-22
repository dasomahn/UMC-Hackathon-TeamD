package com.example.demo.src.daangn;

import com.example.demo.config.BaseException;
import com.example.demo.src.daangn.model.GetInfoProfileRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

@Service
@Transactional(readOnly = true)
public class DaangnProvider {

    private final DaangnDao daangnDao;

    @Autowired
    public DaangnProvider(DaangnDao daangnDao) {
        this.daangnDao = daangnDao;
    }

    // 나의당근 - 프로필 상단 기본정보 GET
    public GetInfoProfileRes getProfileInfo() throws BaseException {
        try {
            GetInfoProfileRes getInfoProfileRes = daangnDao.getProfileInfo(1);
            // admin인 1로 우선 하드코딩
            return getInfoProfileRes;
        } catch (Exception e) {
            System.out.println(e);
            throw new BaseException(DATABASE_ERROR);
        }
    }


}
