package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.view.View;

import com.bumptech.glide.Glide;
import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.wangou.jinriyixing.R;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

public class MyVideoAdpter extends CommonAdapter<String> {

    public MyVideoAdpter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_my_video;
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        JZVideoPlayerStandard video = holder.getView(R.id.video);
        video.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4", JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "饺子闭眼睛");
        Glide.with(mContext).load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640").into(video.thumbImageView);
    }
}
