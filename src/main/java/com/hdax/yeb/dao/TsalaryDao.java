package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.Tsalary;

public interface TsalaryDao extends BaseMapper<Tsalary> {

    public Tsalary getMoneyByEid(int eid);

    //////修改应发工资
    public int upd(Tsalary tsalary);

    //修改基本工资
    public int updbasicSalary(Tsalary tsalary);
}
