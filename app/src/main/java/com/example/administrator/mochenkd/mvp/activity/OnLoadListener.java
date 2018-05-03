package com.example.administrator.mochenkd.mvp.activity;

/**
 * Created by Administrator on 2018/4/9.
 */

public interface OnLoadListener<T>{
        void OnSuccess(T Data);
        void Error(Throwable e);
    }

