package com.example.administrator.mochenkd.mvp.presenter;

import com.example.administrator.mochenkd.mvp.activity.OnLoadListener;
import com.example.administrator.mochenkd.mvp.entity.KdBeanResults;
import com.example.administrator.mochenkd.mvp.model.DataKdModel;
import com.example.administrator.mochenkd.mvp.view.HomeView;

/**
 * Created by Administrator on 2018/4/9.
 */

public class HomePresenter implements OnLoadListener<KdBeanResults.ResultBean>{
    private HomeView mView;
    private DataKdModel mModel;

    public HomePresenter(HomeView mView) {
        this.mView = mView;
        mModel = new DataKdModel();
    }

    public void getKdDataResults( boolean isCache, String com, String no, String key) {
        mModel.loadData(this,isCache,com,no,key);
    }

    @Override
    public void OnSuccess(KdBeanResults.ResultBean data) {
        mView.newDatas(data);
    }

    @Override
    public void Error(Throwable e) {
        mView.showLoadFailMsg();
    }
}
