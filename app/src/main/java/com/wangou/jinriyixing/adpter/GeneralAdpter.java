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
import com.wangou.jinriyixing.base.BaseApplication;
import com.wangou.jinriyixing.utils.LogUtils;

import java.util.List;

public class GeneralAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_RIGHT = 0;
    private static final int TYPE_BOTTOM = 1;
    private static final int TYPE_BOTTOM_3IMAGEVIEW = 2;
    private List<NewsContentBean.DataBean> dataList;

    public GeneralAdpter(List<NewsContentBean.DataBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getItemViewType(int position) {
        int TYPE = 0;
        switch (dataList.get(position).getNews_pic_type()) {
            case 0:
                TYPE = TYPE_RIGHT;
                break;
            case 1:
                TYPE = TYPE_BOTTOM;
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
        NewsContentBean.DataBean dataBean = dataList.get(position);
        if (holder instanceof BottomViewHolder) {
            BottomViewHolder holder1 = (BottomViewHolder) holder;
            holder1.tvTitle.setText(dataBean.getNews_title());
            Glide.with(BaseApplication.getContext()).load(dataBean.getNews_pic_allurl().toString()).into(holder1.img);
            holder1.tvAuthor.setText(dataBean.getMember_list_username());
        }
        if (holder instanceof Bottom3ImgViewHolder){
            Bottom3ImgViewHolder holder2 = (Bottom3ImgViewHolder) holder;
            holder2.tvTitle.setText(dataBean.getNews_title());
            String s = dataBean.getNews_pic_allurl().toString();
            String[] split = s.substring(1, s.length() - 1).split(",");
            Glide.with(BaseApplication.getContext()).load(split[0]).into(holder2.img1);
            Glide.with(BaseApplication.getContext()).load(split[1]).into(holder2.img2);
            Glide.with(BaseApplication.getContext()).load(split[2]).into(holder2.img3);
            holder2.tvAuthor.setText(dataBean.getMember_list_username());
            LogUtils.e("url1",split[0]);
            LogUtils.e("url2",split[1]);
            LogUtils.e("url3",split[2]);
        }
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class RightViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvTag;
        TextView tvOrigin;

        public RightViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvTag = itemView.findViewById(R.id.tv_tag);
            tvOrigin = itemView.findViewById(R.id.tv_orgin);
        }
    }

    class BottomViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        ImageView img;
        TextView tvAuthor;
        TextView tvGiveGood;
        TextView tvComment;

        public BottomViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            img = itemView.findViewById(R.id.img);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            tvGiveGood = itemView.findViewById(R.id.tv_giveGood);
            tvComment = itemView.findViewById(R.id.tv_comment);
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
}
