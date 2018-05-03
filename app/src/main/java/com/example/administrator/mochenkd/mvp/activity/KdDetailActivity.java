package com.example.administrator.mochenkd.mvp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.administrator.mochenkd.R;
import com.example.administrator.mochenkd.mvp.adapter.KuaiDiAdapter;
import com.example.administrator.mochenkd.mvp.entity.KdBeanResults;
import com.example.administrator.mochenkd.mvp.view.HomeView;

public class KdDetailActivity extends AppCompatActivity implements HomeView {
     private KuaiDiAdapter adapter;
     private ListView lv_detail;
     private KdBeanResults kd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kd_detail);
        lv_detail = findViewById(R.id.lv_detail);
        kd = new KdBeanResults();
        adapter=new KuaiDiAdapter(this,kd);
        lv_detail.setAdapter(adapter);

    }

    @Override
    public void newDatas(KdBeanResults results) {
        if (results != null) {
            kd=results;
            adapter.setKdBeanResults(results);
        }
    }
    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showLoadFailMsg() {

    }


}
