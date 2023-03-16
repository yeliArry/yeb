package com.hdax.yeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.yeb.entity.Tem_ec;

import java.util.List;

public interface TemecService extends IService<Tem_ec> {

    public List<Tem_ec> query(int currentPage, int pageSize);

    public long getCount();

    public List<Tem_ec> stateQuery();

    public List<Tem_ec> stateQuery02();

    public boolean updateState(int state, int result, int bossstate, int id);

    public Tem_ec getId(int id);//审批判断


}
