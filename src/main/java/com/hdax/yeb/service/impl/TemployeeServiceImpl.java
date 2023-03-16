package com.hdax.yeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.yeb.dao.TemployeeDao;
import com.hdax.yeb.entity.Temployee;
import com.hdax.yeb.service.TemployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemployeeServiceImpl extends ServiceImpl<TemployeeDao, Temployee> implements TemployeeService {
    @Resource
    private TemployeeDao temployeeDao;


    @Override
    public List<Temployee> query01(int currentPage, int pageSize) {
        int start = (currentPage - 1) * pageSize;
        int end = pageSize;
        return temployeeDao.query01(start, end);
    }

    @Override
    public List<Temployee> query10(int currentPage, int pageSize) {
        int start = (currentPage - 1) * pageSize;
        int end = pageSize;
        return temployeeDao.query10(start, end);
    }

    @Override
    public long getCount() {
        return temployeeDao.getCount();
    }


    @Override
    public List<Temployee> query02() {
        return temployeeDao.query02();
    }

    @Override
    public Temployee getOneEmp(int id) {
        return temployeeDao.getOneEmp(id);
    }

    @Override
    public int updOneEmp(Temployee temployee) {
        return temployeeDao.updOneEmp(temployee);
    }

    @Override
    public List<Temployee> query03(int currentPage, int pageSize) {
        int start = (currentPage - 1) * pageSize;
        int end = pageSize;
        return temployeeDao.query03(start, end);
    }

    @Override
    public Temployee getPosId(int posId) {
        return temployeeDao.getPosId(posId);
    }

    //高级搜索
    @Override
    public List<Temployee> gaoquery(String name, int politicId, int nationId, int departmentId, int jobLevelId, int posId, String engageForm, int currentpage, int pageSize) {
        int start = (currentpage - 1) * pageSize;
        int end = pageSize;
        List<Temployee> list = temployeeDao.gaoquery(name, politicId, nationId, departmentId, jobLevelId, posId, engageForm, start, end);
        return list;
    }

    @Override
    public long gaoqueryCount(String name, int politicId, int nationId, int departmentId, int joblevelId, int posId, String engageForm) {
        return temployeeDao.gaoqueryCount(name, politicId, nationId, departmentId, joblevelId, posId, engageForm);
    }

}
