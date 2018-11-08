package com.wangou.jinriyixing.db.account;

import com.tong.library.bean.RegisterBean;
import com.wangou.jinriyixing.db.bean.User;
import com.wangou.jinriyixing.db.helper.UserDBHelper;

public class UserAccount {

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

    private static UserAccount mInstance;
    private User userInfo;

    public UserAccount() {
        userInfo = UserDBHelper.getInstance().getUserInfo();
        if (userInfo == null) {
            userInfo = new User();
        }
    }

    public static UserAccount getInstance() {
        if (mInstance == null) {
            synchronized (UserAccount.class) {
                mInstance = new UserAccount();
            }
        }
        return mInstance;
    }

    public void init() {
        setToken(userInfo.getToken());
        setUsername(userInfo.getUsername());
        setSex(userInfo.getSex());
        setHeadpic(userInfo.getHeadpic());
        setMobile(userInfo.getMobile());
        setSignature(userInfo.getSignature());
        setBirthday_time(userInfo.getBirthday_time());
        setBirthday_date(userInfo.getBirthday_date());
        setProvince(userInfo.getProvince());
        setCity(userInfo.getCity());
        setTown(userInfo.getTown());
        setDynamicnum(userInfo.getDynamicnum());
        setFollownum(userInfo.getFollownum());
        setFansnum(userInfo.getFansnum());
    }

    public void save(RegisterBean.DataBean bean) {
        userInfo.setToken(bean.getToken() == null ? "" : bean.getToken());
        userInfo.setUsername(bean.getUsername() == null ? "" : bean.getUsername());
        userInfo.setSex(bean.getSex() + "");
        userInfo.setHeadpic(bean.getHeadpic() == null ? "" : bean.getHeadpic());
        userInfo.setMobile(bean.getMobile() == null ? "" : bean.getMobile());
        userInfo.setSignature(bean.getSignature() == null ? "" : bean.getSignature());
        userInfo.setBirthday_time(bean.getBirthday_time() + "");
        userInfo.setBirthday_date(bean.getBirthday_date());
        userInfo.setProvince(bean.getProvince() == null ? "" : bean.getProvince());
        userInfo.setCity(bean.getCity() == null ? "" : bean.getCity());
        userInfo.setTown(bean.getTown() == null ? "" : bean.getTown());
        userInfo.setDynamicnum(bean.getDynamicnum() + "");
        userInfo.setFollownum(bean.getFollownum() + "");
        userInfo.setFansnum(bean.getFansnum() + "");
        UserDBHelper.getInstance().updateUserInfo(userInfo);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getBirthday_time() {
        return birthday_time;
    }

    public void setBirthday_time(String birthday_time) {
        this.birthday_time = birthday_time;
    }

    public String getBirthday_date() {
        return birthday_date;
    }

    public void setBirthday_date(String birthday_date) {
        this.birthday_date = birthday_date;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDynamicnum() {
        return dynamicnum;
    }

    public void setDynamicnum(String dynamicnum) {
        this.dynamicnum = dynamicnum;
    }

    public String getFollownum() {
        return follownum;
    }

    public void setFollownum(String follownum) {
        this.follownum = follownum;
    }

    public String getFansnum() {
        return fansnum;
    }

    public void setFansnum(String fansnum) {
        this.fansnum = fansnum;
    }

    public static UserAccount getmInstance() {
        return mInstance;
    }

    public static void setmInstance(UserAccount mInstance) {
        UserAccount.mInstance = mInstance;
    }

    public User getUserInfo() {
        return userInfo;
    }
}
