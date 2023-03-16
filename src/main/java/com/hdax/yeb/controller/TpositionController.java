package com.hdax.yeb.controller;

import com.hdax.yeb.dao.TemployeeDao;
import com.hdax.yeb.dao.TpositionDao;
import com.hdax.yeb.entity.Temployee;
import com.hdax.yeb.entity.Tposition;
import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class TpositionController {
    @Resource
    private TpositionDao tpositionDao;
    @Resource
    private TemployeeDao temployeeDao;

    @RequestMapping("/Tposition/query01")
    public R query01() {
        return R.ok().data("list", tpositionDao.getpos());
    }

    @RequestMapping("/Tposition/query")
    public R query() {
        return R.ok().data("list", tpositionDao.selectList(null));
    }

    @RequestMapping("/Tposition/save")
    public R save(String name) {
        Tposition tposition = new Tposition();
        tposition.setName(name);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = sdf.format(date);
        tposition.setCreateDate(date1);
        tposition.setEnabled(1);
        tpositionDao.insert(tposition);
        return R.ok().data("list", tpositionDao.selectList(null));
    }

    @RequestMapping("/Tposition/update")
    public R update(Tposition tposition) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++" + tposition.getId());
        //Temployee temployee = temployeeService.getPosId(tposition.getId());
        List<Temployee> tem = temployeeDao.getByTemp(tposition.getId());
        if (tem.size() == 0) {
            tpositionDao.updateById(tposition);
        } else {
            return R.posupderror();
        }

        // tpositionDao.updateById(tposition);
        return R.ok().data("list", tpositionDao.selectList(null));


    }

    @RequestMapping("/Tposition/del")
    public R del(int id) {
        Tposition tposition = tpositionDao.selectById(id);
        List<Temployee> tem = temployeeDao.getByTemp(tposition.getId());
        if (tem.size() == 0) {
            tpositionDao.deleteById(id);
        } else {
            return R.posdelerror();
        }


        return R.ok().data("list", tpositionDao.selectList(null));
    }

    @RequestMapping("/Tposition/dels")
    public R dels(String myids) {
        String[] ss = myids.split("-");
        List<Integer> ids = new ArrayList<>();
        for (int i = 1; i < ss.length; i++) {
            ids.add(Integer.parseInt(ss[i]));
        }
        tpositionDao.deleteBatchIds(ids);
        return R.ok().data("list", tpositionDao.selectList(null));
    }
}
