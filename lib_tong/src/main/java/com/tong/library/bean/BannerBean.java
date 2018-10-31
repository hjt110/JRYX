package com.tong.library.bean;

import java.util.List;

public class BannerBean  {

    /**
     * code : 0
     * msg : 操作成功
     * data : [{"plug_ad_id":27,"plug_ad_name":"第三届网络书法大赛 少儿组","plug_ad_adtypeid":14,"plug_ad_checkid":1,"plug_ad_js":"","plug_ad_pic":"http://www.jryx9.com/data/upload/2018-05-24/5b061201d6a04.jpg","plug_ad_url":"javascript:void(0);","plug_ad_content":"","plug_ad_addtime":1524115205,"plug_ad_order":50,"plug_ad_open":1,"plug_ad_depid":0,"plug_ad_butt":0,"plug_ad_l":"zh-cn"},{"plug_ad_id":28,"plug_ad_name":"第三届网络书法大赛 成人组","plug_ad_adtypeid":14,"plug_ad_checkid":1,"plug_ad_js":"","plug_ad_pic":"http://www.jryx9.com/data/upload/2018-05-24/5b061214a8d98.jpg","plug_ad_url":"","plug_ad_content":"","plug_ad_addtime":1524819696,"plug_ad_order":50,"plug_ad_open":1,"plug_ad_depid":0,"plug_ad_butt":0,"plug_ad_l":"zh-cn"}]
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
         * plug_ad_id : 27
         * plug_ad_name : 第三届网络书法大赛 少儿组
         * plug_ad_adtypeid : 14
         * plug_ad_checkid : 1
         * plug_ad_js :
         * plug_ad_pic : http://www.jryx9.com/data/upload/2018-05-24/5b061201d6a04.jpg
         * plug_ad_url : javascript:void(0);
         * plug_ad_content :
         * plug_ad_addtime : 1524115205
         * plug_ad_order : 50
         * plug_ad_open : 1
         * plug_ad_depid : 0
         * plug_ad_butt : 0
         * plug_ad_l : zh-cn
         */

        private int plug_ad_id;
        private String plug_ad_name;
        private int plug_ad_adtypeid;
        private int plug_ad_checkid;
        private String plug_ad_js;
        private String plug_ad_pic;
        private String plug_ad_url;
        private String plug_ad_content;
        private int plug_ad_addtime;
        private int plug_ad_order;
        private int plug_ad_open;
        private int plug_ad_depid;
        private int plug_ad_butt;
        private String plug_ad_l;

        public int getPlug_ad_id() {
            return plug_ad_id;
        }

        public void setPlug_ad_id(int plug_ad_id) {
            this.plug_ad_id = plug_ad_id;
        }

        public String getPlug_ad_name() {
            return plug_ad_name;
        }

        public void setPlug_ad_name(String plug_ad_name) {
            this.plug_ad_name = plug_ad_name;
        }

        public int getPlug_ad_adtypeid() {
            return plug_ad_adtypeid;
        }

        public void setPlug_ad_adtypeid(int plug_ad_adtypeid) {
            this.plug_ad_adtypeid = plug_ad_adtypeid;
        }

        public int getPlug_ad_checkid() {
            return plug_ad_checkid;
        }

        public void setPlug_ad_checkid(int plug_ad_checkid) {
            this.plug_ad_checkid = plug_ad_checkid;
        }

        public String getPlug_ad_js() {
            return plug_ad_js;
        }

        public void setPlug_ad_js(String plug_ad_js) {
            this.plug_ad_js = plug_ad_js;
        }

        public String getPlug_ad_pic() {
            return plug_ad_pic;
        }

        public void setPlug_ad_pic(String plug_ad_pic) {
            this.plug_ad_pic = plug_ad_pic;
        }

        public String getPlug_ad_url() {
            return plug_ad_url;
        }

        public void setPlug_ad_url(String plug_ad_url) {
            this.plug_ad_url = plug_ad_url;
        }

        public String getPlug_ad_content() {
            return plug_ad_content;
        }

        public void setPlug_ad_content(String plug_ad_content) {
            this.plug_ad_content = plug_ad_content;
        }

        public int getPlug_ad_addtime() {
            return plug_ad_addtime;
        }

        public void setPlug_ad_addtime(int plug_ad_addtime) {
            this.plug_ad_addtime = plug_ad_addtime;
        }

        public int getPlug_ad_order() {
            return plug_ad_order;
        }

        public void setPlug_ad_order(int plug_ad_order) {
            this.plug_ad_order = plug_ad_order;
        }

        public int getPlug_ad_open() {
            return plug_ad_open;
        }

        public void setPlug_ad_open(int plug_ad_open) {
            this.plug_ad_open = plug_ad_open;
        }

        public int getPlug_ad_depid() {
            return plug_ad_depid;
        }

        public void setPlug_ad_depid(int plug_ad_depid) {
            this.plug_ad_depid = plug_ad_depid;
        }

        public int getPlug_ad_butt() {
            return plug_ad_butt;
        }

        public void setPlug_ad_butt(int plug_ad_butt) {
            this.plug_ad_butt = plug_ad_butt;
        }

        public String getPlug_ad_l() {
            return plug_ad_l;
        }

        public void setPlug_ad_l(String plug_ad_l) {
            this.plug_ad_l = plug_ad_l;
        }
    }
}
