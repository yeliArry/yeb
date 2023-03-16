package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.TsalaryAdjust;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TsalaryAdjustDao extends BaseMapper<TsalaryAdjust> {

    public List<TsalaryAdjust> query01(@Param("start") int start, @Param("end") int end);

    public boolean updtongyi(@Param("id") int id, @Param("afterSalary") int afterSalary, @Param("state") int state, @Param("salaryresults") int salaryresults);

    public long getCount();

    //同意后新增
    public boolean addtongyi(TsalaryAdjust tsalaryAdjust);

    public int delByEid(int eid);
}
