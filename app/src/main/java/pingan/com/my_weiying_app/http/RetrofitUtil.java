package pingan.com.my_weiying_app.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 迷人的脚毛！！ on 2017/12/30.
 */

public class RetrofitUtil {
    private static volatile RetrofitUtil instant;
    private ApiService apiService;


    private RetrofitUtil(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static RetrofitUtil getInstant(String url){
        if (null==instant){
            synchronized (RetrofitUtil.class){
                if (instant==null){
                    instant=new RetrofitUtil(url);
                }
            }
        }
        return instant;

    }
    public ApiService getApiService(){
        return apiService;
    }
}
