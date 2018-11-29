package com.tong.library.bean;

import java.util.List;

public class HotContentBean {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"submission":{"cover":"http://www.jryx9.com/data/upload/submission/57/a86c450b76fb8c371afead6410d55534.thumb.jpg","ossid":57,"sid":14,"memberid":290,"title":"桃花庵","addtime":1514736000,"commentcount":2000,"views":1015,"dolikes":0,"votes":258,"introduce":"","images":["http://www.jryx9.com/data/upload/submission/57/a86c450b76fb8c371afead6410d55534.jpg"],"solicitationtitle":" 第三届全国书法网络大赛 成年组","is_votes":0,"is_collection":0,"is_dolikes":0},"friend_data":{"member_list_id":290,"member_list_username":"空白魏","member_list_headpic":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL4Yf2awot0oQ4ReictgyZbnmnSUJsZKrcC2tBHtAnpvqibAwSSqKpedSKBDt1SnkobUhw5ZoXJNM6Q/0","fansnum":1,"readnum":0,"follownum":0,"signature":null,"explains":null,"firend_state":0}}
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
         * submission : {"cover":"http://www.jryx9.com/data/upload/submission/57/a86c450b76fb8c371afead6410d55534.thumb.jpg","ossid":57,"sid":14,"memberid":290,"title":"桃花庵","addtime":1514736000,"commentcount":2000,"views":1015,"dolikes":0,"votes":258,"introduce":"","images":["http://www.jryx9.com/data/upload/submission/57/a86c450b76fb8c371afead6410d55534.jpg"],"solicitationtitle":" 第三届全国书法网络大赛 成年组","is_votes":0,"is_collection":0,"is_dolikes":0}
         * friend_data : {"member_list_id":290,"member_list_username":"空白魏","member_list_headpic":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL4Yf2awot0oQ4ReictgyZbnmnSUJsZKrcC2tBHtAnpvqibAwSSqKpedSKBDt1SnkobUhw5ZoXJNM6Q/0","fansnum":1,"readnum":0,"follownum":0,"signature":null,"explains":null,"firend_state":0}
         */

        private SubmissionBean submission;
        private FriendDataBean friend_data;

        public SubmissionBean getSubmission() {
            return submission;
        }

        public void setSubmission(SubmissionBean submission) {
            this.submission = submission;
        }

        public FriendDataBean getFriend_data() {
            return friend_data;
        }

        public void setFriend_data(FriendDataBean friend_data) {
            this.friend_data = friend_data;
        }

        public static class SubmissionBean {
            /**
             * cover : http://www.jryx9.com/data/upload/submission/57/a86c450b76fb8c371afead6410d55534.thumb.jpg
             * ossid : 57
             * sid : 14
             * memberid : 290
             * title : 桃花庵
             * addtime : 1514736000
             * commentcount : 2000
             * views : 1015
             * dolikes : 0
             * votes : 258
             * introduce :
             * images : ["http://www.jryx9.com/data/upload/submission/57/a86c450b76fb8c371afead6410d55534.jpg"]
             * solicitationtitle :  第三届全国书法网络大赛 成年组
             * is_votes : 0
             * is_collection : 0
             * is_dolikes : 0
             */

            private String cover;
            private int ossid;
            private int sid;
            private int memberid;
            private String title;
            private int addtime;
            private int commentcount;
            private int views;
            private int dolikes;
            private int votes;
            private String introduce;
            private String solicitationtitle;
            private int is_votes;
            private int is_collection;
            private int is_dolikes;
            private List<String> images;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

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

            public int getAddtime() {
                return addtime;
            }

            public void setAddtime(int addtime) {
                this.addtime = addtime;
            }

            public int getCommentcount() {
                return commentcount;
            }

            public void setCommentcount(int commentcount) {
                this.commentcount = commentcount;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public int getDolikes() {
                return dolikes;
            }

            public void setDolikes(int dolikes) {
                this.dolikes = dolikes;
            }

            public int getVotes() {
                return votes;
            }

            public void setVotes(int votes) {
                this.votes = votes;
            }

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
            }

            public String getSolicitationtitle() {
                return solicitationtitle;
            }

            public void setSolicitationtitle(String solicitationtitle) {
                this.solicitationtitle = solicitationtitle;
            }

            public int getIs_votes() {
                return is_votes;
            }

            public void setIs_votes(int is_votes) {
                this.is_votes = is_votes;
            }

            public int getIs_collection() {
                return is_collection;
            }

            public void setIs_collection(int is_collection) {
                this.is_collection = is_collection;
            }

            public int getIs_dolikes() {
                return is_dolikes;
            }

            public void setIs_dolikes(int is_dolikes) {
                this.is_dolikes = is_dolikes;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class FriendDataBean {
            /**
             * member_list_id : 290
             * member_list_username : 空白魏
             * member_list_headpic : http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL4Yf2awot0oQ4ReictgyZbnmnSUJsZKrcC2tBHtAnpvqibAwSSqKpedSKBDt1SnkobUhw5ZoXJNM6Q/0
             * fansnum : 1
             * readnum : 0
             * follownum : 0
             * signature : null
             * explains : null
             * firend_state : 0
             */

            private int member_list_id;
            private String member_list_username;
            private String member_list_headpic;
            private int fansnum;
            private int readnum;
            private int follownum;
            private Object signature;
            private Object explains;
            private int firend_state;

            public int getMember_list_id() {
                return member_list_id;
            }

            public void setMember_list_id(int member_list_id) {
                this.member_list_id = member_list_id;
            }

            public String getMember_list_username() {
                return member_list_username;
            }

            public void setMember_list_username(String member_list_username) {
                this.member_list_username = member_list_username;
            }

            public String getMember_list_headpic() {
                return member_list_headpic;
            }

            public void setMember_list_headpic(String member_list_headpic) {
                this.member_list_headpic = member_list_headpic;
            }

            public int getFansnum() {
                return fansnum;
            }

            public void setFansnum(int fansnum) {
                this.fansnum = fansnum;
            }

            public int getReadnum() {
                return readnum;
            }

            public void setReadnum(int readnum) {
                this.readnum = readnum;
            }

            public int getFollownum() {
                return follownum;
            }

            public void setFollownum(int follownum) {
                this.follownum = follownum;
            }

            public Object getSignature() {
                return signature;
            }

            public void setSignature(Object signature) {
                this.signature = signature;
            }

            public Object getExplains() {
                return explains;
            }

            public void setExplains(Object explains) {
                this.explains = explains;
            }

            public int getFirend_state() {
                return firend_state;
            }

            public void setFirend_state(int firend_state) {
                this.firend_state = firend_state;
            }
        }
    }
}
