package com.hdax.yeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.yeb.dao.ApplicationDao;
import com.hdax.yeb.entity.Application;
import com.hdax.yeb.service.ApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationDao, Application> implements ApplicationService {

    @Resource
    private ApplicationDao applicationDao;

    @Override
    public List<Application> queryAllstate02(String lavetype) {

        return applicationDao.queryAllstate02(lavetype);
    }

    @Override
    public List<Application> queryAllstate04() {
        return applicationDao.queryAllstate04();
    }

    @Override
    public Application getId(int id) {
        return applicationDao.getId(id);
    }

    @Override
    public List<Application> queryAllstate03() {
        return applicationDao.queryAllstate03();
    }

    @Override
    public boolean updTongguo(int id, int state, int auditresults, int bossstate) {
        return applicationDao.updTongguo(id, state, auditresults, bossstate);
    }

    @Override
    public List<Application> queryAllstate() {

        return applicationDao.queryAllstate();
    }

    @Override
    public boolean add(Application application) {
        return applicationDao.add(application);
    }

    @Override
    public long getCount() {
        return applicationDao.getCount();
    }

    @Override
    public List<Application> queryAll(String lavetype) {

        return applicationDao.queryAll(lavetype);
    }
}
