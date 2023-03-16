package com.hdax.yeb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 员工培训表
 */

@TableName("t_employee_train")
public class TemployeeTrain {
    @TableField("id")
    private int id;//编号
    @TableField("eid")
    private int eid;//员工编号
    @TableField("trainDate")
    private String trainDate;//培训日期
    @TableField("trainContent")
    private String trainContent;//培训内容
    @TableField("remark")
    private String remark;//备注

    @TableField(exist = false)
    private Temployee temployee;//员工姓名

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

    public String getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(String trainDate) {
        this.trainDate = trainDate;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
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
