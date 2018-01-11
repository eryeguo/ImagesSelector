package pingan.com.my_weiying_app.bean;

/**
 * Created by 迷人的脚毛！！ on 2018/1/1.
 */

public class Lista {
    private String moreURL;
    private String title;

    public Lista(String moreURL, String title) {
        this.moreURL = moreURL;
        this.title = title;
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
}
