package com.top.core.domain;

import com.top.core.utils.TimestampConverter;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/11
 * Time: 9:34
 * <p>
 * TODO
 */
@Entity
@Table(name = "category")
@Deprecated
public class CategoryEntity {

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
    private DateTime startDate;
    private DateTime endDate;
    private DateTime createTime;
    private DateTime updateTime;
    private Integer deleted;
    private Integer studyMethod;
    private Integer leaf;


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parent_id")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    @Basic
    @Column(name = "study_hours")
    public Float getStudyHours() {
        return studyHours;
    }

    public void setStudyHours(Float studyHours) {
        this.studyHours = studyHours;
    }


    @Basic
    @Column(name = "study_unit")
    public Integer getStudyUnit() {
        return studyUnit;
    }

    public void setStudyUnit(Integer studyUnit) {
        this.studyUnit = studyUnit;
    }


    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Basic
    @Column(name = "class_descr")
    public String getClassDescr() {
        return classDescr;
    }

    public void setClassDescr(String classDescr) {
        this.classDescr = classDescr;
    }


    @Basic
    @Column(name = "major_descr")
    public String getMajorDescr() {
        return majorDescr;
    }

    public void setMajorDescr(String majorDescr) {
        this.majorDescr = majorDescr;
    }


    @Basic
    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "entry_fee")
    public BigDecimal getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(BigDecimal entryFee) {
        this.entryFee = entryFee;
    }

    @Basic
    @Column(name = "exam_fee")
    public BigDecimal getExamFee() {
        return examFee;
    }

    public void setExamFee(BigDecimal examFee) {
        this.examFee = examFee;
    }


    @Basic
    @Column(name = "tuition_fee")
    public BigDecimal getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(BigDecimal tuitionFee) {
        this.tuitionFee = tuitionFee;
    }


    @Basic
    @Column(name = "book_fee")
    public BigDecimal getBookFee() {
        return bookFee;
    }

    public void setBookFee(BigDecimal bookFee) {
        this.bookFee = bookFee;
    }


    @Basic
    @Column(name = "pay_method")
    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }


    @Basic
    @Column(name = "integral_val")
    public Integer getIntegralVal() {
        return integralVal;
    }

    public void setIntegralVal(Integer integralVal) {
        this.integralVal = integralVal;
    }


    @Basic
    @Column(name = "integral_switch")
    public Integer getIntegralSwitch() {
        return integralSwitch;
    }

    public void setIntegralSwitch(Integer integralSwitch) {
        this.integralSwitch = integralSwitch;
    }


    @Basic
    @Column(name = "start_date")
    @Convert(converter = TimestampConverter.class)
    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }


    @Basic
    @Column(name = "end_date")
    @Convert(converter = TimestampConverter.class)
    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }


    @Basic
    @Column(name = "create_time")
    @Convert(converter = TimestampConverter.class)
    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }


    @Basic
    @Column(name = "update_time")
    @Convert(converter = TimestampConverter.class)
    public DateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(DateTime updateTime) {
        this.updateTime = updateTime;
    }


    @Basic
    @Column(name = "deleted")
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }


    @Basic
    @Column(name = "study_method")
    public Integer getStudyMethod() {
        return studyMethod;
    }

    public void setStudyMethod(Integer studyMethod) {
        this.studyMethod = studyMethod;
    }


    @Basic
    @Column(name = "leaf")
    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

}
