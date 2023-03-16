package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.TemployeeTrain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemployeeTrainDao extends BaseMapper<TemployeeTrain> {

    public List<TemployeeTrain> query01(@Param("start") int start, @Param("end") int end);

    public long getCount();
}
