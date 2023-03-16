package com.hdax.yeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.yeb.entity.T_salary_approval;

import java.util.List;

public interface T_salary_approvalService extends IService<T_salary_approval> {
    public List<T_salary_approval> query02(int eid, int currentPage, int pageSize);

    public List<T_salary_approval> query03();

    public long getCount();

    //同意以后修改状态
    public boolean updatezhangtai(int astate, int asalaryresults, int id);

    public boolean add(T_salary_approval t_salary_approval);

    //拒绝以后改拒绝理由
    public boolean updatearemark(String aremark, int id);
}
