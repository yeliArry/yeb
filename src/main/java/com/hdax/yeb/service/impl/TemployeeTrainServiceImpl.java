package com.hdax.yeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.yeb.dao.TemployeeTrainDao;
import com.hdax.yeb.entity.TemployeeTrain;
import com.hdax.yeb.service.TemployeeTrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemployeeTrainServiceImpl extends ServiceImpl<TemployeeTrainDao, TemployeeTrain> implements TemployeeTrainService {
    @Resource
    private TemployeeTrainDao temployeeTrainDao;


    @Override
    public List<TemployeeTrain> query01(int currentPage, int pageSize) {
        int start = (currentPage - 1) * pageSize;
        int end = pageSize;
        return temployeeTrainDao.query01(start, end);
    }

    @Override
    public long getCount() {
        return temployeeTrainDao.getCount();
    }
}
