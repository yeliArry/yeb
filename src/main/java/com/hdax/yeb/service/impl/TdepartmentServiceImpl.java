package com.hdax.yeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.yeb.dao.TdepartmentDao;
import com.hdax.yeb.entity.Tdepartment;
import com.hdax.yeb.service.TdepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TdepartmentServiceImpl extends ServiceImpl<TdepartmentDao, Tdepartment> implements TdepartmentService {
    @Resource
    private TdepartmentDao tdepartmentDao;

    @Override
    public List<Tdepartment> getAllDepartments() {
        return tdepartmentDao.getAllDepartments(-1);
    }

    @Override
    public void addDep(Tdepartment tdepartment) {
        tdepartment.setEnabled(1);
        tdepartmentDao.addDep(tdepartment);
    }

    @Override
    public int del(int id) {
        Tdepartment tdepartment = new Tdepartment();
        tdepartment.setId(id);
        return tdepartmentDao.del(id);
    }

    @Override
    public boolean updsalary(int salaryId, int id) {
        return tdepartmentDao.updsalary(salaryId, id);
    }

    @Override
    public Tdepartment get(String name) {
        return tdepartmentDao.get(name);
    }
}
