package com.hdax.yeb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hdax.yeb.dao.TdepartmentDao;
import com.hdax.yeb.entity.Tdepartment;
import com.hdax.yeb.service.TdepartmentService;
import com.hdax.yeb.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 部门Controller
 */
@RestController
public class TdepartmentController {
    @Resource
    private TdepartmentDao tdepartmentDao;
    @Resource
    private TdepartmentService tdepartmentService;

    /**
     * 得到部门表所有数据
     *
     * @return
     */
    @RequestMapping("/Tdep/getDep")
    public R getDep() {
        return R.ok().data("list", tdepartmentDao.queryAll());
    }

    @RequestMapping("/service/query03")
    public R query01(int currentpage) {
        Page<Tdepartment> page = new Page<>(currentpage, 5);
        IPage<Tdepartment> iPage = tdepartmentService.page(page);

        return R.ok().data("total", iPage.getTotal()).data("list", iPage.getRecords());
    }

    @RequestMapping("/stu/department")
    public R department() {
        return R.ok().data("list", tdepartmentService.list());
    }

    @RequestMapping("/t_department/query")
    public R getall() {
        return R.ok().data("list", tdepartmentService.getAllDepartments());
    }

    @RequestMapping("/t_department/add")
    public R add(String name, int salaryId, int parentId) {
        Tdepartment tdepartment = new Tdepartment();
        tdepartment.setSalaryId(salaryId);
        tdepartment.setName(name);
        tdepartment.setParentId(parentId);
        tdepartmentService.addDep(tdepartment);
        Tdepartment tdepartment1 = tdepartmentService.get(name);
        tdepartmentService.updsalary(salaryId, tdepartment1.getId());
        return R.ok().data("list", tdepartmentService.getAllDepartments());
    }

    @RequestMapping("/t_department/del")
    public R del(int id) {
        tdepartmentService.removeById(id);
        return R.ok().data("list", tdepartmentService.getAllDepartments());
    }
}
