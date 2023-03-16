package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.Temployeeec;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemployeeecDao extends BaseMapper<Temployeeec> {

    public List<Temployeeec> getquery(@Param("start") int start, @Param("end") int end);

    public long getCount();

    public List<Temployeeec> queryEid(int eid);


}
