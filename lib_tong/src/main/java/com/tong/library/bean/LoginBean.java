package com.tong.library.bean;

public class LoginBean {

    /**
     * code : 0
     * msg : 登录成功
     * data : {"token":"c7e0dac1d6fc450ea081739b45afb13b","username":"18065921051","sex":0,"headpic":"http://127.0.0.1/yx/data/upload/member/default/headicon.png","mobile":"18065921051","signature":null,"birthday_time":0,"birthday_date":"1970-01-01","province":null,"city":null,"town":null,"dynamicnum":0,"follownum":0,"fansnum":0}
     */

    private String code;
    private String msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
         * token : c7e0dac1d6fc450ea081739b45afb13b
         * username : 18065921051
         * sex : 0
         * headpic : http://127.0.0.1/yx/data/upload/member/default/headicon.png
         * mobile : 18065921051
         * signature : null
         * birthday_time : 0
         * birthday_date : 1970-01-01
         * province : null
         * city : null
         * town : null
         * dynamicnum : 0
         * follownum : 0
         * fansnum : 0
         */

        private String token;
        private String username;
        private int sex;
        private String headpic;
        private String mobile;
        private String signature;
        private int birthday_time;
        private String birthday_date;
        private String province;
        private String city;
        private String town;
        private int dynamicnum;
        private int follownum;
        private int fansnum;

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

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getHeadpic() {
            return headpic;
        }

        public void setHeadpic(String headpic) {
            this.headpic = "";
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

        public int getBirthday_time() {
            return birthday_time;
        }

        public void setBirthday_time(int birthday_time) {
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

        public int getDynamicnum() {
            return dynamicnum;
        }

        public void setDynamicnum(int dynamicnum) {
            this.dynamicnum = dynamicnum;
        }

        public int getFollownum() {
            return follownum;
        }

        public void setFollownum(int follownum) {
            this.follownum = follownum;
        }

        public int getFansnum() {
            return fansnum;
        }

        public void setFansnum(int fansnum) {
            this.fansnum = fansnum;
        }
    }
}
