package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.wangou.jinriyixing.R;

import java.util.List;

public class PrivateLetterAdpter extends CommonAdapter<String> {

    public PrivateLetterAdpter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_privateletter;
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        RecyclerView rlv = holder.getView(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(mContext));
        CommentAdpter commentAdpter = new CommentAdpter(mContext, mDatas);
        rlv.setAdapter(commentAdpter);
    }
}
