package com.example.administrator.mochenkd.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.mochenkd.R;
import com.example.administrator.mochenkd.mvp.entity.KdBeanResults;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/7.
 */

public class KuaiDiAdapter extends BaseAdapter {

    //印章数据

    private LayoutInflater mInflater;
    private Context context;
    private List<KdBeanResults.ResultBean.ListBean> mList = new ArrayList<>();
    private KdBeanResults resultBean;
    private KdBeanResults.ResultBean resultBeanLYB=new KdBeanResults.ResultBean();
    private static int a;
    private KdBeanResults.ResultBean.ListBean re;

    public void setKdBeanResults(KdBeanResults kdBeanResults) {
        this.resultBean = kdBeanResults;
        resultBeanLYB= resultBean.getResult();
        a = resultBeanLYB.getList().size();
        re = resultBeanLYB.getList().get(1);
        notifyDataSetChanged();
    }

    public List<KdBeanResults.ResultBean.ListBean> getList() {
        return mList;
    }

    public KuaiDiAdapter(Context context, KdBeanResults kdBeanResults) {
        this.resultBean = kdBeanResults;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
//        return resultBeanLYB.getList().size();
//            return resultBean.getResult().getList().size();
         return a;
    }

    @Override
    public Object getItem(int position) {
//        return resultBean.getResult().getList().get(position);
      return re;
//        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.time_item, null);
        }
        ViewHolder holder = getViewHolder(convertView);
        KdBeanResults.ResultBean.ListBean kd = resultBean.getResult().getList().get(position);
        holder.tv_content.setText((CharSequence) re);
        holder.tv_time.setText(kd.getDatetime());
        return convertView;
    }

    /**
     * 获得控件管理对象
     *
     * @param view
     * @return
     */
    private ViewHolder getViewHolder(View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        return holder;
    }

    /**
     * 控件管理类
     */
    private class ViewHolder {
        private TextView tv_content, tv_time;


        ViewHolder(View view) {
            tv_content = (TextView) view.findViewById(R.id.tv_content);
            tv_time = (TextView) view.findViewById(R.id.tv_time);

        }
    }
}