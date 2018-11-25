package com.tong.library.bean;

import java.util.List;

public class HotListBean {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"pagecount":3,"page":0,"limit":10,"count":22,"list":[{"ossid":50,"sid":14,"memberid":237,"title":"行路难","cover":"http://www.jryx9.com/data/upload/submission/50/cee631121c2ec9232f3a2f028ad5c89b.thumb.jpg","code":"50","views":1202,"votes":261,"dolikes":0,"commentcount":2011,"member_list_username":"五只蛋挞"},{"ossid":49,"sid":14,"memberid":115,"title":"天行健","cover":"http://www.jryx9.com/data/upload/submission/49/c410003ef13d451727aeff9082c29a5c.thumb.jpg","code":"49","views":1049,"votes":257,"dolikes":0,"commentcount":2003,"member_list_username":"博嘉豪韵茶业詹建忠"},{"ossid":74,"sid":14,"memberid":335,"title":"水调歌头·明月几时有","cover":"http://www.jryx9.com/data/upload/submission/74/edfbe1afcf9246bb0d40eb4d8027d90f.thumb.JPG","code":"335","views":1020,"votes":256,"dolikes":0,"commentcount":2000,"member_list_username":"\u20ac 清淺ぉ"},{"ossid":48,"sid":14,"memberid":110,"title":"宿敌","cover":"http://www.jryx9.com/data/upload/submission/48/6ea2ef7311b482724a9b7b0bc0dd85c6.thumb.jpeg","code":"48","views":1018,"votes":257,"dolikes":0,"commentcount":2001,"member_list_username":"戎马书生"},{"ossid":75,"sid":14,"memberid":110,"title":"临玄秘塔碑","cover":"http://www.jryx9.com/data/upload/submission/75/b137fdd1f79d56c7edf3365fea7520f2.thumb.jpeg","code":"110","views":1018,"votes":256,"dolikes":0,"commentcount":2000,"member_list_username":"戎马书生"},{"ossid":91,"sid":14,"memberid":659,"title":"卜算子 咏梅","cover":"http://www.jryx9.com/data/upload/submission/91/e205ee2a5de471a70c1fd1b46033a75f.thumb.jpeg","code":"cnz091","views":1018,"votes":255,"dolikes":0,"commentcount":2000,"member_list_username":"果zi"},{"ossid":52,"sid":14,"memberid":57,"title":"硬笔书法","cover":"http://www.jryx9.com/data/upload/submission/52/cf67355a3333e6e143439161adc2d82e.thumb.jpg","code":"52","views":1017,"votes":257,"dolikes":0,"commentcount":2001,"member_list_username":"太阳雨"},{"ossid":59,"sid":14,"memberid":293,"title":"随便写写","cover":"http://www.jryx9.com/data/upload/submission/59/08b255a5d42b89b0585260b6f2360bdd.thumb.jpg","code":"cnz06100","views":1016,"votes":255,"dolikes":0,"commentcount":2000,"member_list_username":"心游"},{"ossid":54,"sid":14,"memberid":276,"title":"写字令人心静","cover":"http://www.jryx9.com/data/upload/submission/54/9b72e31dac81715466cd580a448cf823.thumb.jpg","code":"54","views":1014,"votes":255,"dolikes":0,"commentcount":2001,"member_list_username":"yzy"},{"ossid":57,"sid":14,"memberid":290,"title":"桃花庵","cover":"http://www.jryx9.com/data/upload/submission/57/a86c450b76fb8c371afead6410d55534.thumb.jpg","code":"cnz068","views":1014,"votes":258,"dolikes":0,"commentcount":2000,"member_list_username":"空白魏"}]}
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
         * pagecount : 3
         * page : 0
         * limit : 10
         * count : 22
         * list : [{"ossid":50,"sid":14,"memberid":237,"title":"行路难","cover":"http://www.jryx9.com/data/upload/submission/50/cee631121c2ec9232f3a2f028ad5c89b.thumb.jpg","code":"50","views":1202,"votes":261,"dolikes":0,"commentcount":2011,"member_list_username":"五只蛋挞"},{"ossid":49,"sid":14,"memberid":115,"title":"天行健","cover":"http://www.jryx9.com/data/upload/submission/49/c410003ef13d451727aeff9082c29a5c.thumb.jpg","code":"49","views":1049,"votes":257,"dolikes":0,"commentcount":2003,"member_list_username":"博嘉豪韵茶业詹建忠"},{"ossid":74,"sid":14,"memberid":335,"title":"水调歌头·明月几时有","cover":"http://www.jryx9.com/data/upload/submission/74/edfbe1afcf9246bb0d40eb4d8027d90f.thumb.JPG","code":"335","views":1020,"votes":256,"dolikes":0,"commentcount":2000,"member_list_username":"\u20ac 清淺ぉ"},{"ossid":48,"sid":14,"memberid":110,"title":"宿敌","cover":"http://www.jryx9.com/data/upload/submission/48/6ea2ef7311b482724a9b7b0bc0dd85c6.thumb.jpeg","code":"48","views":1018,"votes":257,"dolikes":0,"commentcount":2001,"member_list_username":"戎马书生"},{"ossid":75,"sid":14,"memberid":110,"title":"临玄秘塔碑","cover":"http://www.jryx9.com/data/upload/submission/75/b137fdd1f79d56c7edf3365fea7520f2.thumb.jpeg","code":"110","views":1018,"votes":256,"dolikes":0,"commentcount":2000,"member_list_username":"戎马书生"},{"ossid":91,"sid":14,"memberid":659,"title":"卜算子 咏梅","cover":"http://www.jryx9.com/data/upload/submission/91/e205ee2a5de471a70c1fd1b46033a75f.thumb.jpeg","code":"cnz091","views":1018,"votes":255,"dolikes":0,"commentcount":2000,"member_list_username":"果zi"},{"ossid":52,"sid":14,"memberid":57,"title":"硬笔书法","cover":"http://www.jryx9.com/data/upload/submission/52/cf67355a3333e6e143439161adc2d82e.thumb.jpg","code":"52","views":1017,"votes":257,"dolikes":0,"commentcount":2001,"member_list_username":"太阳雨"},{"ossid":59,"sid":14,"memberid":293,"title":"随便写写","cover":"http://www.jryx9.com/data/upload/submission/59/08b255a5d42b89b0585260b6f2360bdd.thumb.jpg","code":"cnz06100","views":1016,"votes":255,"dolikes":0,"commentcount":2000,"member_list_username":"心游"},{"ossid":54,"sid":14,"memberid":276,"title":"写字令人心静","cover":"http://www.jryx9.com/data/upload/submission/54/9b72e31dac81715466cd580a448cf823.thumb.jpg","code":"54","views":1014,"votes":255,"dolikes":0,"commentcount":2001,"member_list_username":"yzy"},{"ossid":57,"sid":14,"memberid":290,"title":"桃花庵","cover":"http://www.jryx9.com/data/upload/submission/57/a86c450b76fb8c371afead6410d55534.thumb.jpg","code":"cnz068","views":1014,"votes":258,"dolikes":0,"commentcount":2000,"member_list_username":"空白魏"}]
         */

        private int pagecount;
        private int page;
        private int limit;
        private int count;
        private List<ListBean> list;

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

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * ossid : 50
             * sid : 14
             * memberid : 237
             * title : 行路难
             * cover : http://www.jryx9.com/data/upload/submission/50/cee631121c2ec9232f3a2f028ad5c89b.thumb.jpg
             * code : 50
             * views : 1202
             * votes : 261
             * dolikes : 0
             * commentcount : 2011
             * member_list_username : 五只蛋挞
             */

            private int ossid;
            private int sid;
            private int memberid;
            private String title;
            private String cover;
            private String code;
            private int views;
            private int votes;
            private int dolikes;
            private int commentcount;
            private String member_list_username;

            public int getOssid() {
                return ossid;
            }

            public void setOssid(int ossid) {
                this.ossid = ossid;
            }

            public int getSid() {
                return sid;
            }

            public void setSid(int sid) {
                this.sid = sid;
            }

            public int getMemberid() {
                return memberid;
            }

            public void setMemberid(int memberid) {
                this.memberid = memberid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public int getVotes() {
                return votes;
            }

            public void setVotes(int votes) {
                this.votes = votes;
            }

            public int getDolikes() {
                return dolikes;
            }

            public void setDolikes(int dolikes) {
                this.dolikes = dolikes;
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
        }
    }
}
