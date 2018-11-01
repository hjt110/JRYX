package com.tong.library.bean;

import java.util.List;

public class VideoListBean {

    /**
     * code : 0
     * msg : 操作成功
     * data : [{"ovid":417,"vmid":8,"memberid":1102,"title":"没得救了","tag":null,"cover":"http://1256626659.vod2.myqcloud.com/cda3f1b7vodtransgzp1256626659/96a331305285890782028864540/1538014827_995667834.100_0.jpg","video":"http://1256626659.vod2.myqcloud.com/197c4f0fvodgzp1256626659/96a331305285890782028864540/mqo6xCa3ZTsA.mp4","tx_fileid":"5285890782028864540","introduce":"","listorder":50,"prepublishstate":0,"views":1,"dolikes":0,"collections":0,"publish_type":0,"commentcount":0,"state":1,"addtime":1538014825,"member_list_username":"真心守护","member_list_id":1102,"member_list_nickname":"真心守护","member_list_headpic":"http://www.jryx9.com/data/upload/member/1102/4305eefa1a231d02.thumb.jpg"},{"ovid":416,"vmid":8,"memberid":1101,"title":"\u201c眼镜男\u201d要在查酒驾现场强行带走涉嫌酒驾的司机，冲突一触即发...","tag":null,"cover":"http://1256626659.vod2.myqcloud.com/cda3f1b7vodtransgzp1256626659/96a2b61d5285890782028863968/1538014783_3970799643.100_0.jpg","video":"http://1256626659.vod2.myqcloud.com/197c4f0fvodgzp1256626659/96a2b61d5285890782028863968/yhxsN8UKYngA.mp4","tx_fileid":"5285890782028863968","introduce":"","listorder":50,"prepublishstate":0,"views":8,"dolikes":0,"collections":0,"publish_type":0,"commentcount":0,"state":1,"addtime":1538014780,"member_list_username":"煙雨如夢","member_list_id":1101,"member_list_nickname":"煙雨如夢","member_list_headpic":"http://www.jryx9.com/data/upload/member/1101/2506434d8d673582.thumb.jpg"},{"ovid":415,"vmid":8,"memberid":1100,"title":"观潮要注意安全！！！","tag":null,"cover":"http://1256626659.vod2.myqcloud.com/cda3f1b7vodtransgzp1256626659/964b678e5285890782028819223/1538014664_1785024118.100_0.jpg","video":"http://1256626659.vod2.myqcloud.com/197c4f0fvodgzp1256626659/964b678e5285890782028819223/CaDR1tiYHc8A.mp4","tx_fileid":"5285890782028819223","introduce":"","listorder":50,"prepublishstate":0,"views":2,"dolikes":0,"collections":0,"publish_type":0,"commentcount":0,"state":1,"addtime":1538014661,"member_list_username":"那一季\u2018\u2019好美〆","member_list_id":1100,"member_list_nickname":"那一季\u2018\u2019好美〆","member_list_headpic":"http://www.jryx9.com/data/upload/member/1100/a9a128c1e7915a09.thumb.jpg"},{"ovid":414,"vmid":8,"memberid":1099,"title":"以为是曾经的王者，结果还是青铜。","tag":null,"cover":"http://1256626659.vod2.myqcloud.com/cda3f1b7vodtransgzp1256626659/96a203325285890782028862049/1538014620_3198069752.100_0.jpg","video":"http://1256626659.vod2.myqcloud.com/197c4f0fvodgzp1256626659/96a203325285890782028862049/YKw7dWsUlCIA.mp4","tx_fileid":"5285890782028862049","introduce":"","listorder":50,"prepublishstate":0,"views":1,"dolikes":0,"collections":0,"publish_type":0,"commentcount":0,"state":1,"addtime":1538014617,"member_list_username":"无心看风景","member_list_id":1099,"member_list_nickname":"无心看风景","member_list_headpic":"http://www.jryx9.com/data/upload/member/1099/ed75d22763827586.thumb.jpg"},{"ovid":413,"vmid":7,"memberid":1098,"title":"妹妹抓哥哥头发，结果！","tag":null,"cover":"http://1256626659.vod2.myqcloud.com/cda3f1b7vodtransgzp1256626659/964ad2f05285890782028818046/1538014565_243032525.100_0.jpg","video":"http://1256626659.vod2.myqcloud.com/197c4f0fvodgzp1256626659/964ad2f05285890782028818046/apZLK4mJCjkA.mp4","tx_fileid":"5285890782028818046","introduce":"","listorder":50,"prepublishstate":0,"views":2,"dolikes":0,"collections":0,"publish_type":0,"commentcount":0,"state":1,"addtime":1538014563,"member_list_username":"蘑菇大人","member_list_id":1098,"member_list_nickname":"蘑菇大人","member_list_headpic":"http://www.jryx9.com/data/upload/member/1098/53edd1dfdb702c01.thumb.jpg"},{"ovid":412,"vmid":1,"memberid":1098,"title":"口水鸡做法","tag":null,"cover":"http://1256626659.vod2.myqcloud.com/cda3f1b7vodtransgzp1256626659/964674265285890782028810143/1538014516_3878625620.100_0.jpg","video":"http://1256626659.vod2.myqcloud.com/197c4f0fvodgzp1256626659/964674265285890782028810143/sPVe8VlZ6O0A.mp4","tx_fileid":"5285890782028810143","introduce":"","listorder":50,"prepublishstate":0,"views":2,"dolikes":0,"collections":0,"publish_type":0,"commentcount":0,"state":1,"addtime":1538014514,"member_list_username":"蘑菇大人","member_list_id":1098,"member_list_nickname":"蘑菇大人","member_list_headpic":"http://www.jryx9.com/data/upload/member/1098/53edd1dfdb702c01.thumb.jpg"}]
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
         * ovid : 417
         * vmid : 8
         * memberid : 1102
         * title : 没得救了
         * tag : null
         * cover : http://1256626659.vod2.myqcloud.com/cda3f1b7vodtransgzp1256626659/96a331305285890782028864540/1538014827_995667834.100_0.jpg
         * video : http://1256626659.vod2.myqcloud.com/197c4f0fvodgzp1256626659/96a331305285890782028864540/mqo6xCa3ZTsA.mp4
         * tx_fileid : 5285890782028864540
         * introduce :
         * listorder : 50
         * prepublishstate : 0
         * views : 1
         * dolikes : 0
         * collections : 0
         * publish_type : 0
         * commentcount : 0
         * state : 1
         * addtime : 1538014825
         * member_list_username : 真心守护
         * member_list_id : 1102
         * member_list_nickname : 真心守护
         * member_list_headpic : http://www.jryx9.com/data/upload/member/1102/4305eefa1a231d02.thumb.jpg
         */

