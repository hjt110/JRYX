package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.tong.library.bean.CollectionListBean;
import com.wangou.jinriyixing.R;

import java.util.List;

public class ContentAdpter extends CommonAdapter<CollectionListBean.DataBean.ListBean> {
    public ContentAdpter(Context context, List<CollectionListBean.DataBean.ListBean> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_conent;
    }

    @Override
    protected void convert(ViewHolder holder, CollectionListBean.DataBean.ListBean dataBean, int position) {
        ImageView img = holder.getView(R.id.img);
        Glide.with(mContext).load(dataBean.getThumb()).into(img);
        holder.setText(R.id.tv_title,dataBean.getTitle())
                .setText(R.id.tv_authorNum,"作者编号："+dataBean.getSponsorid())
                .setText(R.id.tv_author,"作者："+dataBean.getMember_list_username());
    }
}
