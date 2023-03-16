package com.hdax.yeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.yeb.entity.TemployeeTrain;

import java.util.List;

public interface TemployeeTrainService extends IService<TemployeeTrain> {

    public List<TemployeeTrain> query01(int currentPage, int pageSize);

    public long getCount();
}
