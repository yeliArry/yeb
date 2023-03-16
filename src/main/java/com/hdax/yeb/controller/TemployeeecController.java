package com.hdax.yeb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdax.yeb.dao.Tem_ecDao;
import com.hdax.yeb.dao.TemployeeDao;
import com.hdax.yeb.entity.Tem_ec;
import com.hdax.yeb.entity.Temployeeec;
import com.hdax.yeb.service.TemecService;
import com.hdax.yeb.service.TemployeeecService;
import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TemployeeecController {
    @Resource
    private TemployeeecService temployeeecService;
    @Resource
    private TemployeeDao temployeeDao;
    @Resource
    private Tem_ecDao tem_ecDao;
    @Resource
    private TemecService temecService;

    @RequestMapping("/Temployeeec/query01")
    public R query01(@RequestParam(required = false, defaultValue = "1") int currentPage, @RequestParam(required = false, defaultValue = "5") int pageSize) {
        List<Temployeeec> list = temployeeecService.query01(currentPage, pageSize);
        long total = temployeeecService.getCount();
        return R.ok().data("list", list).data("total", total);
    }

    @RequestMapping("/Temployeeec/save")
    public R save(Tem_ec tem_ec, @RequestParam(required = false, defaultValue = "1") int currentPage, @RequestParam(required = false, defaultValue = "5") int pageSize) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = sdf.format(date);
        tem_ec.setEcDate(date1);
        tem_ec.setRemark(null);
        if (tem_ec.getEcPoint() >= 500) {
            tem_ec.setState(1);//1是审核中
            tem_ec.setBossstate(1);//老板审核
            tem_ecDao.insert(tem_ec);
            // List<Temployeeec> list = temployeeecService.query01(cpage,pageSize);
            List<Tem_ec> list = temecService.query(currentPage, pageSize);
            long total = temecService.getCount();
            return R.ok().data("list", list).data("total", total).data("currentPage", currentPage);
        } else {
            tem_ec.setState(1);//1是审核中
            tem_ec.setBossstate(2);//经理审核
            tem_ecDao.insert(tem_ec);
            // List<Temployeeec> list = temployeeecService.query01(cpage,pageSize);
            List<Tem_ec> list = temecService.query(currentPage, pageSize);
            long total = temecService.getCount();
            return R.ok().data("list", list).data("total", total).data("currentPage", currentPage);
        }


    }

    @RequestMapping("/Temployeeec/del")
    public R del(int id, int cpage, int pageSize) {
        temployeeecService.removeById(id);
        List<Temployeeec> list = temployeeecService.query01(cpage, pageSize);
        long total = temployeeecService.getCount();


        Page<Temployeeec> page = new Page<>(cpage, 5);
        IPage<Temployeeec> iPage = temployeeecService.page(page);
        long pages = iPage.getPages();
        if (cpage > pages) {

            return R.ok().data("list", list).data("total", total).data("cpage", cpage - 1);
        } else {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage);
        }


    }

    @RequestMapping("/Temployeeec/update")
    public R update(Temployeeec temployeeec, int cpage, int pageSize) {
        System.out.println(temployeeec.getEcPoint());
        temployeeecService.updateById(temployeeec);
        List<Temployeeec> list = temployeeecService.query01(cpage, pageSize);
        long total = temployeeecService.getCount();

        return R.ok().data("list", list).data("total", total).data("cpage", cpage);
    }

    @RequestMapping("/Temployeeec/dels")
    public R dels(String myids, int cpage, int pageSize) {
        String[] ss = myids.split("-");
        List<Integer> ids = new ArrayList<>();
        for (int i = 1; i < ss.length; i++) {
            ids.add(Integer.parseInt(ss[i]));
        }
        temployeeecService.removeByIds(ids);
        List<Temployeeec> list = temployeeecService.query01(cpage, pageSize);
        long total = temployeeecService.getCount();

        Page<Temployeeec> page = new Page<>(cpage, pageSize);
        IPage<Temployeeec> iPage = temployeeecService.page(page);
        long pages = iPage.getPages();
        if (cpage > pages) {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage - 1);
        } else {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage);
        }
    }
}
