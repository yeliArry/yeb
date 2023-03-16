package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.TemployeeRemove;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemployeeRemoveDao extends BaseMapper<TemployeeRemove> {

    public List<TemployeeRemove> query01(@Param("start") int start, @Param("end") int end);

    public long getCount();

    public TemployeeRemove getByEid(int eid);

    //只查出来启用的
    public List<TemployeeRemove> getquerytemp();
}
