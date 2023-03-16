package com.hdax.yeb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("tem_ec")
public class Tem_ec {
    @TableField("id")
    private int id;//编号
    @TableField("eid")
    private int eid;//员工编号
    @TableField("ecDate")
    private String ecDate;//奖罚日期
    @TableField("ecReason")
    private String ecReason;//奖罚原因
    @TableField("ecPoint")
    private int ecPoint;//奖罚分
    @TableField("ecType")
    private int ecType;//奖罚类别
    @TableField("remark")
    private String remark;//备注
    @TableField(exist = false)
    private Temployee temployee;//外键  员工名称
    @TableField("state")
    private int state;//奖惩类型：0通过1未通过
    @TableField("result")
    private int result;
    private int bossstate;//人员审批1boss 2 经理

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

    public String getEcDate() {
        return ecDate;
    }

    public void setEcDate(String ecDate) {
        this.ecDate = ecDate;
    }

    public String getEcReason() {
        return ecReason;
    }

    public void setEcReason(String ecReason) {
        this.ecReason = ecReason;
    }

    public int getEcPoint() {
        return ecPoint;
    }

    public void setEcPoint(int ecPoint) {
        this.ecPoint = ecPoint;
    }

    public int getEcType() {
        return ecType;
    }

    public void setEcType(int ecType) {
        this.ecType = ecType;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
