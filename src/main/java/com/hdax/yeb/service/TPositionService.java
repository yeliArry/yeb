package com.hdax.yeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.yeb.entity.Tposition;

import java.util.List;

public interface TPositionService extends IService<Tposition> {
    public List<Tposition> getpos();
}
