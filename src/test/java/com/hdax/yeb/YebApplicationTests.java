package com.hdax.yeb;

import com.hdax.yeb.dao.TemployeeDao;
import com.hdax.yeb.service.T_salary_approvalService;
import com.hdax.yeb.service.TemployeeService;
import com.hdax.yeb.service.TsalaryAdjustService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class YebApplicationTests<tsalaryAdjustService> {
    @Resource
    private TemployeeDao temployeeDao;
    @Resource
    private TemployeeService temployeeService;
    @Resource
    private TsalaryAdjustService tsalaryAdjustService;
    @Resource
    private T_salary_approvalService t_salary_approvalService;

    @Test
    public void test01() {
//        List<T_salary_approval> list = t_salary_approvalService.query02(1, 5);
//        for(T_salary_approval t:list){
//            System.out.println(t.getEid());
//        }
    }

    @Test
    public void test02() {

    }


}
