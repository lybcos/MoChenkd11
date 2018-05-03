package com.example.administrator.mochenkd.HttpData.retrofit;

import com.example.administrator.mochenkd.HttpData.API.CacheProviders;
import com.example.administrator.mochenkd.HttpData.API.KdService;
import com.example.administrator.mochenkd.mvp.entity.KdBeanResults;
import com.example.administrator.mochenkd.utils.FileUtil;

import java.io.File;
import java.util.List;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.Reply;
import io.rx_cache.internal.RxCache;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/4/9.
 */

public class HttpData extends RetrofitUtil {
        private static File file= FileUtil.getcacheDirectory();//获得缓存目录
        public static final String kdUrl="http://v.juhe.cn/exp/index/";
        private static final CacheProviders providers=new RxCache.Builder()
                .persistence(file)
                .using(CacheProviders.class);

        protected KdService kdService = (KdService) getRetrofit(kdUrl).create(KdService.class);

        private static class SingletonHolder{
                private static final HttpData INSTANCE=new HttpData();
        }
        public static HttpData getInstance(){
                return SingletonHolder.INSTANCE;
        }

        public void getHomeInfo(Observer<KdBeanResults> observer, boolean isCache, String com, String no, String key) {
                        Observable observable=kdService.getDataResults(key,com, no );
                        Observable observableCahce = providers.getHomeTypes(observable, new DynamicKey("首页"), new EvictDynamicKey(true)).map(new HttpResultFuncCcche<List<KdBeanResults>>());
                     setSubscribe(observableCahce,observer);
        }

        private static <T> void setSubscribe(Observable<T> observableCahce, Observer<T> observer) {
                observableCahce.subscribeOn(Schedulers.io())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(observer);
        }
        /**
         * 用来统一处理RxCache的结果
         */
        private class HttpResultFuncCcche<T> implements Func1<Reply<T>, T> {

                @Override
                public T call(Reply<T> httpResult) {
                        return httpResult.getData();
                }
        }

}
