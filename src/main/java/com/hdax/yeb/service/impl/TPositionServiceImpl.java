package com.hdax.yeb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdax.yeb.dao.TpositionDao;
import com.hdax.yeb.entity.Tposition;
import com.hdax.yeb.service.TPositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TPositionServiceImpl extends ServiceImpl<TpositionDao, Tposition> implements TPositionService {
    @Resource
    private TpositionDao tpositionDao;

    @Override
    public List<Tposition> getpos() {
        return tpositionDao.getpos();
    }
}
