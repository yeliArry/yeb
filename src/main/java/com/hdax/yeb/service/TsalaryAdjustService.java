package com.hdax.yeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.yeb.entity.TsalaryAdjust;

import java.util.List;

public interface TsalaryAdjustService extends IService<TsalaryAdjust> {

    public List<TsalaryAdjust> query01(int currentPage, int pageSize);

    public boolean addtongyi(TsalaryAdjust tsalaryAdjust);

    public boolean updtongyi(int id, int afterSalary, int state, int salaryresults);

    public long getCount();
}
