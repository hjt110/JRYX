package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.tong.library.bean.CommentBean;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.utils.DateTimeUtils;

import java.util.List;

public class NewsCommentAdpter extends CommonAdapter<CommentBean.DataBean.ListBean> {
    public NewsCommentAdpter(Context context, List<CommentBean.DataBean.ListBean> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_news_comment;
    }

    @Override
    protected void convert(ViewHolder holder, CommentBean.DataBean.ListBean bean, int position) {
        ImageView imgAuthor = holder.getView(R.id.img_author);
        Glide.with(mContext).load(bean.getMember_list_headpic()).into(imgAuthor);
        holder.setText(R.id.tv_orgin, bean.getMember_list_headpic())
                .setText(R.id.tv_goodNum, bean.getDolikes() + "")
                .setText(R.id.tv_comment, bean.getContent())
                .setText(R.id.tv_time, DateTimeUtils.getDate("MM-dd", bean.getAddtime()))
                .setText(R.id.tv_reply, bean.getItem().size()  + "条回复");
        RecyclerView rlv = holder.getView(R.id.rlv);
        if (bean.getItem().size() > 0) {
            List<CommentBean.DataBean.ListBean.ItemBean> item = bean.getItem();
            rlv.setLayoutManager(new LinearLayoutManager(mContext) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            });
            SecondCommentAdpter secondCommentAdpter = new SecondCommentAdpter(mContext, item);
            rlv.setAdapter(secondCommentAdpter);
        }
        holder.getView(R.id.tv_reply).setOnClickListener(v -> {
            if (bean.getItem().size() > 0) {
                if (rlv.getVisibility() == View.VISIBLE) {
                    rlv.setVisibility(View.GONE);
                } else {
                    rlv.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
