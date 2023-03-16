package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.Tjoblevel;

import java.util.List;

public interface TjoblevelDao extends BaseMapper<Tjoblevel> {

    public List<Tjoblevel> getTjob();


}
