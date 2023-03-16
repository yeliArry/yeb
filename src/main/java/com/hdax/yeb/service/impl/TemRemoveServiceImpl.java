package com.hdax.yeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.yeb.dao.TemRemoveDao;
import com.hdax.yeb.entity.TemRemove;
import com.hdax.yeb.service.TemRemoveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemRemoveServiceImpl extends ServiceImpl<TemRemoveDao, TemRemove> implements TemRemoveService {
    @Resource
    private TemRemoveDao temRemoveDao;


    @Override
    public List<TemRemove> queryRem(int currentPage, int pageSize) {
        int start = (currentPage - 1) * pageSize;
        int end = pageSize;
        return temRemoveDao.queryRem(start, end);
    }

    @Override
    public long getCount() {
        return temRemoveDao.getCount();
    }
}
