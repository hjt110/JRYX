package com.wangou.jinriyixing.adpter;

import android.content.Context;

import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.wangou.jinriyixing.R;

import java.util.List;

public class MessageAdpter extends CommonAdapter<String> {
    public MessageAdpter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_message;
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {

    }
}
