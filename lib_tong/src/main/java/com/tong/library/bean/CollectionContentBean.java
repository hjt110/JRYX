package com.tong.library.bean;

public class CollectionContentBean {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"osid":14,"mid":9,"sponsorid":1,"title":" 第三届全国书法网络大赛 成年组","contributions":25,"views":1000,"pic":"http://localhost/yxapi/data/upload/solicitation/14/aab3238922bcc25a6f606eb525ffdc56.jpg","start_time":1527868800,"end_time":1538064000,"introduce":"<p style=\"text-indent:28px\"><strong><span style=\";font-family:宋体;font-size:14px\"><span style=\"font-family:宋体\">中国硬笔书法协会<\/span>  ","deposit":"0.00","rewards":null,"member_list_username":"admin","time_state":-1}
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
         * osid : 14
         * mid : 9
         * sponsorid : 1
         * title :  第三届全国书法网络大赛 成年组
         * contributions : 25
         * views : 1000
         * pic : http://localhost/yxapi/data/upload/solicitation/14/aab3238922bcc25a6f606eb525ffdc56.jpg
         * start_time : 1527868800
         * end_time : 1538064000
         * introduce : <p style="text-indent:28px"><strong><span style=";font-family:宋体;font-size:14px"><span style="font-family:宋体">中国硬笔书法协会</span>
         * deposit : 0.00
         * rewards : null
         * member_list_username : admin
         * time_state : -1
         */

        private int osid;
        private int mid;
        private int sponsorid;
        private String title;
        private int contributions;
        private int views;
        private String pic;
        private int start_time;
        private int end_time;
        private String introduce;
        private String deposit;
        private Object rewards;
        private String member_list_username;
        private int time_state;

        public int getOsid() {
            return osid;
        }

        public void setOsid(int osid) {
            this.osid = osid;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public int getSponsorid() {
            return sponsorid;
        }

        public void setSponsorid(int sponsorid) {
            this.sponsorid = sponsorid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getContributions() {
            return contributions;
        }

        public void setContributions(int contributions) {
            this.contributions = contributions;
        }

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getStart_time() {
            return start_time;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }

        public int getEnd_time() {
            return end_time;
        }

        public void setEnd_time(int end_time) {
            this.end_time = end_time;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getDeposit() {
            return deposit;
        }

        public void setDeposit(String deposit) {
            this.deposit = deposit;
        }

        public Object getRewards() {
            return rewards;
        }

        public void setRewards(Object rewards) {
            this.rewards = rewards;
        }

        public String getMember_list_username() {
            return member_list_username;
        }

        public void setMember_list_username(String member_list_username) {
            this.member_list_username = member_list_username;
        }

        public int getTime_state() {
            return time_state;
        }

        public void setTime_state(int time_state) {
            this.time_state = time_state;
        }
    }
}
