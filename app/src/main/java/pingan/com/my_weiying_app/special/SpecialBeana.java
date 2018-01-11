package pingan.com.my_weiying_app.special;

/**
 * Created by 迷人的脚毛！！ on 2018/1/3.
 */

public class SpecialBeana {

    private String moreURL;
    private String title;
    private String pic;


    public SpecialBeana(String moreURL, String title, String pic) {
        this.moreURL = moreURL;
        this.title = title;
        this.pic = pic;
    }
    public SpecialBeana( ) {

    }

    public String getMoreURL() {
        return moreURL;
    }

    public void setMoreURL(String moreURL) {
        this.moreURL = moreURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
