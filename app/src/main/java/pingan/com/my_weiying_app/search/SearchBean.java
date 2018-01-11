package pingan.com.my_weiying_app.search;

import java.util.List;

/**
 * Created by 迷人的脚毛！！ on 2018/1/3.
 */

public class SearchBean {

    /**
     * msg : 成功
     * ret : {"all":"3","movieNum":"0","pnum":1,"totalRecords":3,"trailerNum":"1","informationNum":"2","records":100,"otherNum":"0","list":[{"airTime":0,"angleIcon":"","director":"","videoType":"","description":"出席：艾伦、马丽","pic":"http://y1.cnliveimg.com:8080/image/itv/2017/0823/601627070edb406aa1c32e91c476ea87_101.jpg","title":"《羞羞的铁拳》发布会","duration":"01:04:35","loadtype":"video","actors":"","score":0,"dataId":"88601627070edb406aa1c32e91c476ea87","loadURL":"http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=88601627070edb406aa1c32e91c476ea87","shareURL":"http://h5.svipmovie.com/zxgl/88601627070edb406aa1c32e91c476ea87.shtml?fromTo=shoujimovie","region":""},{"airTime":2017,"angleIcon":"","director":"宋阳 / 张吃鱼","videoType":"","description":"　男主角艾迪生本是一个想要成为拳王的男人，自从三年前被吴良打断手臂后，他就放弃了拳手自尊，和黑道健哥勾结打假拳，令他没想到的是，健哥的女儿，竟然是那个专门揭发假拳、专门和他作对的麻辣女记者马小\u2026\u2026","pic":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/07/25/1500973613313029132.jpg","title":"《羞羞的铁拳 》先行版预告","duration":"00:01:08","loadtype":"video","actors":"艾伦 / 马丽 / 沈腾 / 宋阳 / 田雨","score":0,"dataId":"8e3b2acc18374b279a37945c13013d8c","loadURL":"http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=8e3b2acc18374b279a37945c13013d8c","shareURL":"http://h5.svipmovie.com/xpsd/8e3b2acc18374b279a37945c13013d8c.shtml?fromTo=shoujimovie","region":"内地"},{"airTime":2016,"angleIcon":"","director":"","videoType":"","description":"@TV娱乐前线：宋丹丹还演过这样的田小娥？有点羞羞哒。","pic":"http://y3.cnliveimg.com:8080/image/itv/2016/0501/eae23d299fcc4698bc52104ae2cd8ab1_120210_116.jpg","title":"宋丹丹版田小娥羞羞哒","duration":"00:01:08","loadtype":"video","actors":"","score":0,"dataId":"eae23d299fcc4698bc52104ae2cd8ab1","loadURL":"http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=eae23d299fcc4698bc52104ae2cd8ab1","shareURL":"http://h5.svipmovie.com/zxgl/eae23d299fcc4698bc52104ae2cd8ab1.shtml?fromTo=shoujimovie","region":""}],"totalPnum":1}
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
         * all : 3
         * movieNum : 0
         * pnum : 1
         * totalRecords : 3
         * trailerNum : 1
         * informationNum : 2
         * records : 100
         * otherNum : 0
         * list : [{"airTime":0,"angleIcon":"","director":"","videoType":"","description":"出席：艾伦、马丽","pic":"http://y1.cnliveimg.com:8080/image/itv/2017/0823/601627070edb406aa1c32e91c476ea87_101.jpg","title":"《羞羞的铁拳》发布会","duration":"01:04:35","loadtype":"video","actors":"","score":0,"dataId":"88601627070edb406aa1c32e91c476ea87","loadURL":"http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=88601627070edb406aa1c32e91c476ea87","shareURL":"http://h5.svipmovie.com/zxgl/88601627070edb406aa1c32e91c476ea87.shtml?fromTo=shoujimovie","region":""},{"airTime":2017,"angleIcon":"","director":"宋阳 / 张吃鱼","videoType":"","description":"　男主角艾迪生本是一个想要成为拳王的男人，自从三年前被吴良打断手臂后，他就放弃了拳手自尊，和黑道健哥勾结打假拳，令他没想到的是，健哥的女儿，竟然是那个专门揭发假拳、专门和他作对的麻辣女记者马小\u2026\u2026","pic":"http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/07/25/1500973613313029132.jpg","title":"《羞羞的铁拳 》先行版预告","duration":"00:01:08","loadtype":"video","actors":"艾伦 / 马丽 / 沈腾 / 宋阳 / 田雨","score":0,"dataId":"8e3b2acc18374b279a37945c13013d8c","loadURL":"http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=8e3b2acc18374b279a37945c13013d8c","shareURL":"http://h5.svipmovie.com/xpsd/8e3b2acc18374b279a37945c13013d8c.shtml?fromTo=shoujimovie","region":"内地"},{"airTime":2016,"angleIcon":"","director":"","videoType":"","description":"@TV娱乐前线：宋丹丹还演过这样的田小娥？有点羞羞哒。","pic":"http://y3.cnliveimg.com:8080/image/itv/2016/0501/eae23d299fcc4698bc52104ae2cd8ab1_120210_116.jpg","title":"宋丹丹版田小娥羞羞哒","duration":"00:01:08","loadtype":"video","actors":"","score":0,"dataId":"eae23d299fcc4698bc52104ae2cd8ab1","loadURL":"http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=eae23d299fcc4698bc52104ae2cd8ab1","shareURL":"http://h5.svipmovie.com/zxgl/eae23d299fcc4698bc52104ae2cd8ab1.shtml?fromTo=shoujimovie","region":""}]
         * totalPnum : 1
         */

