package com.tong.library.bean;

public class GoodBean {

    /**
     * code : 0
     * msg : 点赞成功
     * data : {"count":1,"dolikestype":1}
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
         * dolikestype : 1
         */

        private int count;
        private int dolikestype;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getDolikestype() {
            return dolikestype;
        }

        public void setDolikestype(int dolikestype) {
            this.dolikestype = dolikestype;
        }
    }
}
