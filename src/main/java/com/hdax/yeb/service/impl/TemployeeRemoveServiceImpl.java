package com.hdax.yeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.yeb.dao.TemployeeRemoveDao;
import com.hdax.yeb.entity.TemployeeRemove;
import com.hdax.yeb.service.TemployeeRemoveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemployeeRemoveServiceImpl extends ServiceImpl<TemployeeRemoveDao, TemployeeRemove> implements TemployeeRemoveService {
    @Resource
    private TemployeeRemoveDao temployeeRemoveDao;

    @Override
    public List<TemployeeRemove> query01(int currentPage, int pageSize) {
        int start = (currentPage - 1) * pageSize;
        int end = pageSize;
        return temployeeRemoveDao.query01(start, end);
    }

    @Override
    public long getCount() {
        return temployeeRemoveDao.getCount();
    }

    @Override
    public TemployeeRemove getByEid(int eid) {
        return temployeeRemoveDao.getByEid(eid);
    }

    @Override
    public List<TemployeeRemove> getquerytemp() {
        return temployeeRemoveDao.getquerytemp();
    }
}
