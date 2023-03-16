package com.hdax.yeb.controller;

import com.hdax.yeb.dao.TdepartmentDao;
import com.hdax.yeb.dao.TemRemoveDao;
import com.hdax.yeb.entity.Tdepartment;
import com.hdax.yeb.entity.TemRemove;
import com.hdax.yeb.entity.Temployee;
import com.hdax.yeb.entity.TemployeeRemove;
import com.hdax.yeb.service.TemRemoveService;
import com.hdax.yeb.service.TemployeeRemoveService;
import com.hdax.yeb.service.TemployeeService;
import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class TemRemoveController {
    @Resource
    private TemRemoveDao temRemoveDao;

    @Resource
    private TemRemoveService temRemoveService;

    @Resource
    private TemployeeRemoveService temployeeRemoveService;

    @Resource
    private TemployeeService temployeeService;

    @Resource
    private TdepartmentDao tdepartmentDao;

    //调动审核表查询
    @RequestMapping("/rem/queryRem")
    public R queryRem(@RequestParam(required = false, defaultValue = "1") int cpage, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        List<TemRemove> list = temRemoveService.queryRem(cpage, pageSize);
        long total = temRemoveService.getCount();
        return R.ok().data("list", list).data("total", total);
    }

    //调动表新增/调动审核表的通过方法
    @RequestMapping("/rem/saveRemove")
    public R saveRemove(int id, int eid, int afterDepId, int afterJobId, String reason) {
        TemployeeRemove temployeeRemove = new TemployeeRemove();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = sdf.format(date);
        temployeeRemove.setRemoveDate(date1);
        temployeeRemove.setEid(eid);
        temployeeRemove.setAfterDepId(afterDepId);
        temployeeRemove.setAfterJobId(afterJobId);
        temployeeRemove.setReason(reason);
        temployeeRemove.setState(2);
        temployeeRemove.setResult(1);
        temployeeRemoveService.save(temployeeRemove);
        TemRemove temRemove = new TemRemove();
        temRemove.setId(id);
        temRemove.setState(2);
        temRemove.setResult(1);
        temRemoveDao.updState(temRemove);
        Temployee temployee = temployeeService.getOneEmp(temployeeRemove.getEid());
        Tdepartment tdepartment = tdepartmentDao.getId(temployeeRemove.getAfterDepId());
        Temployee temployee1 = new Temployee();
        temployee1.setDepartmentId(temployeeRemove.getAfterDepId());
        temployee1.setPosId(temployeeRemove.getAfterJobId());
        temployee1.setSalaryId(tdepartment.getSalaryId());
        temployee1.setId(temployeeRemove.getEid());
        temployeeService.updOneEmp(temployee1);

        return R.ok().data("list", temRemoveDao.queryByState(1));
    }


    //调动表新增/调动审核表的拒绝方法
    @RequestMapping("/rem/savejujue")
    public R savejujue(int id) {
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1 = sdf.format(date);
//        temployeeRemove.setRemoveDate(date1);
//        temployeeRemove.setEid(temployeeRemove.getEid());
//        temployeeRemove.setAfterDepId(temployeeRemove.getAfterDepId());
//        temployeeRemove.setAfterJobId(temployeeRemove.getAfterJobId());
//        temployeeRemove.setReason(temployeeRemove.getReason());
//        temployeeRemove.setState(2);
//        temployeeRemove.setResult(2);
//        temployeeRemoveService.save(temployeeRemove);

//        List<TemRemove> tem = temRemoveDao.getRemEid(temployeeRemove.getEid());
//        for(TemRemove t : tem){
//            if(t.getState() == 1){
//                TemRemove temRemove  = new TemRemove();
//                temRemove.setId(t.getId());
//                temRemove.setState(2);
//                temRemove.setResult(2);
//                temRemoveDao.updState(temRemove);
//            }
//        }
        TemRemove temRemove = new TemRemove();
        temRemove.setId(id);
        temRemove.setState(2);
        temRemove.setResult(2);
        temRemoveDao.updState(temRemove);


        return R.ok().data("list", temRemoveDao.queryByState(1));
    }


    @RequestMapping("/rem/queryByState")
    public R queryByState() {
        return R.ok().data("list", temRemoveDao.queryByState(1));
    }
}
