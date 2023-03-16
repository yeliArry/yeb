package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.Tadmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TadminDao extends BaseMapper<Tadmin> {

    public Tadmin login(@Param("username") String username, @Param("password") String password);

    public List<Tadmin> query01(@Param("name") String name);
}
