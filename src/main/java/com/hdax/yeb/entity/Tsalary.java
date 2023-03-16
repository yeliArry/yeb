package com.hdax.yeb.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 工资账套
 */

@TableName("t_salary")
public class Tsalary {
    @TableField("id")
    private int id;//编号
    @TableField("basicSalary")
    private int basicSalary;//基本工资
    @TableField("bonus")
    private int bonus;//奖金
    @TableField("lunchSalary")
    private int lunchSalary;//午餐补助
    @TableField("trafficSalary")
    private int trafficSalary;//交通补助
    @TableField("allSalary")
    private int allSalary;//应发工资
    @TableField("pensionBase")
    private int pensionBase;//养老金基数
    @TableField("pensionPer")
    private float pensionPer;//养老金比率
    @TableField("createDate")
    private String createDate;//启用时间
    @TableField("medicalBase")
    private int medicalBase;//医疗基数
    @TableField("medicalPer")
    private float medicalPer;//医疗保险比率
    @TableField("accumulationFundBase")
    private int accumulationFundBase;//公积金基数
    @TableField("accumulationFundPer")
    private float accumulationFundPer;//公积金比率
    @TableField("name")
    @Excel(name = "工资账套")
    private String name;//名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getLunchSalary() {
        return lunchSalary;
    }

    public void setLunchSalary(int lunchSalary) {
        this.lunchSalary = lunchSalary;
    }

    public int getTrafficSalary() {
        return trafficSalary;
    }

    public void setTrafficSalary(int trafficSalary) {
        this.trafficSalary = trafficSalary;
    }

    public int getAllSalary() {
        return allSalary;
    }

    public void setAllSalary(int allSalary) {
        this.allSalary = allSalary;
    }

    public int getPensionBase() {
        return pensionBase;
    }

    public void setPensionBase(int pensionBase) {
        this.pensionBase = pensionBase;
    }

    public float getPensionPer() {
        return pensionPer;
    }

    public void setPensionPer(float pensionPer) {
        this.pensionPer = pensionPer;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getMedicalBase() {
        return medicalBase;
    }

    public void setMedicalBase(int medicalBase) {
        this.medicalBase = medicalBase;
    }

    public float getMedicalPer() {
        return medicalPer;
    }

    public void setMedicalPer(float medicalPer) {
        this.medicalPer = medicalPer;
    }

    public int getAccumulationFundBase() {
        return accumulationFundBase;
    }

    public void setAccumulationFundBase(int accumulationFundBase) {
        this.accumulationFundBase = accumulationFundBase;
    }

    public float getAccumulationFundPer() {
        return accumulationFundPer;
    }

    public void setAccumulationFundPer(float accumulationFundPer) {
        this.accumulationFundPer = accumulationFundPer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
