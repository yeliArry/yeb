package com.hdax.yeb.controller;

import com.hdax.yeb.dao.TpoliticsStatusDao;
import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 政治面貌Controller
 */
@RestController
public class TpoliticsStatusController {
    @Resource
    private TpoliticsStatusDao tpoliticsStatusDao;

    @RequestMapping("/tps/getTpoliticsStatus")
    public R getTpoliticsStatus() {
        return R.ok().data("list", tpoliticsStatusDao.selectList(null));
    }
}
