package com.hdax.yeb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdax.yeb.dao.TsalaryAdjustDao;
import com.hdax.yeb.entity.T_salary_approval;
import com.hdax.yeb.entity.TsalaryAdjust;
import com.hdax.yeb.service.T_salary_approvalService;
import com.hdax.yeb.service.TsalaryAdjustService;
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
public class TsalaryAdjustController {
    @Resource
    private TsalaryAdjustService tsalaryAdjustService;

    @Resource
    private TsalaryAdjustDao tsalaryAdjustDao;

    @Resource
    private T_salary_approvalService t_salary_approvalService;

    @RequestMapping("/TsalaryAdjust/query")
    public R query01(@RequestParam(required = false, defaultValue = "1") int cpage, @RequestParam(required = false, defaultValue = "5") int pageSize) {
        List<TsalaryAdjust> list = tsalaryAdjustService.query01(cpage, pageSize);
        long total = tsalaryAdjustService.getCount();
        return R.ok().data("list", list).data("total", total);
    }

    //查询申请页面记录
    @RequestMapping("/TsalaryAdjust/query02")
    public R query02(@RequestParam(required = false, defaultValue = "-1") int eid, @RequestParam(required = false, defaultValue = "1") int cpage, @RequestParam(required = false, defaultValue = "5") int pageSize) {
        List<T_salary_approval> list = t_salary_approvalService.query02(eid, cpage, pageSize);
        long total = t_salary_approvalService.getCount();
        return R.ok().data("list", list).data("total", total);
    }

    //查询审批页面记录
    @RequestMapping("/TsalaryAdjust/query03")
    public R query03() {
        List<T_salary_approval> list = t_salary_approvalService.query03();

        return R.ok().data("list", list);
    }


    //申请页面记录
    @RequestMapping("/TsalaryAdjust/save02")
    public R save02(int eid, int abeforeSalary, int aafterSalary, String areason, int cpage, int pageSize) {
        T_salary_approval t_salary_approval = new T_salary_approval();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = sdf.format(date);
        t_salary_approval.setAasDate(date1);
        t_salary_approval.setEid(eid);
        t_salary_approval.setAbeforeSalary(abeforeSalary);
        t_salary_approval.setAafterSalary(aafterSalary);
        t_salary_approval.setAreason(areason);
        t_salary_approval.setAremark(null);
        t_salary_approval.setAstate(1);
        t_salary_approvalService.add(t_salary_approval);
        List<T_salary_approval> list = t_salary_approvalService.query02(-1, cpage, pageSize);
        long total = t_salary_approvalService.getCount();
        return R.ok().data("list", list).data("total", total);
    }


    @RequestMapping("/TsalaryAdjust/del")
    public R del(int id, int cpage, int pageSize) {
        tsalaryAdjustService.removeById(id);

        List<TsalaryAdjust> list = tsalaryAdjustService.query01(cpage, pageSize);
        long total = tsalaryAdjustService.getCount();

        Page<TsalaryAdjust> page = new Page<>(cpage, pageSize);
        IPage<TsalaryAdjust> iPage = tsalaryAdjustService.page(page);
        long pages = iPage.getPages();

        if (cpage > pages) {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage - 1);
        } else {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage);
        }
    }

    @RequestMapping("/t_salary_approval/del")
    public R dele(int id, int pageSize) {
        t_salary_approvalService.removeById(id);
        List<T_salary_approval> list = t_salary_approvalService.query02(-1, 1, pageSize);
        long total = t_salary_approvalService.getCount();
        return R.ok().data("list", list).data("total", total);
    }

    @RequestMapping("/TsalaryAdjust/dels")
    public R dels(String myids, int cpage, int pageSize) {
        String[] ss = myids.split("-");
        List<Integer> ids = new ArrayList<>();
        for (int i = 1; i < ss.length; i++) {
            ids.add(Integer.parseInt(ss[i]));
        }
        tsalaryAdjustService.removeByIds(ids);

        List<TsalaryAdjust> list = tsalaryAdjustService.query01(cpage, pageSize);
        long total = tsalaryAdjustService.getCount();

        Page<TsalaryAdjust> page = new Page<>(cpage, pageSize);
        IPage<TsalaryAdjust> iPage = tsalaryAdjustService.page(page);
        long pages = iPage.getPages();

        if (cpage > pages) {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage - 1);
        } else {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage);
        }
    }

    @RequestMapping("/TsalaryAdjust/tongyi")
    public R tongyi(int id, int eid, int beforeSalary, int afterSalary, String reason, String aremark) {
        TsalaryAdjust tsalaryAdjust = new TsalaryAdjust();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = sdf.format(date);
        tsalaryAdjust.setEid(eid);
        tsalaryAdjust.setAsDate(date1);
        tsalaryAdjust.setBeforeSalary(beforeSalary);
        tsalaryAdjust.setAfterSalary(afterSalary);
        tsalaryAdjust.setReason(reason);
        tsalaryAdjust.setRemark(null);
        tsalaryAdjustDao.delByEid(eid);
        tsalaryAdjustService.addtongyi(tsalaryAdjust);
        t_salary_approvalService.updatezhangtai(2, 1, id);
        t_salary_approvalService.updatearemark(aremark, id);
        List<T_salary_approval> list = t_salary_approvalService.query03();
        return R.ok().data("list", list);
    }

    @RequestMapping("/TsalaryAdjust/jujue")
    public R jujue(int id, String aremark) {
        t_salary_approvalService.updatezhangtai(2, 2, id);
        t_salary_approvalService.updatearemark(aremark, id);
        List<T_salary_approval> list = t_salary_approvalService.query03();

        return R.ok().data("list", list);
    }
}
