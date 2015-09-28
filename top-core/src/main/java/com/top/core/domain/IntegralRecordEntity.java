package com.top.core.domain;

import com.top.core.utils.TimestampConverter;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/15
 * Time: 13:36
 * <p>
 * TODO
 */
@Entity
@Table(name = "integral_record")
public class IntegralRecordEntity {

    private Integer id;
    private Integer tradingCapacity;
    private String outTradeNo;
    private Integer integralBefore;
    private Integer integralBehind;
    private String description;
    private int userId;
    private DateTime createTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "trading_capacity")
    public Integer getTradingCapacity() {
        return tradingCapacity;
    }

    public void setTradingCapacity(Integer tradingCapacity) {
        this.tradingCapacity = tradingCapacity;
    }


    @Basic
    @Column(name = "out_trade_no")
    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }


    @Basic
    @Column(name = "integral_before")
    public Integer getIntegralBefore() {
        return integralBefore;
    }

    public void setIntegralBefore(Integer integralBefore) {
        this.integralBefore = integralBefore;
    }


    @Basic
    @Column(name = "integral_behind")
    public Integer getIntegralBehind() {
        return integralBehind;
    }

    public void setIntegralBehind(Integer integralBehind) {
        this.integralBehind = integralBehind;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Basic
    @Column(name = "createTime")
    @Convert(converter = TimestampConverter.class)
    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
