package com.top.core.viewmodel;

import org.joda.time.DateTime;

/**
 * Created by IntelliJ IDEA.
 * User: MaYewei
 * Date: 2015/4/13 0013
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 */
public class UserViewModel {
    private Integer id;
    private String mobile;
    private String password;
    private String name;
    private char gender;
    private String idCard;
    private String referrerMobile;
    private String industry;
    private Integer availableCredits;
    private Integer freezeCredits;
    private String registerDate;
    private String proxy;
    private String weChat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getReferrerMobile() {
        return referrerMobile;
    }

    public void setReferrerMobile(String referrerMobile) {
        this.referrerMobile = referrerMobile;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Integer getAvailableCredits() {
        return availableCredits;
    }

    public void setAvailableCredits(Integer availableCredits) {
        this.availableCredits = availableCredits;
    }

    public Integer getFreezeCredits() {
        return freezeCredits;
    }

    public void setFreezeCredits(Integer freezeCredits) {
        this.freezeCredits = freezeCredits;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }
}
