package com.hdax.yeb.controller;

import com.hdax.yeb.dao.TnationDao;
import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 民族controller
 */
@RestController
public class TnationController {
    @Resource
    private TnationDao tnationDao;

    @RequestMapping("/Tnation/getTnation")
    public R getTnation() {
        return R.ok().data("list", tnationDao.selectList(null));
    }
}
