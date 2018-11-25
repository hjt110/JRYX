package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.tong.library.bean.CollectionListBean;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.utils.DateTimeUtils;

import java.util.List;

public class ContentAdpter extends CommonAdapter<CollectionListBean.DataBean.ListBean> {
    public ContentAdpter(Context context, List<CollectionListBean.DataBean.ListBean> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_collection;
    }

    @Override
    protected void convert(ViewHolder holder, CollectionListBean.DataBean.ListBean dataBean, int position) {
        ImageView img = holder.getView(R.id.img);
        Glide.with(mContext).load(dataBean.getThumb()).into(img);
        holder.setText(R.id.tv_title,dataBean.getTitle())
                .setText(R.id.tv_brief,dataBean.getBrief())
                .setText(R.id.tv_startTime,"开始时间："+ DateTimeUtils.getDate("yyyy-MM-dd",dataBean.getStart_time()))
                .setText(R.id.tv_voteNum,"投稿人数："+dataBean.getContributions())
                .setText(R.id.tv_finishTime,"截稿时间："+DateTimeUtils.getDate("yyyy-MM-dd",dataBean.getEnd_time()));
    }


}
