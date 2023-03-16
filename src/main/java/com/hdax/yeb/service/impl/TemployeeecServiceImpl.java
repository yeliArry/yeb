package com.hdax.yeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.yeb.dao.TemployeeecDao;
import com.hdax.yeb.entity.Temployeeec;
import com.hdax.yeb.service.TemployeeecService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemployeeecServiceImpl extends ServiceImpl<TemployeeecDao, Temployeeec> implements TemployeeecService {
    @Resource
    private TemployeeecDao temployeeecDao;


    @Override
    public List<Temployeeec> query01(int currentPage, int pageSize) {
        int start = (currentPage - 1) * pageSize;
        int end = pageSize;
        return temployeeecDao.getquery(start, end);
    }

    @Override
    public long getCount() {
        return temployeeecDao.getCount();
    }
}
