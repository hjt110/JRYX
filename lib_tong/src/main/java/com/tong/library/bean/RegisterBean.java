package com.tong.library.bean;

public class RegisterBean {

    /**
     * code : 0
     * msg : 注册成功
     * data : {"token":"9cd74939a5edea8be574384337d20ac7","username":"18065921051","sex":0,"headpic":"http://127.0.0.1/yx/data/upload/member/default/headicon.png","mobile":"18065921051","signature":null,"birthday_time":0,"birthday_date":"1970-01-01","province":null,"city":null,"town":null,"dynamicnum":0,"follownum":0,"fansnum":0}
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
         * token : 9cd74939a5edea8be574384337d20ac7
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
        private Object signature;
        private int birthday_time;
        private String birthday_date;
        private Object province;
        private Object city;
        private Object town;
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
            this.headpic = headpic;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getSignature() {
            return signature;
        }

        public void setSignature(Object signature) {
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

        public Object getProvince() {
            return province;
        }

        public void setProvince(Object province) {
            this.province = province;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public Object getTown() {
            return town;
        }

        public void setTown(Object town) {
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
