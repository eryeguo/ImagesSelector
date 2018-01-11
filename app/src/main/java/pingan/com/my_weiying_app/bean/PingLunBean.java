package pingan.com.my_weiying_app.bean;

import java.util.List;

/**
 * Created by 迷人的脚毛！！ on 2018/1/1.
 */

public class PingLunBean {


    /**
     * msg : 成功
     * ret : {"pnum":1,"totalRecords":4,"records":20,"list":[{"msg":"超喜欢男神的这部片子，就是喜欢。","phoneNumber":"悲伤的恋曲","dataId":"ff8080815c5dce45015c5e77b07c0675","userPic":"","time":"2017-05-25 15:25:21","likeNum":0},{"msg":"没想到这个电影在手机电影APP里居然可以看到，赞一个。","phoneNumber":"伪装坚强","dataId":"ff8080815c5dce45015c5e77b0790673","userPic":"","time":"2017-05-19 20:25:21","likeNum":0},{"msg":"呵呵，这种电影，不想评价更多！","phoneNumber":"忧别人之忧","dataId":"ff8080815c5dce45015c5e77b0760672","userPic":"","time":"2017-05-18 11:25:21","likeNum":0},{"msg":"这片子早就应该看了，幸好没有错过这么好的片子。","phoneNumber":"陌路丢了谁","dataId":"ff8080815c5dce45015c5e77b07b0674","userPic":"","time":"2017-05-15 19:25:21","likeNum":0}],"totalPnum":1}
     * code : 200
     */

    private String msg;
    private RetBean ret;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RetBean getRet() {
        return ret;
    }

    public void setRet(RetBean ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class RetBean {
        /**
         * pnum : 1
         * totalRecords : 4
         * records : 20
         * list : [{"msg":"超喜欢男神的这部片子，就是喜欢。","phoneNumber":"悲伤的恋曲","dataId":"ff8080815c5dce45015c5e77b07c0675","userPic":"","time":"2017-05-25 15:25:21","likeNum":0},{"msg":"没想到这个电影在手机电影APP里居然可以看到，赞一个。","phoneNumber":"伪装坚强","dataId":"ff8080815c5dce45015c5e77b0790673","userPic":"","time":"2017-05-19 20:25:21","likeNum":0},{"msg":"呵呵，这种电影，不想评价更多！","phoneNumber":"忧别人之忧","dataId":"ff8080815c5dce45015c5e77b0760672","userPic":"","time":"2017-05-18 11:25:21","likeNum":0},{"msg":"这片子早就应该看了，幸好没有错过这么好的片子。","phoneNumber":"陌路丢了谁","dataId":"ff8080815c5dce45015c5e77b07b0674","userPic":"","time":"2017-05-15 19:25:21","likeNum":0}]
         * totalPnum : 1
         */

        private int pnum;
        private int totalRecords;
        private int records;
        private int totalPnum;
        private List<ListBean> list;

        public int getPnum() {
            return pnum;
        }

        public void setPnum(int pnum) {
            this.pnum = pnum;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public int getTotalPnum() {
            return totalPnum;
        }

        public void setTotalPnum(int totalPnum) {
            this.totalPnum = totalPnum;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * msg : 超喜欢男神的这部片子，就是喜欢。
             * phoneNumber : 悲伤的恋曲
             * dataId : ff8080815c5dce45015c5e77b07c0675
             * userPic :
             * time : 2017-05-25 15:25:21
             * likeNum : 0
             */

            private String msg;
            private String phoneNumber;
            private String dataId;
            private String userPic;
            private String time;
            private int likeNum;

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public String getUserPic() {
                return userPic;
            }

            public void setUserPic(String userPic) {
                this.userPic = userPic;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }
        }
    }
}
