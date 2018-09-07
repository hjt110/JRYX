package com.wangou.jinriyixing.adpter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangou.jinriyixing.R;

public class GeneralAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_BOTTOM = 0;
    private static final int TYPE_RIGHT = 1;
    private static final int TYPE_BOTTOM_3IMAGEVIEW = 2;

    @Override
    public int getItemViewType(int position) {
        int TYPE = 0;
        switch (position % 3) {
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

        if (viewType == TYPE_BOTTOM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_img_bottom, parent, false);
            return new BottomViewHolder(view);
        }
        if (viewType == TYPE_RIGHT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_img_right, parent, false);
            return new RightViewHolder(view);
        }
        if (viewType == TYPE_BOTTOM_3IMAGEVIEW){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_3img_bottom, parent, false);
            return new Bottom3ImgViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 10;
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
