package com.hdax.yeb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 员工调薪
 */

@TableName("t_salary_adjust")
public class TsalaryAdjust {
    @TableField("id")
    private int id;//编号
    @TableField("eid")
    private int eid;//员工编号
    @TableField("asDate")
    private String asDate;//调薪日期
    @TableField("beforeSalary")
    private int beforeSalary;//调前薪资
    @TableField("afterSalary")
    private int afterSalary;//调后薪资
    @TableField("reason")
    private String reason;//调薪原因
    @TableField("remark")
    private String remark;//备注

    @TableField(exist = false)
    private Temployee temployee;//员工名称
    @TableField("state")
    private int state;//调薪状态
    @TableField("salaryresults")
    private int salaryresults;//调薪结果

    public int getSalaryresults() {
        return salaryresults;
    }

    public void setSalaryresults(int salaryresults) {
        this.salaryresults = salaryresults;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getAsDate() {
        return asDate;
    }

    public void setAsDate(String asDate) {
        this.asDate = asDate;
    }

    public int getBeforeSalary() {
        return beforeSalary;
    }

    public void setBeforeSalary(int beforeSalary) {
        this.beforeSalary = beforeSalary;
    }

    public int getAfterSalary() {
        return afterSalary;
    }

    public void setAfterSalary(int afterSalary) {
        this.afterSalary = afterSalary;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Temployee getTemployee() {
        return temployee;
    }

    public void setTemployee(Temployee temployee) {
        this.temployee = temployee;
    }
}
