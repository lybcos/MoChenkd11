package com.example.administrator.mochenkd.mvp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mochenkd.R;
import com.example.administrator.mochenkd.mvp.adapter.KuaiDiAdapter;
import com.example.administrator.mochenkd.mvp.entity.KdBeanResults;
import com.example.administrator.mochenkd.mvp.entity.KuaiDi;
import com.example.administrator.mochenkd.mvp.presenter.HomePresenter;
import com.example.administrator.mochenkd.mvp.view.HomeView;

import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HomeView{
    private EditText edtCom;
    private RelativeLayout chooseCompany;
    private Button btn_check;
    private String no;
    private String com;
    private HomePresenter presenter;
    private KdBeanResults.ResultBean results;
    private KuaiDiAdapter mAdapter;
    private String AppId="775498389bdbbbf4607abaca96211a90";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mAdapter=new KuaiDiAdapter(this,null);
        presenter = new HomePresenter(MainActivity.this);
    }

//    public static Intent newIntent(Context context, View view, int position, String[]com) {
//        Intent intent = new Intent(context, MainActivity.class);
//        intent.putExtra(MainActivity.COM,com[position]);
//        context.startActivity(intent);
//        return intent;
//    }
    private void initView() {
        chooseCompany = findViewById(R.id.chooseCompany);

        chooseCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChoseCompanyActivity.class);
                startActivity(intent);
            }
        });
        edtCom = findViewById(R.id.edt_com);
        btn_check = findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no=edtCom.getText().toString();
                Intent intent = getIntent();
                com= String.valueOf(intent.getStringExtra("com"));
                getData(false);
                if (results.getResultcode() == "200") {
                    Intent intent1 = new Intent(MainActivity.this, KdDetailActivity.class);
                    startActivity(intent1);
                }else{
                    Toast.makeText(MainActivity.this,results.getReason(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        results = new KdBeanResults.ResultBean();
    }



    private void getData(boolean isCache) {
        presenter.getKdDataResults(isCache,com, no,AppId);
    }
    @Override
    public void newDatas(KdBeanResults.ResultBean results) {
        if (results != null) {
            this.results=results;
            mAdapter.setKdBeanResults(results);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
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
