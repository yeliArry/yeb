package com.hdax.yeb.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 政治面貌
 */

@TableName("t_politics_status")
public class TpoliticsStatus {
    @TableField("id")
    private int id;//编号
    @TableField("name")
    @Excel(name = "政治面貌")
    private String name;//名称

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
