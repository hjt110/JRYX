package com.wangou.jinriyixing.adpter;

import android.content.Context;

import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.tong.library.bean.CommentBean;
import com.wangou.jinriyixing.R;

import java.util.List;

public class SecondCommentAdpter extends CommonAdapter<CommentBean.DataBean.ListBean.ItemBean> {
    public SecondCommentAdpter(Context context, List<CommentBean.DataBean.ListBean.ItemBean> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_second_comment;
    }

    @Override
    protected void convert(ViewHolder holder, CommentBean.DataBean.ListBean.ItemBean bean, int position) {
        holder.setText(R.id.tv_author, bean.getMember_list_username()).setText(R.id.tv_content, bean.getContent());
    }
}
