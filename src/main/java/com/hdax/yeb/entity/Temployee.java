package com.hdax.yeb.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

/**
 * 员工表
 */

@TableName("t_employee")

public class Temployee {
    @Excel(name = "编号", width = 40)
    @TableField("id")
    private int id;//编号
    @Excel(name = "员工姓名", width = 40)
    @TableField("name")
    private String name;//员工姓名
    @Excel(name = "员工性别", width = 40)
    @TableField("gender")
    private String gender;//员工性别
    @Excel(name = "出生日期", width = 40)
    @TableField("birthday")
    private String birthday;//出生日期
    @Excel(name = "身份证号", width = 40)
    @TableField("idCard")
    private String idCard;//身份证号
    @Excel(name = "婚姻状况", width = 40)
    @TableField("wedlock")
    private String wedlock;//婚姻状况
    @Excel(name = "民族id", width = 40)
    @TableField("nationId")
    private int nationId;//民族
    @Excel(name = "籍贯", width = 40)
    @TableField("nativePlace")
    private String nativePlace;//籍贯
    @Excel(name = "政治面貌id", width = 40)
    @TableField("politicId")
    private int politicId;//政治面貌
    @Excel(name = "邮件", width = 40)
    @TableField("email")
    private String email;//邮件
    @Excel(name = "电话号码", width = 40)
    @TableField("phone")
    private String phone;//电话号码
    @Excel(name = "联系地址", width = 40)
    @TableField("address")
    private String address;//联系地址
    @Excel(name = "部门id", width = 40)
    @TableField("departmentId")
    private int departmentId;//所属部门
    @Excel(name = "职称ID", width = 40)
    @TableField("jobLevelId")
    private int jobLevelId;//职称ID
    @Excel(name = "职位ID", width = 40)
    @TableField("posId")
    private int posId;//职位ID
    @Excel(name = "聘用形式", width = 40)
    @TableField("engageForm")
    private String engageForm;//聘用形式
    @Excel(name = "最高学历", width = 40)
    @TableField("tiptopDegree")
    private String tiptopDegree;//最高学历
    @Excel(name = "所属专业", width = 40)
    @TableField("specialty")
    private String specialty;//所属专业
    @Excel(name = "毕业院校", width = 40)
    @TableField("school")
    private String school;//毕业院校
    @Excel(name = "入职日期", width = 40)
    @TableField("beginDate")
    private String beginDate;//入职日期
    @Excel(name = "在职状态", width = 40)
    @TableField("workState")
    private String workState;//在职状态
    @Excel(name = "工号", width = 40)
    @TableField("workID")
    private String workID;//工号
    @Excel(name = "合同期限", width = 40)
    @TableField("contractTerm")
    private String contractTerm;//合同期限
    @Excel(name = "转正日期", width = 40)
    @TableField("conversionTime")
    private String conversionTime;//转正日期
    @Excel(name = "离职日期", width = 40)
    @TableField("notWorkDate")
    private String notWorkDate;//离职日期
    @Excel(name = "合同起始日期", width = 40)
    @TableField("beginContract")
    private String beginContract;//合同起始日期
    @Excel(name = "合同终止日期", width = 40)
    @TableField("endContract")
    private String endContract;//合同终止日期
    @Excel(name = "工龄", width = 40)
    @TableField("workAge")
    private int workAge;//工龄
    @Excel(name = "工资账套id", width = 40)
    @TableField("salaryId")
    private int salaryId;//工资账套ID

    @ExcelEntity(name = "工资套账")
    @TableField(exist = false)
    private Tsalary tsalary;//工资账套

    @ExcelEntity(name = "部门")
    @TableField(exist = false)
    private Tdepartment tdepartment;//部门

    @ExcelEntity(name = "职称")
    @TableField(exist = false)
    private Tjoblevel tjoblevel;//职称

    @ExcelEntity(name = "职位")
    @TableField(exist = false)
    private Tposition tposition;//职位

    @ExcelEntity(name = "民族")
    @TableField(exist = false)
    private Tnation tnation;//民族

    @ExcelEntity(name = "政治面貌")
    @TableField(exist = false)
    private TpoliticsStatus tpoliticsStatus;//政治面貌

    @TableField(exist = false)
    private TsalaryAdjust tsalaryAdjust;//员工调薪

    @TableField(exist = false)
    private List<Temployeeec> temployeeec;//奖惩

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getWedlock() {
        return wedlock;
    }

    public void setWedlock(String wedlock) {
        this.wedlock = wedlock;
    }

    public int getNationId() {
        return nationId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public int getPoliticId() {
        return politicId;
    }

    public void setPoliticId(int politicId) {
        this.politicId = politicId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getJobLevelId() {
        return jobLevelId;
    }

    public void setJobLevelId(int jobLevelId) {
        this.jobLevelId = jobLevelId;
    }

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }

    public String getEngageForm() {
        return engageForm;
    }

    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }

    public String getTiptopDegree() {
        return tiptopDegree;
    }

    public void setTiptopDegree(String tiptopDegree) {
        this.tiptopDegree = tiptopDegree;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public String getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(String contractTerm) {
        this.contractTerm = contractTerm;
    }

    public String getConversionTime() {
        return conversionTime;
    }

    public void setConversionTime(String conversionTime) {
        this.conversionTime = conversionTime;
    }

    public String getNotWorkDate() {
        return notWorkDate;
    }

    public void setNotWorkDate(String notWorkDate) {
        this.notWorkDate = notWorkDate;
    }

    public String getBeginContract() {
        return beginContract;
    }

    public void setBeginContract(String beginContract) {
        this.beginContract = beginContract;
    }

    public String getEndContract() {
        return endContract;
    }

    public void setEndContract(String endContract) {
        this.endContract = endContract;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public Tsalary getTsalary() {
        return tsalary;
    }

    public void setTsalary(Tsalary tsalary) {
        this.tsalary = tsalary;
    }

    public Tdepartment getTdepartment() {
        return tdepartment;
    }

    public void setTdepartment(Tdepartment tdepartment) {
        this.tdepartment = tdepartment;
    }

    public Tjoblevel getTjoblevel() {
        return tjoblevel;
    }

    public void setTjoblevel(Tjoblevel tjoblevel) {
        this.tjoblevel = tjoblevel;
    }

    public Tposition getTposition() {
        return tposition;
    }

    public void setTposition(Tposition tposition) {
        this.tposition = tposition;
    }

    public Tnation getTnation() {
        return tnation;
    }

    public void setTnation(Tnation tnation) {
        this.tnation = tnation;
    }

    public TpoliticsStatus getTpoliticsStatus() {
        return tpoliticsStatus;
    }

    public void setTpoliticsStatus(TpoliticsStatus tpoliticsStatus) {
        this.tpoliticsStatus = tpoliticsStatus;
    }

    public TsalaryAdjust getTsalaryAdjust() {
        return tsalaryAdjust;
    }

    public void setTsalaryAdjust(TsalaryAdjust tsalaryAdjust) {
        this.tsalaryAdjust = tsalaryAdjust;
    }

    public List<Temployeeec> getTemployeeec() {
        return temployeeec;
    }

    public void setTemployeeec(List<Temployeeec> temployeeec) {
        this.temployeeec = temployeeec;
    }
}
