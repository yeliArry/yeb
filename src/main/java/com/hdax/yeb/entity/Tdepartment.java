package com.hdax.yeb.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 部门表
 */
@EqualsAndHashCode(callSuper = false, of = "name")
@TableName("t_department")

public class Tdepartment {
    @TableField("id")
    private int id;//编号
    @TableField("name")
    @Excel(name = "部门")
    private String name;//部门名称
    @TableField("parentId")
    private int parentId;//父ID
    @TableField("depPath")
    private String depPath;//路径
    @TableField("enabled")
    private int enabled;//是否启动
    @TableField("isParent")
    private String isParent;//是否启动上级

    private int salaryId;//工资账套ID
    @TableField(exist = false)
    private Tsalary tsalary;
    @TableField(exist = false)
    private List<Tdepartment> children;
    @TableField(exist = false)
    private Integer result;//存储过程

    public Tsalary getTsalary() {
        return tsalary;
    }

    public void setTsalary(Tsalary tsalary) {
        this.tsalary = tsalary;
    }

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getDepPath() {
        return depPath;
    }

    public void setDepPath(String depPath) {
        this.depPath = depPath;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    public List<Tdepartment> getChildren() {
        return children;
    }

    public void setChildren(List<Tdepartment> children) {
        this.children = children;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
