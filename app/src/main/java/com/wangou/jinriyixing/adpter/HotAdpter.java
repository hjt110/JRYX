package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.tong.library.bean.HotBean;
import com.wangou.jinriyixing.R;

import java.util.List;

public class HotAdpter extends CommonAdapter<HotBean.DataBean.ListBean> {
    public HotAdpter(Context context, List<HotBean.DataBean.ListBean> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_conent;
    }

    @Override
    protected void convert(ViewHolder holder, HotBean.DataBean.ListBean listBean, int position) {
        ImageView img = holder.getView(R.id.img);
        Glide.with(mContext).load(listBean.getCover()).into(img);
        holder.setText(R.id.tv_title, listBean.getTitle())
                .setText(R.id.tv_authorNum, "作者编号：" + listBean.getCode())
                .setText(R.id.tv_author, "作者：" + listBean.getMember_list_username());
    }
}
