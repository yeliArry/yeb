package com.hdax.yeb.controller;

import com.hdax.yeb.dao.TemployeeDao;
import com.hdax.yeb.dao.TjoblevelDao;
import com.hdax.yeb.entity.Temployee;
import com.hdax.yeb.entity.Tjoblevel;
import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TjoblevelController {
    @Resource
    private TjoblevelDao tjoblevelDao;

    @Resource
    private TemployeeDao temployeeDao;

    @RequestMapping("/Tjoblevel/query")
    public R query() {
        return R.ok().data("list", tjoblevelDao.selectList(null));
    }

    @RequestMapping("/Tjoblevel/query01")
    public R getTjob() {
        return R.ok().data("list", tjoblevelDao.getTjob());
    }

    @RequestMapping("/Tjoblevel/save")
    public R save(String name, String titleLevel) {
        //System.out.println(tjoblevel);
        Tjoblevel tjoblevel = new Tjoblevel();
        tjoblevel.setName(name);
        tjoblevel.setTitleLevel(titleLevel);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = sdf.format(date);
        tjoblevel.setCreateDate(date1);
        tjoblevel.setEnabled(1);

        tjoblevelDao.insert(tjoblevel);
        return R.ok().data("list", tjoblevelDao.selectList(null));
    }

    @RequestMapping("/Tjoblevel/update")
    public R update(@RequestBody Tjoblevel tjoblevel) {

        List<Temployee> tem = temployeeDao.getByjobLevelId(tjoblevel.getId());
        if (tem.size() == 0) {
            tjoblevelDao.updateById(tjoblevel);
        } else {
            return R.posupderror();
        }

        return R.ok().data("list", tjoblevelDao.selectList(null));
    }

    @RequestMapping("/Tjoblevel/del")
    public R del(Integer id) {
        Tjoblevel tjoblevel = tjoblevelDao.selectById(id);
        List<Temployee> tem = temployeeDao.getByjobLevelId(tjoblevel.getId());
        if (tem.size() == 0) {
            tjoblevelDao.deleteById(id);
        } else {
            return R.posdelerror();
        }


        return R.ok().data("list", tjoblevelDao.selectList(null));
    }

    @RequestMapping("/Tjoblevel/dels")
    public R dels(String myids) {
        String[] ss = myids.split("-");
        List<Integer> ids = new ArrayList<>();
        for (int i = 1; i < ss.length; i++) {
            ids.add(Integer.parseInt(ss[i]));
        }
        tjoblevelDao.deleteBatchIds(ids);
        return R.ok().data("list", tjoblevelDao.selectList(null));
    }
}
