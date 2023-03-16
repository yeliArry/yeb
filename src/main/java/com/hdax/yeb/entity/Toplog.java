package com.hdax.yeb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 操作员
 */

@TableName("t_oplog")
public class Toplog {
    @TableField("id")
    private int id;//编号
    @TableField("addDate")
    private String addDate;//添加日期
    @TableField("operate")
    private String operate;//操作内容
    @TableField("adminid")
    private int adminid;//操作员ID

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

//    @TableField(exist = false)
//    private Tadmin tadmin;
}
