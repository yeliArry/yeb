package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.T_salary_approval;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface T_salary_approvalDao extends BaseMapper<T_salary_approval> {
    public List<T_salary_approval> query02(@Param("eid") int eid, @Param("start") int start, @Param("end") int end);

    public List<T_salary_approval> query03();

    public boolean add(T_salary_approval t_salary_approval);

    //同意以后修改状态
    public boolean updatezhangtai(@Param("astate") int astate, @Param("asalaryresults") int asalaryresults, @Param("id") int id);

    //拒绝以后改拒绝理由
    public boolean updatearemark(@Param("aremark") String aremark, @Param("id") int id);

    public long getCount();
}
