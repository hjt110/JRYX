package com.wangou.jinriyixing.adpter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tong.library.bean.NewsContentBean;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.base.APP;
import com.wangou.jinriyixing.utils.DateTimeUtils;
import com.wangou.jinriyixing.utils.LogUtils;

import java.util.List;

public class GeneralAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_BOTTOM = 0;
    private static final int TYPE_RIGHT = 1;
    private static final int TYPE_BOTTOM_3IMAGEVIEW = 2;
    private List<NewsContentBean.DataBean.NewslistBean> dataList;

    public GeneralAdpter(List<NewsContentBean.DataBean.NewslistBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getItemViewType(int position) {
        int TYPE = 0;
        switch (dataList.get(position).getNews_pic_type()) {
            case 0:
                TYPE = TYPE_BOTTOM;
                break;
            case 1:
                TYPE = TYPE_RIGHT;
                break;
            case 2:
                TYPE = TYPE_BOTTOM_3IMAGEVIEW;
                break;
        }
        return TYPE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_RIGHT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_img_right, parent, false);
            return new RightViewHolder(view);
        }
        if (viewType == TYPE_BOTTOM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_img_bottom, parent, false);
            return new BottomViewHolder(view);
        }
        if (viewType == TYPE_BOTTOM_3IMAGEVIEW) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_3img_bottom, parent, false);
            return new Bottom3ImgViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(v -> {
            if (mOnMyItemClick != null) {
                mOnMyItemClick.OnClickItem(holder.itemView, position);
            }
        });
        NewsContentBean.DataBean.NewslistBean dataBean = dataList.get(position);
        if (holder instanceof BottomViewHolder) {
            BottomViewHolder holder1 = (BottomViewHolder) holder;
            holder1.tvTitle.setText(dataBean.getNews_title());
            holder1.tvAuthor.setText(dataBean.getMember_list_username());
            holder1.tvComment.setText(dataBean.getCommentcount() + "评论");
            holder1.tvGiveGood.setText(DateTimeUtils.getDate("MM-dd", dataBean.getNews_time()));
        }
        if (holder instanceof RightViewHolder) {
            RightViewHolder holder1 = (RightViewHolder) holder;
            holder1.tvTitle.setText(dataBean.getNews_title());
            try {
                Glide.with(APP.getContext()).load(dataBean.getNews_pic_allurl().get(0)).into(holder1.img);
            } catch (Exception e) {
                e.printStackTrace();
            }
            holder1.tvAuthor.setText(dataBean.getMember_list_username());
            holder1.tvComment.setText(dataBean.getCommentcount() + "评论");
            holder1.tvTime.setText(DateTimeUtils.getDate("MM-dd", dataBean.getNews_time()));
        }
        if (holder instanceof Bottom3ImgViewHolder) {
            Bottom3ImgViewHolder holder2 = (Bottom3ImgViewHolder) holder;
            holder2.tvTitle.setText(dataBean.getNews_title());
            try {
                Glide.with(APP.getContext()).load(dataBean.getNews_pic_allurl().get(0)).into(holder2.img1);
                Glide.with(APP.getContext()).load(dataBean.getNews_pic_allurl().get(1)).into(holder2.img2);
                Glide.with(APP.getContext()).load(dataBean.getNews_pic_allurl().get(2)).into(holder2.img3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            holder2.tvAuthor.setText(dataBean.getMember_list_username());
            holder2.tvComment.setText(dataBean.getCommentcount() + "评论");
            holder2.tvGiveGood.setText(DateTimeUtils.getDate("MM-dd", dataBean.getNews_time()));
        }
    }

    public void setmOnMyItemClick(OnMyItemClick onMyItemClick) {
        mOnMyItemClick = onMyItemClick;
    }

    private OnMyItemClick mOnMyItemClick;

    public interface OnMyItemClick {
        void OnClickItem(View view, int pos);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class RightViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvComment;
        TextView tvAuthor;
        TextView tvTitle;
        TextView tvTime;

        public RightViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            tvComment = itemView.findViewById(R.id.tv_comment);
            tvTime = itemView.findViewById(R.id.tv_time);
        }
    }

    class Bottom3ImgViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        ImageView img1;
        ImageView img2;
        ImageView img3;
        TextView tvAuthor;
        TextView tvGiveGood;
        TextView tvComment;

        public Bottom3ImgViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            img1 = itemView.findViewById(R.id.img_1);
            img2 = itemView.findViewById(R.id.img_2);
            img3 = itemView.findViewById(R.id.img_3);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            tvGiveGood = itemView.findViewById(R.id.tv_giveGood);
            tvComment = itemView.findViewById(R.id.tv_comment);
        }

    }

    class BottomViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvAuthor;
        TextView tvGiveGood;
        TextView tvComment;

        public BottomViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            tvGiveGood = itemView.findViewById(R.id.tv_giveGood);
            tvComment = itemView.findViewById(R.id.tv_comment);
        }
    }
}
