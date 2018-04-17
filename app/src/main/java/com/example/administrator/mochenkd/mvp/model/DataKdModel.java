package com.example.administrator.mochenkd.mvp.model;

import android.util.Log;

import com.example.administrator.mochenkd.HttpData.retrofit.HttpData;

import com.example.administrator.mochenkd.mvp.activity.OnLoadListener;
import com.example.administrator.mochenkd.mvp.entity.KdBeanResults;

import rx.Observer;

/**
 * Created by Administrator on 2018/4/9.
 */

public class DataKdModel {
    public void loadData(final OnLoadListener onLoadListener, boolean isCache, String com, String no, String key) {
        HttpData.getInstance().getHomeInfo(new Observer<KdBeanResults.ResultBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
            onLoadListener.Error(e);
            }

            @Override
            public void onNext(KdBeanResults.ResultBean resultBean) {
                if (resultBean == null) {
                    Log.d("DataLyb", "6666");
                }
                onLoadListener.OnSuccess(resultBean);
            }


        },isCache,com,no,key);
    }
}
