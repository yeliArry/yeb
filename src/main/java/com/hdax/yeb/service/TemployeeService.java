package com.hdax.yeb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdax.yeb.entity.Temployee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemployeeService extends IService<Temployee> {

    public List<Temployee> query01(int currentPage, int pageSize);

    //分页联表查
    public List<Temployee> query10(int currentPage, int pageSize);

    public long getCount();

    public List<Temployee> query02();

    public Temployee getOneEmp(int id);

    public int updOneEmp(Temployee temployee);

    public List<Temployee> query03(int currentPage, int pageSize);

    //按照id查职位
    public Temployee getPosId(int posId);

    List<Temployee> gaoquery(@Param("name") String name, @Param("politicId") int politicId, @Param("nationId") int nationId, @Param("departmentId") int departmentId, @Param("jobLevelId") int jobLevelId, @Param("posId") int posId, @Param("engageForm") String engageForm, @Param("start") int start, @Param("end") int end);

    public long gaoqueryCount(@Param("name") String name, @Param("politicId") int politicId, @Param("nationId") int nationId, @Param("departmentId") int departmentId, @Param("jobLevelId") int jobLevelId, @Param("posId") int posId, @Param("engageForm") String engageForm);

}
