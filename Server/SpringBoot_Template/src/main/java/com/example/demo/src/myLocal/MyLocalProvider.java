package com.example.demo.src.myLocal;

import com.example.demo.config.BaseException;
import com.example.demo.src.myLocal.model.GetLocalRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

@Service
@Transactional(readOnly = true)
public class MyLocalProvider {
    private final MyLocalDao myLocalDao;

    @Autowired
    public MyLocalProvider(MyLocalDao myLocalDao) {
        this.myLocalDao = myLocalDao;
    }

    // 동네생활 홈화면 (동네 글 list) GET
    public List<GetLocalRes> getLocal() throws BaseException {
        try {
            List<GetLocalRes> getLocalResList = myLocalDao.getLocal();
            return getLocalResList;
        }
        catch (Exception e) {
            System.out.println(e);
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
