package com.wangou.jinriyixing.adpter;

import android.content.Context;

import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.wangou.jinriyixing.R;

import java.util.List;

public class ContentAdpter extends CommonAdapter<String> {
    public ContentAdpter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_conent;
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        holder.setText(R.id.tv_title,s);
    }
}
