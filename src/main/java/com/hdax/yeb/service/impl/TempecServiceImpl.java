package com.hdax.yeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.yeb.dao.Tem_ecDao;
import com.hdax.yeb.entity.Tem_ec;
import com.hdax.yeb.service.TemecService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TempecServiceImpl extends ServiceImpl<Tem_ecDao, Tem_ec> implements TemecService {
    @Resource
    private Tem_ecDao tem_ecDao;

    @Override
    public List<Tem_ec> query(int currentPage, int pageSize) {
        int start = (currentPage - 1) * pageSize;
        int end = pageSize;
        return tem_ecDao.query(start, end);
    }

    @Override
    public long getCount() {
        return tem_ecDao.getCount();
    }

    @Override
    public List<Tem_ec> stateQuery02() {
        return tem_ecDao.stateQuery02();
    }

    @Override
    public Tem_ec getId(int id) {
        return tem_ecDao.getId(id);
    }

    @Override
    public List<Tem_ec> stateQuery() {
        return tem_ecDao.stateQuery();
    }

    @Override
    public boolean updateState(int state, int result, int bossstate, int id) {
        return tem_ecDao.updateState(state, result, bossstate, id);
    }


}