        private String all;
        private String movieNum;
        private int pnum;
        private int totalRecords;
        private String trailerNum;
        private String informationNum;
        private int records;
        private String otherNum;
        private int totalPnum;
        private List<ListBean> list;

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }

        public String getMovieNum() {
            return movieNum;
        }

        public void setMovieNum(String movieNum) {
            this.movieNum = movieNum;
        }

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

        public String getTrailerNum() {
            return trailerNum;
        }

        public void setTrailerNum(String trailerNum) {
            this.trailerNum = trailerNum;
        }

        public String getInformationNum() {
            return informationNum;
        }

        public void setInformationNum(String informationNum) {
            this.informationNum = informationNum;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public String getOtherNum() {
            return otherNum;
        }

        public void setOtherNum(String otherNum) {
            this.otherNum = otherNum;
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
             * airTime : 0
             * angleIcon :
             * director :
             * videoType :
             * description : 出席：艾伦、马丽
             * pic : http://y1.cnliveimg.com:8080/image/itv/2017/0823/601627070edb406aa1c32e91c476ea87_101.jpg
             * title : 《羞羞的铁拳》发布会
             * duration : 01:04:35
             * loadtype : video
             * actors :
             * score : 0
             * dataId : 88601627070edb406aa1c32e91c476ea87
             * loadURL : http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=88601627070edb406aa1c32e91c476ea87
             * shareURL : http://h5.svipmovie.com/zxgl/88601627070edb406aa1c32e91c476ea87.shtml?fromTo=shoujimovie
             * region :
             */

            private int airTime;
            private String angleIcon;
            private String director;
            private String videoType;
            private String description;
            private String pic;
            private String title;
            private String duration;
            private String loadtype;
            private String actors;
            private int score;
            private String dataId;
            private String loadURL;
            private String shareURL;
            private String region;

            public int getAirTime() {
                return airTime;
            }

            public void setAirTime(int airTime) {
                this.airTime = airTime;
            }

            public String getAngleIcon() {
                return angleIcon;
            }

            public void setAngleIcon(String angleIcon) {
                this.angleIcon = angleIcon;
            }

            public String getDirector() {
                return director;
            }

            public void setDirector(String director) {
                this.director = director;
            }

            public String getVideoType() {
                return videoType;
            }

            public void setVideoType(String videoType) {
                this.videoType = videoType;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getLoadtype() {
                return loadtype;
            }

            public void setLoadtype(String loadtype) {
                this.loadtype = loadtype;
            }

            public String getActors() {
                return actors;
            }

            public void setActors(String actors) {
                this.actors = actors;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public String getLoadURL() {
                return loadURL;
            }

            public void setLoadURL(String loadURL) {
                this.loadURL = loadURL;
            }

            public String getShareURL() {
                return shareURL;
            }

            public void setShareURL(String shareURL) {
                this.shareURL = shareURL;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }
        }
    }
}
