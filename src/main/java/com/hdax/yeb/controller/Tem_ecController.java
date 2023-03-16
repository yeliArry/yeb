package com.hdax.yeb.controller;

import com.hdax.yeb.dao.Tem_ecDao;
import com.hdax.yeb.dao.TemployeeecDao;
import com.hdax.yeb.entity.Tem_ec;
import com.hdax.yeb.entity.Temployeeec;
import com.hdax.yeb.service.TemecService;
import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class Tem_ecController {
    @Resource
    private Tem_ecDao tem_ecDao;
    @Resource
    private TemployeeecDao temployeeecDao;
    @Resource
    private TemecService temecService;

    /**
     * 审批奖惩查询方法(链表查分页)
     *
     * @return
     */
    @RequestMapping("/temEc/queryTemEc")
    public R queryTemEc(@RequestParam(required = false, defaultValue = "1") int currentPage, @RequestParam(required = false, defaultValue = "5") int pageSize) {
        List<Tem_ec> list = temecService.query(currentPage, pageSize);
        long total = temecService.getCount();
        return R.ok().data("list", list).data("total", total);
    }

    @RequestMapping("/temEc/stateQuery")
    public R stateQuery() {
        List<Tem_ec> list = temecService.stateQuery();

        return R.ok().data("list", list);
    }

    @RequestMapping("/temEc/stateQuery02")
    public R stateQuery02() {
        List<Tem_ec> list = temecService.stateQuery02();

        return R.ok().data("list", list);
    }

    @RequestMapping("/temp/saveGo")
    public R saveGo(int id, int eid, String ecReason, int ecPoint, int ecType, String remark) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Temployeeec temployeeec = new Temployeeec();
        String date1 = sdf.format(date);
        temployeeec.setEcDate(date1);
        temployeeec.setEid(eid);
        temployeeec.setEcReason(ecReason);
        temployeeec.setEcPoint(ecPoint);
        temployeeec.setEcType(ecType);
        temployeeec.setRemark(remark);
        temployeeecDao.insert(temployeeec);
        Tem_ec tem_ec = temecService.getId(id);
        if (tem_ec.getBossstate() == 1) {
            tem_ecDao.updateState(2, 2, 0, id);
            List<Tem_ec> list = temecService.stateQuery();
            return R.ok().data("list", list);
        } else {
            tem_ecDao.updateState(2, 2, 0, id);
            List<Tem_ec> list = temecService.stateQuery02();
            return R.ok().data("list", list);
        }

    }

    @RequestMapping("/temp/updateGo")
    public R updateGo(int id) {
        Tem_ec tem_ec = temecService.getId(id);
        if (tem_ec.getBossstate() == 1) {
            tem_ecDao.updateState(2, 1, 0, id);
            List<Tem_ec> list = temecService.stateQuery();
            return R.ok().data("list", list);
        } else {
            tem_ecDao.updateState(2, 1, 0, id);
            List<Tem_ec> list = temecService.stateQuery02();
            return R.ok().data("list", list);
        }
    }

    @RequestMapping("/temp/del")
    public R dele(int id) {
        temecService.removeById(id);
        List<Tem_ec> list = temecService.stateQuery();
        long total = temecService.getCount();
        return R.ok().data("list", list);
    }
}


