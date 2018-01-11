package pingan.com.my_weiying_app.model;

import java.util.Map;

/**
 * Created by 迷人的脚毛！！ on 2017/12/30.
 */

public interface IModel {
    void getData(String url);
    void getDiscover(String url, Map<String,String> map);
    void getSpecial(String url,Map<String,String> map);
    void getVideo(String url, Map<String,String> map);
    void getPingLun(String url, Map<String,String> map);
    void getSearch(String url, Map<String,String> map);
}
