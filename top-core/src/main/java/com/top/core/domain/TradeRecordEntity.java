package com.top.core.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Wang Lei.
 * Date on 2015/2/2
 * Time 17:22
 * TODO
 */
@Entity
@Table(name = "trade_record")
public class TradeRecordEntity {

    @Id
    private String id;

    @Column(name = "trade_number", nullable = false, insertable = true, updatable = true, length = 255)
    private String tradeNumber;

    @Basic
    @Column(name = "out_trade_no", nullable = true, insertable = true, updatable = true, length = 255)
    private String outTradeNo;

    @Basic
    @Column(name = "notifyTime", nullable = true, insertable = true, updatable = true)
    private Timestamp notifyTime;

    @Basic
    @Column(name = "createTime", nullable = true, insertable = true, updatable = true)
    private Timestamp createTime;

    @Basic
    @Column(name = "total_fee", nullable = true, insertable = true, updatable = true, precision = 2)
    private BigDecimal totalFee;

    @Basic
    @Column(name = "result", nullable = true, insertable = true, updatable = true, length = 255)
    private String result;

    @Basic
    @Column(name = "buyer_id", nullable = true, insertable = true, updatable = true, length = 255)
    private String buyerId;

    @Basic
    @Column(name = "subject", nullable = true, insertable = true, updatable = true, length = 255)
    private String subject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTradeNumber() {
        return tradeNumber;
    }

    public void setTradeNumber(String tradeNumber) {
        this.tradeNumber = tradeNumber;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Timestamp getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(Timestamp notifyTime) {
        this.notifyTime = notifyTime;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
