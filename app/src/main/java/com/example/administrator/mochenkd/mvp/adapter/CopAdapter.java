package com.example.administrator.mochenkd.mvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.mochenkd.R;
import com.example.administrator.mochenkd.mvp.entity.KdBeanResults;
import com.example.administrator.mochenkd.mvp.entity.copChoose;
import com.example.administrator.mochenkd.mvp.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/8.
 */

public class CopAdapter extends BaseAdapter {
    private List<copChoose> mlist = new ArrayList<>();
    private Context context;
    private LayoutInflater mInflater;
    private KdBeanResults kdBeanResults;
    public OnItemClickListener clickListeren;
   public  interface  OnItemClickListener{
        void OnItemClick(View view,int position);
    }

    public CopAdapter() {
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListeren) {
        this.clickListeren = onItemClickListeren;
    }
    public List<copChoose> getResults(){
        return mlist;
    }


    public void setZhiHuResults(KdBeanResults zhiHuResults) {
        this.kdBeanResults = zhiHuResults;
        notifyDataSetChanged();
    }
    public CopAdapter(List<copChoose> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView =mInflater.inflate(R.layout.kdcompany_list_item, parent, false);
        }
        MyViewHolder holder = getViewHolder(convertView);
        final copChoose choose = mlist.get(position);
        holder.copIcon.setImageResource(choose.getIcon());
        holder.tv_copName.setText(choose.getCopName());
        holder.tv_copPhone.setText(choose.getCopPhone());
        final String[]com = choose.getCom();

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                    clickListeren.OnItemClick(v,position);
                    }
        });
        return convertView;
    }

    public MyViewHolder getViewHolder(View view) {
        MyViewHolder holder= (MyViewHolder) view.getTag();
        if (holder == null) {
            holder = new MyViewHolder(view);
            view.setTag(holder);
        }
        return holder;
    }
   private class MyViewHolder{
        private TextView tv_copName,tv_copPhone;
        private ImageView copIcon;
       private RelativeLayout relativeLayout;
       public MyViewHolder(View view) {
           tv_copName = view.findViewById(R.id.copName);
           tv_copPhone = view.findViewById(R.id.copPhone);
           copIcon = view.findViewById(R.id.cop_icon);
           relativeLayout = view.findViewById(R.id.relative_layout);
       }
   }

}
