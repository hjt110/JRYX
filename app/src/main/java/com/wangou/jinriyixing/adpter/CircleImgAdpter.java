package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.activity.circle.CircleFragment;

import java.util.List;

public class CircleImgAdpter extends CommonAdapter<String> {
    public CircleImgAdpter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_circleimg;
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        ImageView img = holder.getView(R.id.img);
        Glide.with(mContext).load(s).into(img);
        img.setOnClickListener(v -> CircleFragment.showPop(mContext,mDatas,position));
    }
}
