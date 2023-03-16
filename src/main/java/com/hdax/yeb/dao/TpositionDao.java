package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.Tposition;

import java.util.List;

public interface TpositionDao extends BaseMapper<Tposition> {
    public List<Tposition> getpos();
}
