package com.tong.library.bean;

public class FollowBean {

    /**
     * code : 0
     * msg : 关注成功
     * data : {"count":1,"count2":9,"followstype":1}
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
         * count : 1
         * count2 : 9
         * followstype : 1
         */

        private int count;
        private int count2;
        private int followstype;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCount2() {
            return count2;
        }

        public void setCount2(int count2) {
            this.count2 = count2;
        }

        public int getFollowstype() {
            return followstype;
        }

        public void setFollowstype(int followstype) {
            this.followstype = followstype;
        }
    }
}