        private int ovid;
        private int vmid;
        private int memberid;
        private String title;
        private String tag;
        private String cover;
        private String video;
        private String tx_fileid;
        private String introduce;
        private int listorder;
        private int prepublishstate;
        private int views;
        private int dolikes;
        private int collections;
        private int publish_type;
        private int commentcount;
        private int state;
        private int addtime;
        private String member_list_username;
        private int member_list_id;
        private String member_list_nickname;
        private String member_list_headpic;

        public int getOvid() {
            return ovid;
        }

        public void setOvid(int ovid) {
            this.ovid = ovid;
        }

        public int getVmid() {
            return vmid;
        }

        public void setVmid(int vmid) {
            this.vmid = vmid;
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

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getTx_fileid() {
            return tx_fileid;
        }

        public void setTx_fileid(String tx_fileid) {
            this.tx_fileid = tx_fileid;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public int getListorder() {
            return listorder;
        }

        public void setListorder(int listorder) {
            this.listorder = listorder;
        }

        public int getPrepublishstate() {
            return prepublishstate;
        }

        public void setPrepublishstate(int prepublishstate) {
            this.prepublishstate = prepublishstate;
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

        public int getCollections() {
            return collections;
        }

        public void setCollections(int collections) {
            this.collections = collections;
        }

        public int getPublish_type() {
            return publish_type;
        }

        public void setPublish_type(int publish_type) {
            this.publish_type = publish_type;
        }

        public int getCommentcount() {
            return commentcount;
        }

        public void setCommentcount(int commentcount) {
            this.commentcount = commentcount;
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

        public String getMember_list_username() {
            return member_list_username;
        }

        public void setMember_list_username(String member_list_username) {
            this.member_list_username = member_list_username;
        }

        public int getMember_list_id() {
            return member_list_id;
        }

        public void setMember_list_id(int member_list_id) {
            this.member_list_id = member_list_id;
        }

        public String getMember_list_nickname() {
            return member_list_nickname;
        }

        public void setMember_list_nickname(String member_list_nickname) {
            this.member_list_nickname = member_list_nickname;
        }

        public String getMember_list_headpic() {
            return member_list_headpic;
        }

        public void setMember_list_headpic(String member_list_headpic) {
            this.member_list_headpic = member_list_headpic;
        }
    }
}
