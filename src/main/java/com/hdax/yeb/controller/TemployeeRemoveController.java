package com.hdax.yeb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdax.yeb.dao.TdepartmentDao;
import com.hdax.yeb.dao.TemRemoveDao;
import com.hdax.yeb.dao.TemployeeRemoveDao;
import com.hdax.yeb.entity.TemRemove;
import com.hdax.yeb.entity.Temployee;
import com.hdax.yeb.entity.TemployeeRemove;
import com.hdax.yeb.service.TdepartmentService;
import com.hdax.yeb.service.TemRemoveService;
import com.hdax.yeb.service.TemployeeRemoveService;
import com.hdax.yeb.service.TemployeeService;
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
public class TemployeeRemoveController {
    @Resource
    private TemployeeRemoveService temployeeRemoveService;
    @Resource
    private TemployeeService temployeeService;
    @Resource
    private TdepartmentService tdepartmentService;
    @Resource
    private TemployeeRemoveDao temployeeRemoveDao;
    @Resource
    private TdepartmentDao tdepartmentDao;
    @Resource
    private TemRemoveDao temRemoveDao;
    @Resource
    private TemRemoveService temRemoveService;

    @RequestMapping("/TemployeeRemove/query01")
    public R query01(@RequestParam(required = false, defaultValue = "1") int cpage, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        List<TemployeeRemove> list = temployeeRemoveService.query01(cpage, pageSize);
        long total = temployeeRemoveService.getCount();
        return R.ok().data("list", list).data("total", total);
    }

    @RequestMapping("/TemployeeRemove/save")
    public R save(int eid, int afterDepId, int afterJobId, String reason, int cpage, int pageSize) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //TemployeeRemove temployeeRemove = new TemployeeRemove();
        TemRemove temRemove = new TemRemove();
        String date1 = sdf.format(date);
        temRemove.setRemoveDate(date1);
        //temployeeRemove.setRemark(null);
        temRemove.setEid(eid);
        temRemove.setAfterDepId(afterDepId);
        temRemove.setAfterJobId(afterJobId);
        temRemove.setReason(reason);
        temRemove.setState(1);
        //temployeeRemove.setState(1);
        //temployeeRemoveService.save(temployeeRemove);
        temRemoveDao.insert(temRemove);


//
//        Temployee temployee =   temployeeService.getOneEmp(eid);
//
//        Tdepartment tdepartment = tdepartmentDao.getId(afterDepId);
//
//        Temployee temployee1 = new Temployee();
//
//        temployee1.setDepartmentId(afterDepId);
//        temployee1.setPosId(afterJobId);
//        temployee1.setSalaryId(tdepartment.getSalaryId());
//        temployee1.setId(eid);
//
//        temployeeService.updOneEmp(temployee1);


        //List<TemployeeRemove> list = temployeeRemoveService.query01(cpage, pageSize);
        List<TemRemove> list = temRemoveService.queryRem(cpage, pageSize);
        long total = temRemoveService.getCount();
        return R.ok().data("list", list).data("total", total);
//
    }

    @RequestMapping("/TemployeeRemove/del")
    public R del(int id, int cpage, int pageSize) {
        temRemoveDao.deleteById(id);

        List<TemRemove> list = temRemoveService.queryRem(cpage, pageSize);
        long total = temRemoveService.getCount();
        Page<TemRemove> page = new Page<>(cpage, pageSize);
        IPage<TemRemove> iPage = temRemoveDao.selectPage(page, null);
        long pages = iPage.getPages();
        if (cpage > pages) {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage - 1);
        } else {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage);
        }
    }

    @RequestMapping("/TemployeeRemove/update")
    public R update(TemployeeRemove temployeeRemove, int cpage, int pageSize) {
        temployeeRemoveService.updateById(temployeeRemove);
        Temployee temployee = temployeeService.getOneEmp(temployeeRemove.getEid());

        int did = temployeeRemove.getAfterDepId();

        int jid = temployeeRemove.getAfterJobId();

        Temployee temployee1 = new Temployee();

        temployee1.setDepartmentId(did);
        temployee1.setPosId(jid);
        temployee1.setId(temployeeRemove.getEid());

        temployeeService.updOneEmp(temployee1);

        List<TemployeeRemove> list = temployeeRemoveService.query01(cpage, pageSize);
        long total = temployeeRemoveService.getCount();

        return R.ok().data("list", list).data("total", total).data("cpage", cpage);
    }

    @RequestMapping("/TemployeeRemove/dels")
    public R dels(String myids, int cpage, int pageSize) {
        String[] ss = myids.split("-");
        List<Integer> ids = new ArrayList<>();
        for (int i = 1; i < ss.length; i++) {
            ids.add(Integer.parseInt(ss[i]));
        }
        temployeeRemoveService.removeByIds(ids);

        List<TemployeeRemove> list = temployeeRemoveService.query01(cpage, pageSize);
        long total = temployeeRemoveService.getCount();

        Page<TemployeeRemove> page = new Page<>(cpage, pageSize);
        IPage<TemployeeRemove> iPage = temployeeRemoveService.page(page);
        long pages = iPage.getPages();

        if (cpage > pages) {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage - 1);
        } else {
            return R.ok().data("list", list).data("total", total).data("cpage", cpage);
        }
    }

    @RequestMapping("/TemployeeRemove/getOneByEid")
    public R getOneByEid(int eid) {
        return R.ok().data("emp", temployeeRemoveService.getByEid(eid));
    }


}
