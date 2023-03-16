package com.hdax.yeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.yeb.dao.TsalaryAdjustDao;
import com.hdax.yeb.entity.TsalaryAdjust;
import com.hdax.yeb.service.TsalaryAdjustService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TsalaryAdjustServiceImpl extends ServiceImpl<TsalaryAdjustDao, TsalaryAdjust> implements TsalaryAdjustService {
    @Resource
    private TsalaryAdjustDao tsalaryAdjustDao;

    @Override
    public boolean updtongyi(int id, int afterSalary, int state, int salaryresults) {
        return tsalaryAdjustDao.updtongyi(id, afterSalary, state, salaryresults);
    }

    @Override
    public boolean addtongyi(TsalaryAdjust tsalaryAdjust) {
        return tsalaryAdjustDao.addtongyi(tsalaryAdjust);
    }

    @Override
    public List<TsalaryAdjust> query01(int currentPage, int pageSize) {
        int start = (currentPage - 1) * pageSize;
        int end = pageSize;
        return tsalaryAdjustDao.query01(start, end);
    }

    @Override
    public long getCount() {
        return tsalaryAdjustDao.getCount();
    }
}
