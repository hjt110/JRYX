package com.tong.library.bean;

import java.util.List;

public class CollectionListBean {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"pagecount":1,"page":0,"limit":10,"count":2,"list":[{"osid":14,"mid":9,"sponsorid":1,"title":" 第三届全国书法网络大赛 成年组","contributions":25,"thumb":"http://www.jryx9.com/data/upload/solicitation/14/aab3238922bcc25a6f606eb525ffdc56.thumb.jpg","start_time":1527868800,"end_time":1538064000,"brief":"中国硬笔书法协会  第三届全国书法、硬笔书法网络大赛 一、组织机构：中国硬笔书法协会","member_list_username":"admin","time_state":-1},{"osid":1,"mid":9,"sponsorid":1,"title":"第三届网络书法大赛 少儿组","contributions":16,"thumb":"http://www.jryx9.com/data/upload/circle/1/6ce9b0946a0d299f.thumb.jpg","start_time":1524931200,"end_time":1537977600,"brief":"中国硬笔书法协会  第三届全国书法、硬笔书法网络大赛","member_list_username":"admin","time_state":-1}]}
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
         * pagecount : 1
         * page : 0
         * limit : 10
         * count : 2
         * list : [{"osid":14,"mid":9,"sponsorid":1,"title":" 第三届全国书法网络大赛 成年组","contributions":25,"thumb":"http://www.jryx9.com/data/upload/solicitation/14/aab3238922bcc25a6f606eb525ffdc56.thumb.jpg","start_time":1527868800,"end_time":1538064000,"brief":"中国硬笔书法协会  第三届全国书法、硬笔书法网络大赛 一、组织机构：中国硬笔书法协会","member_list_username":"admin","time_state":-1},{"osid":1,"mid":9,"sponsorid":1,"title":"第三届网络书法大赛 少儿组","contributions":16,"thumb":"http://www.jryx9.com/data/upload/circle/1/6ce9b0946a0d299f.thumb.jpg","start_time":1524931200,"end_time":1537977600,"brief":"中国硬笔书法协会  第三届全国书法、硬笔书法网络大赛","member_list_username":"admin","time_state":-1}]
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
             * osid : 14
             * mid : 9
             * sponsorid : 1
             * title :  第三届全国书法网络大赛 成年组
             * contributions : 25
             * thumb : http://www.jryx9.com/data/upload/solicitation/14/aab3238922bcc25a6f606eb525ffdc56.thumb.jpg
             * start_time : 1527868800
             * end_time : 1538064000
             * brief : 中国硬笔书法协会  第三届全国书法、硬笔书法网络大赛 一、组织机构：中国硬笔书法协会
             * member_list_username : admin
             * time_state : -1
             */

            private int osid;
            private int mid;
            private int sponsorid;
            private String title;
            private int contributions;
            private String thumb;
            private int start_time;
            private int end_time;
            private String brief;
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

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
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

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
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
}
