package com.hdax.yeb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdax.yeb.entity.Temployee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemployeeDao extends BaseMapper<Temployee> {
    //分页联表查
    public List<Temployee> query01(@Param("start") int start, @Param("end") int end);

    //分页联表查
    public List<Temployee> query10(@Param("start") int start, @Param("end") int end);

    //总条数
    public long getCount();

    public int update01(@Param("id") int id, @Param("salaryId") int salaryId);

    public Temployee getName(String name);

    public List<Temployee> query02();

    public Temployee getOneEmp(int id);

    public int updOneEmp(Temployee temployee);

    public Temployee getMoneyById(int id);

    public List<Temployee> query03(@Param("start") int start, @Param("end") int end);

    //按照id查职位
    public Temployee getPosId(int posId);

    //按照职位id查员工
    public List<Temployee> getByTemp(int posId);

    //按照职称id查员工
    public List<Temployee> getByjobLevelId(int jobLevelId);

    List<Temployee> gaoquery(String name, int politicId, int nationId, int departmentId, int jobLevelId, int posId, String engageForm, int start, int end);

    long gaoqueryCount(String name, int politicId, int nationId, int departmentId, int jobLevelId, int posId, String engageForm);
}
