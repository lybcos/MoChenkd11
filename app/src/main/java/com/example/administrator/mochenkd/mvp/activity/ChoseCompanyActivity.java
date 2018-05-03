package com.example.administrator.mochenkd.mvp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.mochenkd.R;
import com.example.administrator.mochenkd.mvp.adapter.CopAdapter;
import com.example.administrator.mochenkd.mvp.entity.copChoose;

import java.util.ArrayList;
import java.util.List;

public class ChoseCompanyActivity extends AppCompatActivity {
    private List<copChoose> mlist ;
    private CopAdapter copAdapter;
    private ListView lv;
    private ImageView image_back;
    private copChoose copCho=new copChoose();

    private String[]mString={ "sf",
                          "yt",
                          "sto",
                          "zto",
                          "ht",
                          "yd",
                          "tt",
                          "yzgn",
                          "ems",
                          "zjs",
                          "qf",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_company);
        initView();
        initListener();
//        Log.d("KDcop",copCho.getCopName());
    }


    private void initView() {
        lv = findViewById(R.id.lv);
        image_back = findViewById(R.id.image_back);
    }
    private void initListener() {
        initList();
        copAdapter = new CopAdapter(mlist, this);
        copAdapter.setOnItemClickListener(new CopAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                Intent intent = new Intent(ChoseCompanyActivity.this, MainActivity.class);
                intent.putExtra("com",mString[position]);
                       Toast.makeText(ChoseCompanyActivity.this, "你选择的快递公司是", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        lv.setAdapter(copAdapter);
    }

    private void initList() {
        if (mlist==null){
            mlist = new ArrayList<>();
            mlist.add(new copChoose(mString, R.drawable.sf,"顺丰快递","95338"));
            mlist.add(new copChoose(mString, R.drawable.yuantong,"圆通快递","95554"));
            mlist.add(new copChoose(mString, R.drawable.shengtong,"申通快递","95543"));
            mlist.add(new copChoose( mString,R.drawable.zhongtong,"中通快递","95311"));
            mlist.add(new copChoose( mString,R.drawable.baishihuitong,"百世汇通","4009 565656"));
            mlist.add(new copChoose(mString, R.drawable.yunda,"韵达快递","95546"));
            mlist.add(new copChoose( mString,R.drawable.tiantiankuaidi,"天天快递","4001-888-888"));
            mlist.add(new copChoose(mString,R.drawable.youzheng,"邮政快递","11185"));
            mlist.add(new copChoose(mString,R.drawable.ems,"EMS快递","11183"));
            mlist.add(new copChoose(mString,R.drawable.zhaijisong,"宅急送","400-6789-000"));
            mlist.add(new copChoose(mString, R.drawable.quanfeng,"全峰快递","4001-000-001"));
        }

    }
}
