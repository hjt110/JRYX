package com.tong.library.bean;

import java.util.List;

public class CollectionTitleBean {

    /**
     * code : 0
     * msg : 操作成功
     * data : [{"vmid":9,"name":"书法"},{"vmid":13,"name":"摄影"},{"vmid":14,"name":"美术"},{"vmid":15,"name":"竞答"},{"vmid":18,"name":"楹联"},{"vmid":16,"name":"创意"},{"vmid":17,"name":"工艺"},{"vmid":19,"name":"诗词"},{"vmid":20,"name":"美文"},{"vmid":21,"name":"其他"},{"vmid":11,"name":"诗集"},{"vmid":10,"name":"对联"},{"vmid":22,"name":"书画"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * vmid : 9
         * name : 书法
         */

        private int vmid;
        private String name;

        public int getVmid() {
            return vmid;
        }

        public void setVmid(int vmid) {
            this.vmid = vmid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
