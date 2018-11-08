package com.wangou.jinriyixing.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author hjt
 */
@Entity
public class User {
    @Id
    private Long id;
    private String token = "";
    private String username = "";
    private String sex = "";
    private String headpic = "";
    private String mobile = "";
    private String signature = "";
    private String birthday_time = "";
    private String birthday_date = "";
    private String province = "";
    private String city = "";
    private String town = "";
    private String dynamicnum = "";
    private String follownum = "";
    private String fansnum = "";

    @Generated(hash = 1444951129)
    public User(Long id, String token, String username, String sex, String headpic, String mobile, String signature, String birthday_time, String birthday_date, String province, String city, String town, String dynamicnum, String follownum, String fansnum) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.sex = sex;
        this.headpic = headpic;
        this.mobile = mobile;
        this.signature = signature;
        this.birthday_time = birthday_time;
        this.birthday_date = birthday_date;
        this.province = province;
        this.city = city;
        this.town = town;
        this.dynamicnum = dynamicnum;
        this.follownum = follownum;
        this.fansnum = fansnum;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadpic() {
        return this.headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getBirthday_time() {
        return this.birthday_time;
    }

    public void setBirthday_time(String birthday_time) {
        this.birthday_time = birthday_time;
    }

    public String getBirthday_date() {
        return this.birthday_date;
    }

    public void setBirthday_date(String birthday_date) {
        this.birthday_date = birthday_date;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDynamicnum() {
        return this.dynamicnum;
    }

    public void setDynamicnum(String dynamicnum) {
        this.dynamicnum = dynamicnum;
    }

    public String getFollownum() {
        return this.follownum;
    }

    public void setFollownum(String follownum) {
        this.follownum = follownum;
    }

    public String getFansnum() {
        return this.fansnum;
    }

    public void setFansnum(String fansnum) {
        this.fansnum = fansnum;
    }

}
