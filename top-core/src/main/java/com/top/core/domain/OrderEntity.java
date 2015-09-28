package com.top.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.top.core.utils.TimestampConverter;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/11
 * Time: 9:28
 * <p>
 * TODO
 */
@Entity
@Table(name = "tb_order")
public class OrderEntity {

    /**
     * 已取消
     */
    public final static int STATUS_CANCEL = -1;

    /**
     * 已创建(待支付)
     */
    public final static int STATUS_CREATE = 0;

    /**
     * 支付成功
     */
    public final static int STATUS_PAY_OK = 1;

    /**
     * 线下支付
     */
    public final static int STATUS_OFFLINE_PAY = 2;

    /**
     * 已退款
     */
    public final static int STATUS_REFUND = 3;


    private String orderNumber;
    private Integer userId;
    private Integer projectId;
    private String category;
    private String buyerId;
    private DateTime createTime;
    private DateTime notifyTime;
    private String description;
    private String payId;
    private Integer payType;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String referrer;
    private String proxyIdcard;
    private String proxyMobile;
    private String proxyName;
    private Integer pay_full;
    private BigDecimal integral;
    private Integer status;

    @Id
    @Column(name = "order_number")
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column
    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column
    @Lob
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "buyerId")
    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
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
    @Column(name = "notify_time")
    @Convert(converter = TimestampConverter.class)
    public DateTime getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(DateTime notifyTime) {
        this.notifyTime = notifyTime;
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
    @Column(name = "payId")
    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    @Basic
    @Column(name = "pay_type")
    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
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
    @Column(name = "totalPrice")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column
    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    @Basic
    @Column(name = "proxy_idcard")
    public String getProxyIdcard() {
        return proxyIdcard;
    }

    public void setProxyIdcard(String proxyIdcard) {
        this.proxyIdcard = proxyIdcard;
    }

    @Basic
    @Column(name = "proxy_mobile")
    public String getProxyMobile() {
        return proxyMobile;
    }

    public void setProxyMobile(String proxyMobile) {
        this.proxyMobile = proxyMobile;
    }

    @Basic
    @Column(name = "proxy_name")
    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }


    @Basic
    @Column(name = "pay_full")
    public Integer getPay_full() {
        return pay_full;
    }

    public void setPay_full(Integer pay_full) {
        this.pay_full = pay_full;
    }

    @Basic
    @Column(name = "integral")
    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
