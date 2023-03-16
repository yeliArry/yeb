package com.hdax.yeb.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("t_admin")
public class Tadmin {
    @TableField("id")
    private int id;
    @TableField("name")
    private String name;
    @TableField("phone")
    private String phone;
    @TableField("telephone")
    private String telephone;
    @TableField("address")
    private String address;
    @TableField("enabled")
    private int enabled;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("userFace")
    private String userFace;
    @TableField("remark")
    private String remark;

    @TableField(exist = false)
    private Toplog toplog;//操作员

    @TableField(exist = false)
    private TadminRole tadminRole;//用户角色表
    @TableField(exist = false)
    private Trole trole;//角色表

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Toplog getToplog() {
        return toplog;
    }

    public void setToplog(Toplog toplog) {
        this.toplog = toplog;
    }

    public TadminRole getTadminRole() {
        return tadminRole;
    }

    public void setTadminRole(TadminRole tadminRole) {
        this.tadminRole = tadminRole;
    }

    public Trole getTrole() {
        return trole;
    }

    public void setTrole(Trole trole) {
        this.trole = trole;
    }
}
