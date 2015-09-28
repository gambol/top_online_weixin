package com.top.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.top.core.utils.TimestampConverter;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/12
 * Time: 10:59
 * <p>
 * TODO
 */
@Entity
@Table(name = "tb_school")
public class SchoolEntity {
    private int id;
    private String name;
    private DateTime createTime;
    private DateTime updateTime;
    private Integer status;
    private String description;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "create_time")
    @Convert(converter = TimestampConverter.class)
    @JsonIgnore
    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    @Convert(converter = TimestampConverter.class)
    @JsonIgnore
    public DateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(DateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
