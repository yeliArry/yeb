package com.hdax.yeb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdax.yeb.entity.TemployeeTrain;
import com.hdax.yeb.service.TemployeeTrainService;
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
public class TemployeeTrainController {
    @Resource
    private TemployeeTrainService temployeeTrainService;

    @RequestMapping("/TemployeeTrain/query")
    public R query01(@RequestParam(required = false, defaultValue = "1") int cpage, @RequestParam(required = false, defaultValue = "5") int pageSize) {
        List<TemployeeTrain> list = temployeeTrainService.query01(cpage, pageSize);
        long total = temployeeTrainService.getCount();
        return R.ok().data("list", list).data("total", total);
    }

    @RequestMapping("/TemployeeTrain/save")
    public R save(TemployeeTrain temployeeTrain, int cpage, int pageSize) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = sdf.format(date);
        temployeeTrain.setTrainDate(date1);
        temployeeTrain.setRemark(null);
        temployeeTrainService.save(temployeeTrain);

        List<TemployeeTrain> list = temployeeTrainService.query01(cpage, pageSize);
        long total = temployeeTrainService.getCount();

        Page<TemployeeTrain> page = new Page<>(cpage, pageSize);
        IPage<TemployeeTrain> iPage = temployeeTrainService.page(page);
        long pages = iPage.getPages();

        return R.ok().data("list", list).data("total", total).data("cpage", pages);
    }

    @RequestMapping("/TemployeeTrain/del")
    public R del(int id, int cpage, int pageSize) {
        temployeeTrainService.removeById(id);

        List<TemployeeTrain> list = temployeeTrainService.query01(cpage, pageSize);
        long total = temployeeTrainService.getCount();

        Page<TemployeeTrain> page = new Page<>(cpage, pageSize);
        IPage<TemployeeTrain> iPage = temployeeTrainService.page(page);
        long pages = iPage.getPages();

        if (cpage > pages) {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage - 1);
        } else {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage);
        }
    }

    @RequestMapping("/TemployeeTrain/dels")
    public R dels(String myids, int cpage, int pageSize) {
        String[] ss = myids.split("-");
        List<Integer> ids = new ArrayList<>();
        for (int i = 1; i < ss.length; i++) {
            ids.add(Integer.parseInt(ss[i]));
        }
        temployeeTrainService.removeByIds(ids);

        List<TemployeeTrain> list = temployeeTrainService.query01(cpage, pageSize);
        long total = temployeeTrainService.getCount();

        Page<TemployeeTrain> page = new Page<>(cpage, pageSize);
        IPage<TemployeeTrain> iPage = temployeeTrainService.page(page);
        long pages = iPage.getPages();

        if (cpage > pages) {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage - 1);
        } else {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage);
        }
    }

    @RequestMapping("/TemployeeTrain/update")
    public R update(TemployeeTrain temployeeTrain, int cpage, int pageSize) {
        temployeeTrainService.updateById(temployeeTrain);

        List<TemployeeTrain> list = temployeeTrainService.query01(cpage, pageSize);
        long total = temployeeTrainService.getCount();

        return R.ok().data("list", list).data("total", total).data("cpage", cpage);
    }
}
