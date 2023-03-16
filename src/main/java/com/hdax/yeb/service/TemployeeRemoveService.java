package com.hdax.yeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.yeb.entity.TemployeeRemove;

import java.util.List;

public interface TemployeeRemoveService extends IService<TemployeeRemove> {

    public List<TemployeeRemove> query01(int currentPage, int pageSize);

    public long getCount();

    public TemployeeRemove getByEid(int eid);

    public List<TemployeeRemove> getquerytemp();
}
