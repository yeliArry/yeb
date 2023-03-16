package com.hdax.yeb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 调动审批表
 */
@TableName("tem_remove")

public class TemRemove {
    @TableField("id")
    private int id;//编号
    @TableField("eid")
    private int eid;//员工id
    @TableField("afterDepId")
    private int afterDepId;//调动部门id
    @TableField("afterJobId")
    private int afterJobId;//调动职位id
    @TableField("removeDate")
    private String removeDate;//调动时间
    @TableField("reason")
    private String reason;//调动原因
    @TableField("state")
    private int state;//状态
    @TableField("result")
    private int result;//结果

    @TableField(exist = false)
    private Temployee temployee;//员工外键
    @TableField(exist = false)
    private Tdepartment tdepartment;//部门外键
    @TableField(exist = false)
    private Tposition tposition;//职位外键

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

    public int getAfterDepId() {
        return afterDepId;
    }

    public void setAfterDepId(int afterDepId) {
        this.afterDepId = afterDepId;
    }

    public int getAfterJobId() {
        return afterJobId;
    }

    public void setAfterJobId(int afterJobId) {
        this.afterJobId = afterJobId;
    }

    public String getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(String removeDate) {
        this.removeDate = removeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public Temployee getTemployee() {
        return temployee;
    }

    public void setTemployee(Temployee temployee) {
        this.temployee = temployee;
    }

    public Tdepartment getTdepartment() {
        return tdepartment;
    }

    public void setTdepartment(Tdepartment tdepartment) {
        this.tdepartment = tdepartment;
    }

    public Tposition getTposition() {
        return tposition;
    }

    public void setTposition(Tposition tposition) {
        this.tposition = tposition;
    }
}
