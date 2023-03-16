package com.hdax.yeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.yeb.dao.T_salary_approvalDao;
import com.hdax.yeb.entity.T_salary_approval;
import com.hdax.yeb.service.T_salary_approvalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class T_salary_approvalServiceImpl extends ServiceImpl<T_salary_approvalDao, T_salary_approval> implements T_salary_approvalService {
    @Resource
    private T_salary_approvalDao t_salary_approvalDao;

    @Override
    public List<T_salary_approval> query02(int eid, int currentPage, int pageSize) {
        int start = (currentPage - 1) * pageSize;
        int end = pageSize;
        return t_salary_approvalDao.query02(eid, start, end);
    }

    @Override
    public boolean updatearemark(String aremark, int id) {
        return t_salary_approvalDao.updatearemark(aremark, id);
    }

    @Override
    public boolean updatezhangtai(int astate, int asalaryresults, int id) {
        return t_salary_approvalDao.updatezhangtai(astate, asalaryresults, id);
    }

    @Override
    public long getCount() {
        return t_salary_approvalDao.getCount();
    }

    @Override
    public List<T_salary_approval> query03() {

        return t_salary_approvalDao.query03();
    }

    @Override
    public boolean add(T_salary_approval t_salary_approval) {
        return t_salary_approvalDao.add(t_salary_approval);
    }
}
