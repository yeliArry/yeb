package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.TemRemove;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemRemoveDao extends BaseMapper<TemRemove> {
    //调动审批查询方法(链表查分页)
    public List<TemRemove> queryRem(@Param("start") int start, @Param("end") int end);

    //查询总条数
    public long getCount();

    //修改调动审批表的状态和结果
    public int updState(TemRemove temRemove);

    //按照eid查询调动的审批记录
    public List<TemRemove> getRemEid(int eid);

    //查询状态是2的
    public List<TemRemove> queryByState(int state);
}
