package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.TadminRole;

import java.util.List;

public interface TadminRoleDao extends BaseMapper<TadminRole> {

    public List<TadminRole> query01(String name);
}
