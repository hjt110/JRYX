package com.tong.library.bean;

import java.util.List;

public class VideoTitleBean {

    /**
     * code : 0
     * msg : 操作成功
     * data : [{"vmid":8,"pid":0,"type":1,"level":0,"name":"户外","tag":"户外","listorder":50,"introduce":"<p>户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外vv<\/p>","pic":"","seo_title":"","seo_introduce":"","state":1,"addtime":0},{"vmid":7,"pid":0,"type":1,"level":0,"name":"\u200b随拍","tag":"\u200b随拍","listorder":50,"introduce":"<p>随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍随拍v<\/p>","pic":"","seo_title":"","seo_introduce":"","state":1,"addtime":0},{"vmid":2,"pid":0,"type":1,"level":0,"name":"美女","tag":"测试","listorder":50,"introduce":"<p>在短信发送到发送到<\/p>","pic":"/data/upload/2018-03-22/5ab3280cba608.png","seo_title":"水电费水电费·1","seo_introduce":"阿萨德飞洒发","state":1,"addtime":0},{"vmid":1,"pid":0,"type":1,"level":2,"name":"美食","tag":"","listorder":55,"introduce":"<p>视频栏目还介绍<\/p>","pic":null,"seo_title":"","seo_introduce":"","state":1,"addtime":1520487333}]
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
         * vmid : 8
         * pid : 0
         * type : 1
         * level : 0
         * name : 户外
         * tag : 户外
         * listorder : 50
         * introduce : <p>户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外户外vv</p>
         * pic :
         * seo_title :
         * seo_introduce :
         * state : 1
         * addtime : 0
         */

        private int vmid;
        private int pid;
        private int type;
        private int level;
        private String name;
        private String tag;
        private int listorder;
        private String introduce;
        private String pic;
        private String seo_title;
        private String seo_introduce;
        private int state;
        private int addtime;

        public int getVmid() {
            return vmid;
        }

        public void setVmid(int vmid) {
            this.vmid = vmid;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getListorder() {
            return listorder;
        }

        public void setListorder(int listorder) {
            this.listorder = listorder;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getSeo_title() {
            return seo_title;
        }

        public void setSeo_title(String seo_title) {
            this.seo_title = seo_title;
        }

        public String getSeo_introduce() {
            return seo_introduce;
        }

        public void setSeo_introduce(String seo_introduce) {
            this.seo_introduce = seo_introduce;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getAddtime() {
            return addtime;
        }

        public void setAddtime(int addtime) {
            this.addtime = addtime;
        }
    }
}
