package com.hdax.yeb.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * 职位表
 */

@TableName("t_position")
public class Tposition {
    @TableField("id")
    private int id;//编号
    @TableField("name")
    @Excel(name = "职位")
    private String name;//职位
    @TableField("createDate")
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    //@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private String createDate;//创建时间
    @TableField("enabled")
    private int enabled;//是否启用

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
