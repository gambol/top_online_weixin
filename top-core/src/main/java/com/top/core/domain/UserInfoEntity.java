package com.top.core.domain;

import com.top.core.utils.TimestampConverter;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Wang Lei
 * Date: 2015/6/9
 * Time: 11:45
 * <p>
 * TODO
 */
@Entity
@Table(name = "user")
public class UserInfoEntity {
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
    private DateTime registerDate;
    private String proxy;
    private String weChat;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "gender")
    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "id_card")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Basic
    @Column(name = "referrer_mobile")
    public String getReferrerMobile() {
        return referrerMobile;
    }

    public void setReferrerMobile(String referrerMobile) {
        this.referrerMobile = referrerMobile;
    }

    @Basic
    @Column(name = "industry")
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Basic
    @Column(name = "available_credits")
    public Integer getAvailableCredits() {
        return availableCredits;
    }

    public void setAvailableCredits(Integer availableCredits) {
        this.availableCredits = availableCredits;
    }

    @Basic
    @Column(name = "freeze_credits")
    public Integer getFreezeCredits() {
        return freezeCredits;
    }

    public void setFreezeCredits(Integer freezeCredits) {
        this.freezeCredits = freezeCredits;
    }

    @Basic
    @Column(name = "register_date")
    @Convert(converter = TimestampConverter.class)
    public DateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(DateTime registerDate) {
        this.registerDate = registerDate;
    }

    @Basic
    @Column(name = "proxy")
    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    @Basic
    @Column(name = "wechat")
    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }
}
