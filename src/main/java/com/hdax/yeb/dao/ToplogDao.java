package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.Toplog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ToplogDao extends BaseMapper<Toplog> {

    public List<Toplog> query01(@Param("name") String name);
}
