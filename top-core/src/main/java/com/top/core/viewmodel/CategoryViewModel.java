package com.top.core.viewmodel;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/11
 * Time: 17:22
 * <p>
 * TODO
 */
public class CategoryViewModel {

    private int id;
    private Integer parentId;
    private String name;
    private Integer type;
    private Float studyHours;
    private Integer studyUnit;

    private String classDescr;
    private String majorDescr;
    private String subject;
    private BigDecimal entryFee;
    private BigDecimal examFee;
    private BigDecimal tuitionFee;
    private BigDecimal bookFee;
    private BigDecimal price;

    private Integer payMethod;
    private Integer integralVal;
    private Integer integralSwitch;
    private String startDate;
    private String endDate;
    private String createTime;
    private String updateTime;
    private Integer deleted;
    private Integer studyMethod;
    private Integer leaf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getStudyHours() {
        return studyHours;
    }

    public void setStudyHours(Float studyHours) {
        this.studyHours = studyHours;
    }

    public Integer getStudyUnit() {
        return studyUnit;
    }

    public void setStudyUnit(Integer studyUnit) {
        this.studyUnit = studyUnit;
    }

    public String getClassDescr() {
        return classDescr;
    }

    public void setClassDescr(String classDescr) {
        this.classDescr = classDescr;
    }

    public String getMajorDescr() {
        return majorDescr;
    }

    public void setMajorDescr(String majorDescr) {
        this.majorDescr = majorDescr;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public BigDecimal getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(BigDecimal entryFee) {
        this.entryFee = entryFee;
    }

    public BigDecimal getExamFee() {
        return examFee;
    }

    public void setExamFee(BigDecimal examFee) {
        this.examFee = examFee;
    }

    public BigDecimal getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(BigDecimal tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public BigDecimal getBookFee() {
        return bookFee;
    }

    public void setBookFee(BigDecimal bookFee) {
        this.bookFee = bookFee;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getIntegralVal() {
        return integralVal;
    }

    public void setIntegralVal(Integer integralVal) {
        this.integralVal = integralVal;
    }

    public Integer getIntegralSwitch() {
        return integralSwitch;
    }

    public void setIntegralSwitch(Integer integralSwitch) {
        this.integralSwitch = integralSwitch;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getStudyMethod() {
        return studyMethod;
    }

    public void setStudyMethod(Integer studyMethod) {
        this.studyMethod = studyMethod;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }
}
