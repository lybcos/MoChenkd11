package com.example.administrator.mochenkd.HttpData.API;



import com.example.administrator.mochenkd.mvp.entity.KdBeanResults;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2018/4/9.
 */

public interface KdService {
    @GET("/exp/index")
     Observable<KdBeanResults>getDataResults(@Query("key") String key, @Query("com") String com, @Query("no") String no);
}
