package com.hdax.yeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.yeb.entity.Temployeeec;

import java.util.List;

public interface TemployeeecService extends IService<Temployeeec> {

    public List<Temployeeec> query01(int currentPage, int pageSize);

    public long getCount();
}
