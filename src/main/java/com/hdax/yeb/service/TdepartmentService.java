package com.hdax.yeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.yeb.entity.Tdepartment;

import java.util.List;

public interface TdepartmentService extends IService<Tdepartment> {

    /**
     * 获取所有部门
     */
    public List<Tdepartment> getAllDepartments();

    public void addDep(Tdepartment tdepartment);

    public int del(int id);

    public boolean updsalary(int salaryId, int id);

    public Tdepartment get(String name);
}
