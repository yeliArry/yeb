package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.Application;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplicationDao extends BaseMapper<Application> {

    public List<Application> queryAll(@Param("lavetype") String lavetype);

    //老板审批页面
    public List<Application> queryAllstate();

    //经理审批页面
    public List<Application> queryAllstate04();

    //待办理页面
    public List<Application> queryAllstate03();

    //审批完成
    public List<Application> queryAllstate02(@Param("lavetype") String lavetype);

    public long getCount();

    //单标新增
    public boolean add(Application application);

    //审批判断
    public Application getId(int id);

    //审批通过
    public boolean updTongguo(@Param("id") int id, @Param("state") int state, @Param("auditresults") int auditresults, @Param("bossstate") int bossstate);
}
