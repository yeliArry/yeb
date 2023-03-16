package com.hdax.yeb.controller;

import com.hdax.yeb.dao.ToplogDao;
import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ToplogController {
    @Resource
    private ToplogDao toplogDao;

    @RequestMapping("/toplog/query01")
    public R query01(String name) {
        return R.ok().data("list", toplogDao.query01(name));
    }

//    @RequestMapping("/toplog/save")
//    public R save(Toplog toplog){
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1 = sdf.format(date);
//        toplog.setAddDate(date1);
//        toplogDao.insert(toplog);
//        return R.ok().data("list",toplogDao.query01());
//    }
}
