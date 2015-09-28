package com.top.core.domain;

import com.top.core.utils.TimestampConverter;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/12
 * Time: 10:59
 * <p>
 */
@Entity
@Table(name = "tb_project")
public class ProjectEntity {

	/** 学历提升 */
	public static final int cat_xlts = 1;

	/** 会计培训 */
	public static final int cat_kjpx = 2;

	/** 技能培训 */
	public static final int cat_jnpx = 3;

	/** 会计培训 */
	public static final int cat_sypx = 4;

	/** 银行证书 */
	public static final int cat_yhzs = 5;

	/** 期货证书 */
	public static final int cat_qhzs = 6;

	/** 证券证书 */
	public static final int cat_zqzs = 7;

	/** 少儿培训 */
	public static final int cat_sepx = 8;

	public static final int DEL_DELETED =2;

	public static final int DEL_NORMAL =1;


	private int id;

	@Column
	private String name;

	private int type;

	private Integer studyUnit;

	private BigDecimal studyDuration;

	private String majorDesc;

	private BigDecimal entryFee;

	private BigDecimal examFee;

	private BigDecimal tuitionFee;

	private BigDecimal bookFee;

	private BigDecimal totalFee;

	private Integer payMethod;

	private DateTime startDate;

	private String enrolment;

	private DateTime endDate;

	private DateTime createTime;

	private DateTime updateTime;

	private Integer deleted;

	private Integer studyMethod;

	Integer levelId;

	Integer schoolId;

	Integer majorId;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	@Column(name = "level_id")
	public Integer getLevelId() {

		return levelId;
	}

	public void setLevelId(Integer levelId) {

		this.levelId = levelId;
	}

	@Column(name = "school_id")
	public Integer getSchoolId() {

		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {

		this.schoolId = schoolId;
	}

	@Column(name = "specialty_id")
	public Integer getMajorId() {

		return majorId;
	}

	public void setMajorId(Integer majorId) {

		this.majorId = majorId;
	}

	@Id
	@Column(name = "id")
	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	@Column(name = "type")
	public int getType() {

		return type;
	}

	public void setType(int type) {

		this.type = type;
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
	@Column(name = "study_duration")
	public BigDecimal getStudyDuration() {

		return studyDuration;
	}

	public void setStudyDuration(BigDecimal studyDuration) {

		this.studyDuration = studyDuration;
	}

	@Basic
	@Column(name = "major_desc")
	public String getMajorDesc() {

		return majorDesc;
	}

	public void setMajorDesc(String majorDescr) {

		this.majorDesc = majorDescr;
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
	@Column(name = "total_fee")
	public BigDecimal getTotalFee() {

		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {

		this.totalFee = totalFee;
	}


	@Basic
	@Column(name = "pay_method")
	public Integer getPayMethod() {

		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {

		this.payMethod = payMethod;
	}

	@Column(name = "start_date")
	@Convert(converter = TimestampConverter.class)
	public DateTime getStartDate() {

		return startDate;
	}

	public void setStartDate(DateTime startDate) {

		this.startDate = startDate;
	}

	@Basic
	@Column(name = "enrolment")
	public String getEnrolment() {

		return enrolment;
	}

	public void setEnrolment(String enrolment) {

		this.enrolment = enrolment;
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

}
