package pingan.com.my_weiying_app.my;

/**
 * Created by 迷人的脚毛！！ on 2018/1/2.
 */

public class LishiJiLu {
    private   String pic;
    private   String title;
    private   String dataId;
    private   int index;

    public LishiJiLu(String pic, String title, String dataId, int index) {
        this.pic = pic;
        this.title = title;
        this.dataId = dataId;
        this.index = index;
    }
    public LishiJiLu( ) {

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

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
