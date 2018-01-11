package pingan.com.my_weiying_app.publica;

/**
 * Created by 迷人的脚毛！！ on 2018/1/2.
 */

public class MessageEventa {
    private   String pic;
    private   String title;
    private   String dataId;


    public MessageEventa(String pic, String title, String dataId ) {
        this.pic = pic;
        this.title = title;
        this.dataId = dataId;

    }

    public MessageEventa( ) {

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


}
