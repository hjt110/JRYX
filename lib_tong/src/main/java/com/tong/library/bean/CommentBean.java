package com.tong.library.bean;

import java.util.List;

public class CommentBean {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"pagecount":2,"page":0,"limit":10,"count":13,"list":[{"ocid":65,"fromid":16,"toid":null,"dolikes":0,"second_count":6,"content":"啦啦啦德玛西亚","addtime":1523234356,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[{"content":"呵呵","ocid":168,"fromid":16,"toid":17,"member_list_username":"蜡笔小欣"},{"content":"呵呵呵","ocid":132,"fromid":16,"toid":17,"member_list_username":"蜡笔小欣"}]},{"ocid":81,"fromid":16,"toid":null,"dolikes":0,"second_count":0,"content":"不行不行补习班","addtime":1523414198,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[]},{"ocid":82,"fromid":16,"toid":null,"dolikes":0,"second_count":0,"content":"还在不行吧行吧","addtime":1523414219,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[]},{"ocid":83,"fromid":16,"toid":null,"dolikes":0,"second_count":0,"content":"发VBvGV根本巴巴爸爸","addtime":1523414242,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[]},{"ocid":93,"fromid":2,"toid":null,"dolikes":0,"second_count":0,"content":"65265965","addtime":1523454723,"member_list_headpic":"http://www.jryx9.com/data/upload\\member\\2\\9420146800f517fc.jpg","member_list_username":"yhl18","is_dolikes":false,"item":[]},{"ocid":94,"fromid":2,"toid":null,"dolikes":0,"second_count":0,"content":"00000000","addtime":1523454734,"member_list_headpic":"http://www.jryx9.com/data/upload\\member\\2\\9420146800f517fc.jpg","member_list_username":"yhl18","is_dolikes":false,"item":[]},{"ocid":102,"fromid":17,"toid":null,"dolikes":0,"second_count":0,"content":"12345","addtime":1523776087,"member_list_headpic":"http://www.jryx9.com/data/upload\\member\\17\\8f3b626b7354f8b6.jpg","member_list_username":"Zhiya","is_dolikes":false,"item":[]},{"ocid":107,"fromid":16,"toid":null,"dolikes":0,"second_count":0,"content":"美","addtime":1523839336,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[]},{"ocid":108,"fromid":16,"toid":null,"dolikes":0,"second_count":0,"content":"ucycycycycy","addtime":1523948792,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[]},{"ocid":112,"fromid":16,"toid":null,"dolikes":0,"second_count":0,"content":"ycgcgcgcgcgctv哈哈v好v好v好v","addtime":1523951535,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[]}]}
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
         * pagecount : 2
         * page : 0
         * limit : 10
         * count : 13
         * list : [{"ocid":65,"fromid":16,"toid":null,"dolikes":0,"second_count":6,"content":"啦啦啦德玛西亚","addtime":1523234356,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[{"content":"呵呵","ocid":168,"fromid":16,"toid":17,"member_list_username":"蜡笔小欣"},{"content":"呵呵呵","ocid":132,"fromid":16,"toid":17,"member_list_username":"蜡笔小欣"}]},{"ocid":81,"fromid":16,"toid":null,"dolikes":0,"second_count":0,"content":"不行不行补习班","addtime":1523414198,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[]},{"ocid":82,"fromid":16,"toid":null,"dolikes":0,"second_count":0,"content":"还在不行吧行吧","addtime":1523414219,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[]},{"ocid":83,"fromid":16,"toid":null,"dolikes":0,"second_count":0,"content":"发VBvGV根本巴巴爸爸","addtime":1523414242,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[]},{"ocid":93,"fromid":2,"toid":null,"dolikes":0,"second_count":0,"content":"65265965","addtime":1523454723,"member_list_headpic":"http://www.jryx9.com/data/upload\\member\\2\\9420146800f517fc.jpg","member_list_username":"yhl18","is_dolikes":false,"item":[]},{"ocid":94,"fromid":2,"toid":null,"dolikes":0,"second_count":0,"content":"00000000","addtime":1523454734,"member_list_headpic":"http://www.jryx9.com/data/upload\\member\\2\\9420146800f517fc.jpg","member_list_username":"yhl18","is_dolikes":false,"item":[]},{"ocid":102,"fromid":17,"toid":null,"dolikes":0,"second_count":0,"content":"12345","addtime":1523776087,"member_list_headpic":"http://www.jryx9.com/data/upload\\member\\17\\8f3b626b7354f8b6.jpg","member_list_username":"Zhiya","is_dolikes":false,"item":[]},{"ocid":107,"fromid":16,"toid":null,"dolikes":0,"second_count":0,"content":"美","addtime":1523839336,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[]},{"ocid":108,"fromid":16,"toid":null,"dolikes":0,"second_count":0,"content":"ucycycycycy","addtime":1523948792,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[]},{"ocid":112,"fromid":16,"toid":null,"dolikes":0,"second_count":0,"content":"ycgcgcgcgcgctv哈哈v好v好v好v","addtime":1523951535,"member_list_headpic":"http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG","member_list_username":"蜡笔小欣","is_dolikes":false,"item":[]}]
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
             * ocid : 65
             * fromid : 16
             * toid : null
             * dolikes : 0
             * second_count : 6
             * content : 啦啦啦德玛西亚
             * addtime : 1523234356
             * member_list_headpic : http://www.jryx9.com/data/upload/member/16/2217a9b5f7424602.JPG
             * member_list_username : 蜡笔小欣
             * is_dolikes : false
             * item : [{"content":"呵呵","ocid":168,"fromid":16,"toid":17,"member_list_username":"蜡笔小欣"},{"content":"呵呵呵","ocid":132,"fromid":16,"toid":17,"member_list_username":"蜡笔小欣"}]
             */

            private int ocid;
            private int fromid;
            private Object toid;
            private int dolikes;
            private int second_count;
            private String content;
            private int addtime;
            private String member_list_headpic;
            private String member_list_username;
            private boolean is_dolikes;
            private List<ItemBean> item;

            public int getOcid() {
                return ocid;
            }

            public void setOcid(int ocid) {
                this.ocid = ocid;
            }

            public int getFromid() {
                return fromid;
            }

            public void setFromid(int fromid) {
                this.fromid = fromid;
            }

            public Object getToid() {
                return toid;
            }

            public void setToid(Object toid) {
                this.toid = toid;
            }

            public int getDolikes() {
                return dolikes;
            }

            public void setDolikes(int dolikes) {
                this.dolikes = dolikes;
            }

            public int getSecond_count() {
                return second_count;
            }

            public void setSecond_count(int second_count) {
                this.second_count = second_count;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getAddtime() {
                return addtime;
            }

            public void setAddtime(int addtime) {
                this.addtime = addtime;
            }

            public String getMember_list_headpic() {
                return member_list_headpic;
            }

            public void setMember_list_headpic(String member_list_headpic) {
                this.member_list_headpic = member_list_headpic;
            }

            public String getMember_list_username() {
                return member_list_username;
            }

            public void setMember_list_username(String member_list_username) {
                this.member_list_username = member_list_username;
            }

            public boolean isIs_dolikes() {
                return is_dolikes;
            }

            public void setIs_dolikes(boolean is_dolikes) {
                this.is_dolikes = is_dolikes;
            }

            public List<ItemBean> getItem() {
                return item;
            }

            public void setItem(List<ItemBean> item) {
                this.item = item;
            }

            public static class ItemBean {
                /**
                 * content : 呵呵
                 * ocid : 168
                 * fromid : 16
                 * toid : 17
                 * member_list_username : 蜡笔小欣
                 */

                private String content;
                private int ocid;
                private int fromid;
                private int toid;
                private String member_list_username;

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public int getOcid() {
                    return ocid;
                }

                public void setOcid(int ocid) {
                    this.ocid = ocid;
                }

                public int getFromid() {
                    return fromid;
                }

                public void setFromid(int fromid) {
                    this.fromid = fromid;
                }

                public int getToid() {
                    return toid;
                }

                public void setToid(int toid) {
                    this.toid = toid;
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
}
