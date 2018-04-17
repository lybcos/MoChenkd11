package com.example.administrator.mochenkd.mvp.activity;

import com.example.administrator.mochenkd.mvp.entity.KdBeanResults;

/**
 * Created by Administrator on 2018/4/9.
 */

public interface OnLoadListener<T>{
        void OnSuccess(T Data);
        void Error(Throwable e);
    }

