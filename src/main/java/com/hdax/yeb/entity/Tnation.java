package com.hdax.yeb.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 民族表
 */

@TableName("t_nation")
public class Tnation {
    @TableField("id")
    private int id;//编号
    @TableField("name")
    @Excel(name = "民族")
    private String name;//民族名称

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
}
