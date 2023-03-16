package com.hdax.yeb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 用户角色表
 */

@TableName("t_admin_role")
public class TadminRole {
    @TableField("id")
    private int id;//编号
    @TableField("adminId")
    private int adminId;//用户id
    @TableField("rid")
    private int rid;//角色id

//    @TableField(exist = false)
//    private Tadmin tadmin;//用户表
//    @TableField(exist = false)
//    private Trole trole;//角色表

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
