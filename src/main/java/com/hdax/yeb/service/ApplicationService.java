package com.hdax.yeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.yeb.entity.Application;

import java.util.List;

public interface ApplicationService extends IService<Application> {

    public List<Application> queryAll(String lavetype);

    public long getCount();

    //单标新增
    public boolean add(Application application);

    public List<Application> queryAllstate();

    //审批通过
    public boolean updTongguo(int id, int state, int auditresults, int bossstate);

    //审批完成
    public List<Application> queryAllstate02(String lavetype);

    //经理审批页面
    public List<Application> queryAllstate04();

    //待办理页面
    public List<Application> queryAllstate03();

    //审批判断
    public Application getId(int id);
}
