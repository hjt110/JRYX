package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.tong.library.bean.CollectionTitleBean;
import com.wangou.jinriyixing.R;

import java.util.ArrayList;
import java.util.List;

public class GuideAdpter extends CommonAdapter<CollectionTitleBean.DataBean> {

    private List<TextView> tvList = new ArrayList<>();

    public GuideAdpter(Context context, List<CollectionTitleBean.DataBean> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_hot;
    }

    @Override
    protected void convert(ViewHolder holder, CollectionTitleBean.DataBean bean, int position) {
        TextView tvContent = holder.getView(R.id.tv);
        tvList.add(tvContent);
        holder.setText(R.id.tv, bean.getName());
        ImageView img = holder.getView(R.id.img);
        if (position == mDatas.size()-1) {
            img.setImageResource(R.mipmap.more);
            updateTextCololr(0);
        } else {
            Glide.with(mContext).load(bean.getPic_android()).into(img);
        }
    }

    public void updateTextCololr(int pos){
        for(TextView tv:tvList){
            tv.setTextColor(mContext.getResources().getColor(R.color.color_4));
        }
        tvList.get(pos).setTextColor(mContext.getResources().getColor(R.color.mainColor));
    }
}
