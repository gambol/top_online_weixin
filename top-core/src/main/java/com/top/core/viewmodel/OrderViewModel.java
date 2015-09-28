package com.top.core.viewmodel;


import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/11
 * Time: 9:28
 * <p>
 * TODO
 */
public class OrderViewModel {


    private String orderNumber;
    private Integer userId;
    private Integer projectId;
    private String category;
    private String buyerId;
    private String createTime;
    private String notifyTime;
    private String description;
    private String payId;
    private Integer payType;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String referrer;
    private String proxyIdcard;
    private String proxyMobile;
    private String proxyName;
    private String specialId;
    private String specialType;
    private Integer status;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(String notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getProxyIdcard() {
        return proxyIdcard;
    }

    public void setProxyIdcard(String proxyIdcard) {
        this.proxyIdcard = proxyIdcard;
    }

    public String getProxyMobile() {
        return proxyMobile;
    }

    public void setProxyMobile(String proxyMobile) {
        this.proxyMobile = proxyMobile;
    }

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    public String getSpecialId() {
        return specialId;
    }

    public void setSpecialId(String specialId) {
        this.specialId = specialId;
    }

    public String getSpecialType() {
        return specialType;
    }

    public void setSpecialType(String specialType) {
        this.specialType = specialType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
