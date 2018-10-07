package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.view.View;

import com.bumptech.glide.Glide;
import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.tong.library.bean.VideoListBean;
import com.tong.library.view.CircleImageView;
import com.wangou.jinriyixing.R;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

public class MyVideoAdpter extends CommonAdapter<VideoListBean.DataBean> {

    public MyVideoAdpter(Context context, List<VideoListBean.DataBean> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_my_video;
    }

    @Override
    protected void convert(ViewHolder holder, VideoListBean.DataBean dataBean, int position) {
        JZVideoPlayerStandard video = holder.getView(R.id.video);
        video.setUp(dataBean.getVideo(), JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, dataBean.getTitle());
        Glide.with(mContext).load(dataBean.getCover()).into(video.thumbImageView);
        CircleImageView imgHeader = holder.getView(R.id.img_header);
        Glide.with(mContext).load(dataBean.getMember_list_headpic()).into(imgHeader);
        holder.setText(R.id.tv_author, dataBean.getMember_list_username())
                .setText(R.id.tv_eyes, dataBean.getViews() + "")
                .setText(R.id.tv_comment, dataBean.getCommentcount() + "");
    }

}
