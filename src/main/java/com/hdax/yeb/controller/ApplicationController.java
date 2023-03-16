package com.hdax.yeb.controller;

import com.hdax.yeb.entity.Application;
import com.hdax.yeb.service.ApplicationService;
import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ApplicationController {

    @Resource
    private ApplicationService applicationService;

    @RequestMapping("/application/query")
    public R queryAll(@RequestParam(required = false, defaultValue = "") String lavetype) {
        long total = applicationService.getCount();
        List<Application> list = applicationService.queryAll(lavetype);
        return R.ok().data("list", list);
    }

    //老板审批
    @RequestMapping("/application/querystate")
    public R queryAllstate() {
        long total = applicationService.getCount();
        List<Application> list = applicationService.queryAllstate();
        return R.ok().data("list", list);
    }

    //经理审批
    @RequestMapping("/application/querystate04")
    public R queryAllstate04() {
        List<Application> list = applicationService.queryAllstate04();
        return R.ok().data("list", list);
    }

    @RequestMapping("/application/querystate02")
    public R queryAllstate02(@RequestParam(required = false, defaultValue = "") String lavetype) {
        long total = applicationService.getCount();
        List<Application> list = applicationService.queryAllstate02(lavetype);
        return R.ok().data("list", list);
    }

    @RequestMapping("/application/querystate03")
    public R queryAllstate03() {
        long total = applicationService.getCount();
        List<Application> list = applicationService.queryAllstate03();
        return R.ok().data("list", list);
    }

    @RequestMapping("/application/add")
    public R add(int eid, String leavetype, String applicatdate, String leavebegindate, String leaveenddate, int duration, String phone, String lavedesc) {
        Application application = new Application();
        application.setEid(eid);
        application.setLavetype(leavetype);
        application.setApplicatdate(applicatdate);
        application.setLeavebegindate(leavebegindate);
        application.setLeaveenddate(leaveenddate);
        application.setPhone(phone);
        //这里需要判断
        application.setDuration(duration);
        if (duration >= 72) {
            application.setState(1);
            application.setLavedesc(lavedesc);
            application.setBossstate(1);
            applicationService.add(application);
            List<Application> list = applicationService.queryAll("");
            return R.ok().data("list", list);
        } else {
            application.setState(1);
            application.setLavedesc(lavedesc);
            application.setBossstate(2);
            applicationService.add(application);
            List<Application> list = applicationService.queryAll("");
            return R.ok().data("list", list);
        }

    }

    @RequestMapping("/application/tongguo")
    public R tongguo(int id) {
        Application application = applicationService.getId(id);
        if (application.getBossstate() == 1) {
            applicationService.updTongguo(id, 2, 1, 0);
            List<Application> list = applicationService.queryAllstate();
            return R.ok().data("list", list);
        } else {
            applicationService.updTongguo(id, 2, 1, 0);
            List<Application> list = applicationService.queryAllstate04();
            return R.ok().data("list", list);
        }
    }

    @RequestMapping("/application/jujue")
    public R jujue(int id) {
        Application application = applicationService.getId(id);
        if (application.getBossstate() == 1) {
            applicationService.updTongguo(id, 2, 2, 0);
            List<Application> list = applicationService.queryAllstate();
            return R.ok().data("list", list);
        } else {
            applicationService.updTongguo(id, 2, 2, 0);
            List<Application> list = applicationService.queryAllstate04();
            return R.ok().data("list", list);
        }

    }
}