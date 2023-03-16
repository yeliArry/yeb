package com.hdax.yeb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("application")
public class Application {
    @TableField("id")
    private int id;//编号
    @TableField("eid")
    private int eid;//员工编号外键
    @TableField(exist = false)
    private Temployee temployee;
    @TableField("lavetype")
    private String lavetype;//请假类型
    @TableField("applicatdate")
    private String applicatdate;//申请日期
    @TableField("leavebegindate")
    private String leavebegindate;//开始日期
    @TableField("leaveenddate")
    private String leaveenddate;//结束日期
    @TableField("duration")
    private int duration;//请假时长
    @TableField("phone")
    private String phone;
    @TableField("state")
    private int state;//请假状态
    @TableField("auditresults")
    private int auditresults;//处理结果
    @TableField("lavedesc")
    private String lavedesc;//请假原因

    private int bossstate;//审批人员

    public int getBossstate() {
        return bossstate;
    }

    public void setBossstate(int bossstate) {
        this.bossstate = bossstate;
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

    public Temployee getTemployee() {
        return temployee;
    }

    public void setTemployee(Temployee temployee) {
        this.temployee = temployee;
    }

    public String getLavetype() {
        return lavetype;
    }

    public void setLavetype(String lavetype) {
        this.lavetype = lavetype;
    }

    public String getApplicatdate() {
        return applicatdate;
    }

    public void setApplicatdate(String applicatdate) {
        this.applicatdate = applicatdate;
    }

    public String getLeavebegindate() {
        return leavebegindate;
    }

    public void setLeavebegindate(String leavebegindate) {
        this.leavebegindate = leavebegindate;
    }

    public String getLeaveenddate() {
        return leaveenddate;
    }

    public void setLeaveenddate(String leaveenddate) {
        this.leaveenddate = leaveenddate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getAuditresults() {
        return auditresults;
    }

    public void setAuditresults(int auditresults) {
        this.auditresults = auditresults;
    }

    public String getLavedesc() {
        return lavedesc;
    }

    public void setLavedesc(String lavedesc) {
        this.lavedesc = lavedesc;
    }
}
