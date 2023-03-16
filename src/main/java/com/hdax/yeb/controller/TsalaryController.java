package com.hdax.yeb.controller;

import com.hdax.yeb.dao.TsalaryDao;
import com.hdax.yeb.entity.Tsalary;
import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class TsalaryController {
    @Resource
    private TsalaryDao tSalaryDao;

    @RequestMapping("/tSalary/query")
    public R query() {
        return R.ok().data("list", tSalaryDao.selectList(null));
    }

    @RequestMapping("/tSalary/save")
    public R save(@RequestBody Tsalary tsalary) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = sdf.format(date);
        tsalary.setCreateDate(date1);

        tSalaryDao.insert(tsalary);
        return R.ok().data("list", tSalaryDao.selectList(null));
    }

    @RequestMapping("/tSalary/del")
    public R del(int id) {
        tSalaryDao.deleteById(id);
        return R.ok().data("list", tSalaryDao.selectList(null));
    }

    @RequestMapping("/tSalary/update")
    public R update(@RequestBody Tsalary tsalary) {
        tSalaryDao.updateById(tsalary);
        return R.ok().data("list", tSalaryDao.selectList(null));
    }

    public R getMoneyByEId(int eid) {

        return null;
    }

}
