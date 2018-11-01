package com.tong.library.bean;

import java.util.List;

public class NewsTitleBean {

    /**
     * code : 0
     * msg : 操作成功
     * data : [{"id":11,"menu_name":"综合","menu_enname":"a","menu_type":3,"menu_modelid":0,"parentid":0,"menu_listtpl":"","menu_newstpl":"news","menu_address":"","menu_open":1,"listorder":20,"menu_img":"","menu_seo_title":"","menu_seo_key":"","menu_seo_des":"","menu_content":"","menu_l":"zh-cn"},{"id":13,"menu_name":"艺术","menu_enname":"a","menu_type":3,"menu_modelid":0,"parentid":0,"menu_listtpl":"","menu_newstpl":"news","menu_address":"","menu_open":1,"listorder":21,"menu_img":"","menu_seo_title":"","menu_seo_key":"","menu_seo_des":"","menu_content":"","menu_l":"zh-cn"},{"id":20,"menu_name":"征集","menu_enname":"a","menu_type":3,"menu_modelid":0,"parentid":0,"menu_listtpl":"","menu_newstpl":"news","menu_address":"","menu_open":1,"listorder":21,"menu_img":"","menu_seo_title":"","menu_seo_key":"","menu_seo_des":"","menu_content":"","menu_l":"zh-cn"},{"id":12,"menu_name":"生活","menu_enname":"a","menu_type":3,"menu_modelid":0,"parentid":0,"menu_listtpl":"","menu_newstpl":"news","menu_address":"","menu_open":1,"listorder":22,"menu_img":"","menu_seo_title":"","menu_seo_key":"","menu_seo_des":"","menu_content":"","menu_l":"zh-cn"},{"id":112,"menu_name":"关注","menu_enname":"a","menu_type":3,"menu_modelid":0,"parentid":0,"menu_listtpl":"","menu_newstpl":"news","menu_address":"","menu_open":1,"listorder":23,"menu_img":"","menu_seo_title":"","menu_seo_key":"","menu_seo_des":"","menu_content":"","menu_l":"zh-cn"},{"id":114,"menu_name":"书画","menu_enname":"a","menu_type":3,"menu_modelid":0,"parentid":114,"menu_listtpl":"","menu_newstpl":"","menu_address":"","menu_open":1,"listorder":24,"menu_img":"","menu_seo_title":"","menu_seo_key":"","menu_seo_des":"","menu_content":"","menu_l":"zh-cn"},{"id":139,"menu_name":"书画","menu_enname":"a","menu_type":3,"menu_modelid":0,"parentid":0,"menu_listtpl":"","menu_newstpl":"","menu_address":"","menu_open":1,"listorder":26,"menu_img":"","menu_seo_title":"","menu_seo_key":"","menu_seo_des":"","menu_content":"","menu_l":"zh-cn"}]
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
         * id : 11
         * menu_name : 综合
         * menu_enname : a
         * menu_type : 3
         * menu_modelid : 0
         * parentid : 0
         * menu_listtpl :
         * menu_newstpl : news
         * menu_address :
         * menu_open : 1
         * listorder : 20
         * menu_img :
         * menu_seo_title :
         * menu_seo_key :
         * menu_seo_des :
         * menu_content :
         * menu_l : zh-cn
         */

        private int id;
        private String menu_name;
        private String menu_enname;
        private int menu_type;
        private int menu_modelid;
        private int parentid;
        private String menu_listtpl;
        private String menu_newstpl;
        private String menu_address;
        private int menu_open;
        private int listorder;
        private String menu_img;
        private String menu_seo_title;
        private String menu_seo_key;
        private String menu_seo_des;
        private String menu_content;
        private String menu_l;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMenu_name() {
            return menu_name;
        }

        public void setMenu_name(String menu_name) {
            this.menu_name = menu_name;
        }

        public String getMenu_enname() {
            return menu_enname;
        }

        public void setMenu_enname(String menu_enname) {
            this.menu_enname = menu_enname;
        }

        public int getMenu_type() {
            return menu_type;
        }

        public void setMenu_type(int menu_type) {
            this.menu_type = menu_type;
        }

        public int getMenu_modelid() {
            return menu_modelid;
        }

        public void setMenu_modelid(int menu_modelid) {
            this.menu_modelid = menu_modelid;
        }

        public int getParentid() {
            return parentid;
        }

        public void setParentid(int parentid) {
            this.parentid = parentid;
        }

        public String getMenu_listtpl() {
            return menu_listtpl;
        }

        public void setMenu_listtpl(String menu_listtpl) {
            this.menu_listtpl = menu_listtpl;
        }

        public String getMenu_newstpl() {
            return menu_newstpl;
        }

        public void setMenu_newstpl(String menu_newstpl) {
            this.menu_newstpl = menu_newstpl;
        }

        public String getMenu_address() {
            return menu_address;
        }

        public void setMenu_address(String menu_address) {
            this.menu_address = menu_address;
        }

        public int getMenu_open() {
            return menu_open;
        }

        public void setMenu_open(int menu_open) {
            this.menu_open = menu_open;
        }

        public int getListorder() {
            return listorder;
        }

        public void setListorder(int listorder) {
            this.listorder = listorder;
        }

        public String getMenu_img() {
            return menu_img;
        }

        public void setMenu_img(String menu_img) {
            this.menu_img = menu_img;
        }

        public String getMenu_seo_title() {
            return menu_seo_title;
        }

        public void setMenu_seo_title(String menu_seo_title) {
            this.menu_seo_title = menu_seo_title;
        }

        public String getMenu_seo_key() {
            return menu_seo_key;
        }

        public void setMenu_seo_key(String menu_seo_key) {
            this.menu_seo_key = menu_seo_key;
        }

        public String getMenu_seo_des() {
            return menu_seo_des;
        }

        public void setMenu_seo_des(String menu_seo_des) {
            this.menu_seo_des = menu_seo_des;
        }

        public String getMenu_content() {
            return menu_content;
        }

        public void setMenu_content(String menu_content) {
            this.menu_content = menu_content;
        }

        public String getMenu_l() {
            return menu_l;
        }

        public void setMenu_l(String menu_l) {
            this.menu_l = menu_l;
        }
    }
}
