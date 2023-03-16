package com.hdax.yeb.entity;

import com.baomidou.mybatisplus.annotation.TableField;

public class T_salary_approval {
    private int id;//编号
    private int eid;//员工ID
    private String aasDate;//调薪日期
    private int abeforeSalary;//调钱薪资
    private int aafterSalary;//调后薪资
    private String areason;//调薪原因
    private String aremark;//备注
    private int astate;//调薪状态
    private int asalaryresults;//调薪结果
    @TableField(exist = false)
    private Temployee temployee;

    public Temployee getTemployee() {
        return temployee;
    }

    public void setTemployee(Temployee temployee) {
        this.temployee = temployee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getAasDate() {
        return aasDate;
    }

    public void setAasDate(String aasDate) {
        this.aasDate = aasDate;
    }

    public int getAbeforeSalary() {
        return abeforeSalary;
    }

    public void setAbeforeSalary(int abeforeSalary) {
        this.abeforeSalary = abeforeSalary;
    }

    public int getAafterSalary() {
        return aafterSalary;
    }

    public void setAafterSalary(int aafterSalary) {
        this.aafterSalary = aafterSalary;
    }

    public String getAreason() {
        return areason;
    }

    public void setAreason(String areason) {
        this.areason = areason;
    }

    public String getAremark() {
        return aremark;
    }

    public void setAremark(String aremark) {
        this.aremark = aremark;
    }

    public int getAstate() {
        return astate;
    }

    public void setAstate(int astate) {
        this.astate = astate;
    }

    public int getAsalaryresults() {
        return asalaryresults;
    }

    public void setAsalaryresults(int asalaryresults) {
        this.asalaryresults = asalaryresults;
    }
}
