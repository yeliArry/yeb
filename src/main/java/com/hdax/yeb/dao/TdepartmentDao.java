package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.Tdepartment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门接口
 */
public interface TdepartmentDao extends BaseMapper<Tdepartment> {

    /**
     * 获取所有部门
     */
    public List<Tdepartment> getAllDepartments(Integer parentId);

    public void addDep(Tdepartment tdepartment);

    public boolean updsalary(@Param("salaryId") int salaryId, @Param("id") int id);

    public Tdepartment get(@Param("name") String name);

    public int del(int id);

    public List<Tdepartment> queryAll();

    public int updsalaryId(int salaryId);

    public Tdepartment getId(int id);
}
