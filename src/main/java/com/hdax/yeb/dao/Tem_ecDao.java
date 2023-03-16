package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.Tem_ec;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Tem_ecDao extends BaseMapper<Tem_ec> {

    public List<Tem_ec> query(@Param("start") int start, @Param("end") int end);

    public long getCount();

    //boss审批
    public List<Tem_ec> stateQuery();

    //经理审批
    public List<Tem_ec> stateQuery02();

    public boolean updateState(@Param("state") int state, @Param("result") int result, @Param("bossstate") int bossstate, @Param("id") int id);

    public Tem_ec getId(int id);//审批判断


}
