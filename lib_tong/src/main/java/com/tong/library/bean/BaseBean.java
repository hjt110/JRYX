package com.tong.library.bean;

public class BaseBean {

    /**
     * code : 0
     * msg : 短信发送成功
     * data : {"smsid":"OG_SMSZDk0MzYzMDc0YmUwZjRjZjI3YWY5ZGYxOTRlM2MzY2M=","type":"login"}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * smsid : OG_SMSZDk0MzYzMDc0YmUwZjRjZjI3YWY5ZGYxOTRlM2MzY2M=
         * type : login
         */

        private String smsid;
        private String type;
        private String token;
        private String username;
        private String sex;
        private String headpic;
        private String mobile;
        private String signature;
        private String birthday_time;
        private String birthday_date;
        private String province;
        private String city;
        private String town;
        private String dynamicnum;
        private String follownum;
        private String fansnum;


        public String getSmsid() {
            return smsid;
        }

        public void setSmsid(String smsid) {
            this.smsid = smsid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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
    }
}
