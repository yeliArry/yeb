package com.hdax.yeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.yeb.entity.TemRemove;

import java.util.List;

public interface TemRemoveService extends IService<TemRemove> {

    //调动审批查询方法(链表查分页)
    public List<TemRemove> queryRem(int currentPage, int pageSize);

    //查询总条数
    public long getCount();
}
