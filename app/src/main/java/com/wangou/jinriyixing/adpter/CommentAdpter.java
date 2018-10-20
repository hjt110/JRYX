package com.wangou.jinriyixing.adpter;

import android.content.Context;

import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.wangou.jinriyixing.R;

import java.util.List;

public class CommentAdpter extends CommonAdapter<String> {
    public CommentAdpter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_comment;
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {

    }
}
