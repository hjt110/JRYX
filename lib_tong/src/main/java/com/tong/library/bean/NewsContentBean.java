package com.tong.library.bean;

import java.util.List;

public class NewsContentBean {


    /**
     * code : 0
     * msg : 操作成功
     * data : {"pagecount":270,"page":1,"limit":8,"newslist":[{"n_id":8719,"news_title":"辽宁对罪犯脱逃事故全面启动问责","news_columnid":11,"news_pic_type":2,"news_pic_allurl":["http://p98.pstatp.com/large/pgc-image/1538944977509360465b045","http://p3.pstatp.com/large/pgc-image/15389449774832c6fffe491","http://p3.pstatp.com/large/pgc-image/15389449775527ad31216d9"],"jump_url":null,"news_hot":0,"news_time":1538959869,"news_scontent":"辽宁对罪犯脱逃事故全面启动问责","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8718,"news_title":"国庆假期进入第4天，全国出行旅游人数居高不下","news_columnid":11,"news_pic_type":2,"news_pic_allurl":["http://p1.pstatp.com/large/pgc-image/1538691500138ae2c82b40a","http://p98.pstatp.com/large/pgc-image/1538691500645723b3ec761","http://p9.pstatp.com/large/pgc-image/1538691500587ee7d23817b"],"jump_url":null,"news_hot":0,"news_time":1538700387,"news_scontent":"国庆假期进入第4天，全国出行旅游人数居高不下","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8715,"news_title":"著名书画家赵孟頫之弟赵孟吁，字子俊书法","news_columnid":13,"news_pic_type":2,"news_pic_allurl":["http://www.yac8.com/upFiles/infoImg/201809/2018092770324801.jpg","http://www.yac8.com/upFiles/infoImg/201809/2018092768530673.jpg","http://www.yac8.com/upFiles/infoImg/201809/2018092770402817.jpg"],"jump_url":null,"news_hot":0,"news_time":1538447143,"news_scontent":"著名书画家赵孟頫之弟赵孟吁，字子俊书法","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8714,"news_title":"国庆黄金周首日1.22亿人次出游 花了1030亿元","news_columnid":11,"news_pic_type":2,"news_pic_allurl":["http://p98.pstatp.com/large/pgc-image/153841047171027bd6546ad","http://p98.pstatp.com/large/pgc-image/15384104737362ba2827239","http://p1.pstatp.com/large/pgc-image/1538410474729c507991fab"],"jump_url":null,"news_hot":0,"news_time":1538446892,"news_scontent":"黄金周首日1.22亿人次出游 花了1030亿元","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8713,"news_title":"好久不见","news_columnid":13,"news_pic_type":2,"news_pic_allurl":["http://p3.pstatp.com/large/pgc-image/15347885368575fc058a38d","http://p98.pstatp.com/large/pgc-image/1534788537578c1f3c0c0c3","http://p1.pstatp.com/large/pgc-image/153478853595258dc9b1790"],"jump_url":null,"news_hot":0,"news_time":1538269369,"news_scontent":"徐志摩：好久不见（美到心碎）","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8712,"news_title":"秋名山上以后定有你一席之地","news_columnid":20,"news_pic_type":2,"news_pic_allurl":["http://p98.pstatp.com/large/pgc-image/1538222267534aa3857b36f","http://p1.pstatp.com/large/pgc-image/1538222267471222eff9a83","http://p1.pstatp.com/large/pgc-image/1538222269884ecdc6abb6e"],"jump_url":null,"news_hot":0,"news_time":1538269043,"news_scontent":"秋名山上以后定有你一席之地","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8711,"news_title":"爆笑精品段子，让你笑不停 快乐每一天哦","news_columnid":11,"news_pic_type":2,"news_pic_allurl":["http://p9.pstatp.com/large/pgc-image/1538056716065d1a8f9b7bb","http://p3.pstatp.com/large/pgc-image/1538056832123f36436a4e8","http://p3.pstatp.com/large/pgc-image/1538056776905fea7ecfced"],"jump_url":null,"news_hot":0,"news_time":1538268826,"news_scontent":"爆笑精品段子，让你笑不停 快乐每一天哦","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8710,"news_title":"厦门新增424路公交车 9月30日运行","news_columnid":11,"news_pic_type":1,"news_pic_allurl":["http://qinu.jryx9.com/image/jmlcmjhs_12lx1lgwjsse5bad887e22768.jpg"],"jump_url":"","news_hot":0,"news_time":1538099326,"news_scontent":"来自厦门公交集团的消息，为进一步方便殿前街道的高崎机场、万翔物流园、高崎工业区等片区乘客出行，同时完善嘉谊路、环岛北路的公交线网","commentcount":0,"member_list_username":"jryx","dolikes":0}]}
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
         * pagecount : 270
         * page : 1
         * limit : 8
         * newslist : [{"n_id":8719,"news_title":"辽宁对罪犯脱逃事故全面启动问责","news_columnid":11,"news_pic_type":2,"news_pic_allurl":["http://p98.pstatp.com/large/pgc-image/1538944977509360465b045","http://p3.pstatp.com/large/pgc-image/15389449774832c6fffe491","http://p3.pstatp.com/large/pgc-image/15389449775527ad31216d9"],"jump_url":null,"news_hot":0,"news_time":1538959869,"news_scontent":"辽宁对罪犯脱逃事故全面启动问责","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8718,"news_title":"国庆假期进入第4天，全国出行旅游人数居高不下","news_columnid":11,"news_pic_type":2,"news_pic_allurl":["http://p1.pstatp.com/large/pgc-image/1538691500138ae2c82b40a","http://p98.pstatp.com/large/pgc-image/1538691500645723b3ec761","http://p9.pstatp.com/large/pgc-image/1538691500587ee7d23817b"],"jump_url":null,"news_hot":0,"news_time":1538700387,"news_scontent":"国庆假期进入第4天，全国出行旅游人数居高不下","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8715,"news_title":"著名书画家赵孟頫之弟赵孟吁，字子俊书法","news_columnid":13,"news_pic_type":2,"news_pic_allurl":["http://www.yac8.com/upFiles/infoImg/201809/2018092770324801.jpg","http://www.yac8.com/upFiles/infoImg/201809/2018092768530673.jpg","http://www.yac8.com/upFiles/infoImg/201809/2018092770402817.jpg"],"jump_url":null,"news_hot":0,"news_time":1538447143,"news_scontent":"著名书画家赵孟頫之弟赵孟吁，字子俊书法","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8714,"news_title":"国庆黄金周首日1.22亿人次出游 花了1030亿元","news_columnid":11,"news_pic_type":2,"news_pic_allurl":["http://p98.pstatp.com/large/pgc-image/153841047171027bd6546ad","http://p98.pstatp.com/large/pgc-image/15384104737362ba2827239","http://p1.pstatp.com/large/pgc-image/1538410474729c507991fab"],"jump_url":null,"news_hot":0,"news_time":1538446892,"news_scontent":"黄金周首日1.22亿人次出游 花了1030亿元","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8713,"news_title":"好久不见","news_columnid":13,"news_pic_type":2,"news_pic_allurl":["http://p3.pstatp.com/large/pgc-image/15347885368575fc058a38d","http://p98.pstatp.com/large/pgc-image/1534788537578c1f3c0c0c3","http://p1.pstatp.com/large/pgc-image/153478853595258dc9b1790"],"jump_url":null,"news_hot":0,"news_time":1538269369,"news_scontent":"徐志摩：好久不见（美到心碎）","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8712,"news_title":"秋名山上以后定有你一席之地","news_columnid":20,"news_pic_type":2,"news_pic_allurl":["http://p98.pstatp.com/large/pgc-image/1538222267534aa3857b36f","http://p1.pstatp.com/large/pgc-image/1538222267471222eff9a83","http://p1.pstatp.com/large/pgc-image/1538222269884ecdc6abb6e"],"jump_url":null,"news_hot":0,"news_time":1538269043,"news_scontent":"秋名山上以后定有你一席之地","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8711,"news_title":"爆笑精品段子，让你笑不停 快乐每一天哦","news_columnid":11,"news_pic_type":2,"news_pic_allurl":["http://p9.pstatp.com/large/pgc-image/1538056716065d1a8f9b7bb","http://p3.pstatp.com/large/pgc-image/1538056832123f36436a4e8","http://p3.pstatp.com/large/pgc-image/1538056776905fea7ecfced"],"jump_url":null,"news_hot":0,"news_time":1538268826,"news_scontent":"爆笑精品段子，让你笑不停 快乐每一天哦","commentcount":0,"member_list_username":"牧羊如云牧羊如云牧羊如云","dolikes":0},{"n_id":8710,"news_title":"厦门新增424路公交车 9月30日运行","news_columnid":11,"news_pic_type":1,"news_pic_allurl":["http://qinu.jryx9.com/image/jmlcmjhs_12lx1lgwjsse5bad887e22768.jpg"],"jump_url":"","news_hot":0,"news_time":1538099326,"news_scontent":"来自厦门公交集团的消息，为进一步方便殿前街道的高崎机场、万翔物流园、高崎工业区等片区乘客出行，同时完善嘉谊路、环岛北路的公交线网","commentcount":0,"member_list_username":"jryx","dolikes":0}]
         */

