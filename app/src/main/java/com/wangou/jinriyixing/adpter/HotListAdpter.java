package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.tong.library.bean.HotListBean;
import com.wangou.jinriyixing.R;

import java.util.List;

public class HotListAdpter extends CommonAdapter<HotListBean.DataBean.ListBean> {

    public HotListAdpter(Context context, List<HotListBean.DataBean.ListBean> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_conent;
    }

    @Override
    protected void convert(ViewHolder holder, HotListBean.DataBean.ListBean bean, int position) {
        ImageView img = holder.getView(R.id.img);
        Glide.with(mContext).load(bean.getCover()).into(img);
        holder.setText(R.id.tv_title,bean.getTitle())
                .setText(R.id.tv_authorNum,"作品编号："+bean.getCode())
                .setText(R.id.tv_author,"作者："+bean.getMember_list_username())
                .setText(R.id.tv_eyes,bean.getViews()+"")
                .setText(R.id.tv_good,bean.getDolikes()+"")
                .setText(R.id.tv_comment,bean.getCommentcount()+"");
    }
}
