package com.example.administrator.mochenkd.mvp.view;

import com.example.administrator.mochenkd.mvp.entity.KdBeanResults;

/**
 * Created by Administrator on 2018/4/9.
 */

public interface HomeView {
    //显示加载页
    void showProgress();
    //隐藏加载页
    void hideProgress();
    //显示加载失败
    void showLoadFailMsg();
    //加载新数据
    void newDatas(KdBeanResults results);

}
