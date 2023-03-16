package com.hdax.yeb.controller;

import com.hdax.yeb.dao.TadminRoleDao;
import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TadminRoleController {
    @Resource
    private TadminRoleDao tadminRoleDao;

    @RequestMapping("/tar/query01")
    public R query01(String name) {
        return R.ok().data("list", tadminRoleDao.query01(name));
    }
}
