package com.hdax.yeb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 员工调动表
 */

@TableName("t_employee_remove")
public class TemployeeRemove {
    @TableField("id")
    private int id;//编号
    @TableField("eid")
    private int eid;//员工编号
    @TableField("afterDepId")
    private int afterDepId;//调动后部门ID
    @TableField("afterJobId")
    private int afterJobId;//调动后职位ID
    @TableField("removeDate")
    private String removeDate;//调动日期
    @TableField("reason")
    private String reason;//调动原因
    @TableField("remark")
    private String remark;//备注

    @TableField(exist = false)
    private Temployee temployee;//员工姓名
    @TableField(exist = false)
    private Tdepartment tdepartment;//部门名称
    @TableField(exist = false)
    private Tposition tposition;//职位名称
    @TableField("state")
    private int state;//状态
    @TableField("result")
    private int result;//结果

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