        private int pagecount;
        private int page;
        private int limit;
        private List<NewslistBean> newslist;

        public int getPagecount() {
            return pagecount;
        }

        public void setPagecount(int pagecount) {
            this.pagecount = pagecount;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public List<NewslistBean> getNewslist() {
            return newslist;
        }

        public void setNewslist(List<NewslistBean> newslist) {
            this.newslist = newslist;
        }

        public static class NewslistBean {
            /**
             * n_id : 8719
             * news_title : 辽宁对罪犯脱逃事故全面启动问责
             * news_columnid : 11
             * news_pic_type : 2
             * news_pic_allurl : ["http://p98.pstatp.com/large/pgc-image/1538944977509360465b045","http://p3.pstatp.com/large/pgc-image/15389449774832c6fffe491","http://p3.pstatp.com/large/pgc-image/15389449775527ad31216d9"]
             * jump_url : null
             * news_hot : 0
             * news_time : 1538959869
             * news_scontent : 辽宁对罪犯脱逃事故全面启动问责
             * commentcount : 0
             * member_list_username : 牧羊如云牧羊如云牧羊如云
             * dolikes : 0
             */

            private int n_id;
            private String news_title;
            private int news_columnid;
            private int news_pic_type;
            private Object jump_url;
            private int news_hot;
            private int news_time;
            private String news_scontent;
            private int commentcount;
            private String member_list_username;
            private int dolikes;
            private List<String> news_pic_allurl;

            public int getN_id() {
                return n_id;
            }

            public void setN_id(int n_id) {
                this.n_id = n_id;
            }

            public String getNews_title() {
                return news_title;
            }

            public void setNews_title(String news_title) {
                this.news_title = news_title;
            }

            public int getNews_columnid() {
                return news_columnid;
            }

            public void setNews_columnid(int news_columnid) {
                this.news_columnid = news_columnid;
            }

            public int getNews_pic_type() {
                return news_pic_type;
            }

            public void setNews_pic_type(int news_pic_type) {
                this.news_pic_type = news_pic_type;
            }

            public Object getJump_url() {
                return jump_url;
            }

            public void setJump_url(Object jump_url) {
                this.jump_url = jump_url;
            }

            public int getNews_hot() {
                return news_hot;
            }

            public void setNews_hot(int news_hot) {
                this.news_hot = news_hot;
            }

            public int getNews_time() {
                return news_time;
            }

            public void setNews_time(int news_time) {
                this.news_time = news_time;
            }

            public String getNews_scontent() {
                return news_scontent;
            }

            public void setNews_scontent(String news_scontent) {
                this.news_scontent = news_scontent;
            }

            public int getCommentcount() {
                return commentcount;
            }

            public void setCommentcount(int commentcount) {
                this.commentcount = commentcount;
            }

            public String getMember_list_username() {
                return member_list_username;
            }

            public void setMember_list_username(String member_list_username) {
                this.member_list_username = member_list_username;
            }

            public int getDolikes() {
                return dolikes;
            }

            public void setDolikes(int dolikes) {
                this.dolikes = dolikes;
            }

            public List<String> getNews_pic_allurl() {
                return news_pic_allurl;
            }

            public void setNews_pic_allurl(List<String> news_pic_allurl) {
                this.news_pic_allurl = news_pic_allurl;
            }
        }
    }
}
