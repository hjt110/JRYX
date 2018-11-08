package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.tong.library.bean.CircleListBean;
import com.tong.library.view.CircleImageView;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.utils.DateTimeUtils;

import org.w3c.dom.Text;

import java.util.List;

public class CircleAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ONE = 1;
    private static final int TYPE_THREE = 3;
    private static final int TYPE_FOUR = 4;
    private Context mContext;
    private List<CircleListBean.DataBean.ListBean> mDataList;

    public CircleAdpter(Context context, List<CircleListBean.DataBean.ListBean> dataList) {
        this.mContext = context;
        mDataList = dataList;
    }

    @Override
    public int getItemViewType(int position) {
        int TYPE = 1;
        List<String> thumbs = mDataList.get(position).getThumbs();
        switch (thumbs.size()) {
            case 1:
                TYPE = TYPE_ONE;
                break;
            case 3:
                TYPE = TYPE_THREE;
                break;
            case 4:
            case 5:
                TYPE = TYPE_FOUR;
                break;
        }
        return TYPE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.rlv_circle, parent, false);
            return new ViewHolder1(view);
        }
        if (viewType == TYPE_THREE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.rlv_circle_3, parent, false);
            return new ViewHolder3(view);
        }
        if (viewType == TYPE_FOUR) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.rlv_circle_4, parent, false);
            return new ViewHolder4(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CircleListBean.DataBean.ListBean bean = mDataList.get(position);
        if (holder instanceof ViewHolder1) {
            ViewHolder1 holder1 = (ViewHolder1) holder;
            Glide.with(mContext).load(bean.getMember_list_headpic()).into(holder1.imgHeader);
            holder1.tvAuthor.setText(bean.getMember_list_username());
            holder1.tvTime.setText(DateTimeUtils.getDate("MM-dd", bean.getAddtime()));
            holder1.tvContent.setText(bean.getIntroduce());
            holder1.tvEyes.setText(bean.getViews() + "");
            holder1.tvGood.setText(bean.getDolikes() + "");
            holder1.tvShare.setText(bean.getListorder() + "");
            holder1.tvComment.setText(bean.getCommentcount() + "");

            Glide.with(mContext).load(bean.getPics().get(0)).into(holder1.img);

        }
        if (holder instanceof ViewHolder3) {
            ViewHolder3 holder1 = (ViewHolder3) holder;
            Glide.with(mContext).load(bean.getMember_list_headpic()).into(holder1.imgHeader);
            holder1.tvAuthor.setText(bean.getMember_list_username());
            holder1.tvTime.setText(DateTimeUtils.getDate("MM-dd", bean.getAddtime()));
            holder1.tvContent.setText(bean.getIntroduce());
            holder1.tvEyes.setText(bean.getViews() + "");
            holder1.tvGood.setText(bean.getDolikes() + "");
            holder1.tvShare.setText(bean.getListorder() + "");
            holder1.tvComment.setText(bean.getCommentcount() + "");

            Glide.with(mContext).load(bean.getPics().get(0)).into(holder1.img1);
            Glide.with(mContext).load(bean.getPics().get(1)).into(holder1.img2);
            Glide.with(mContext).load(bean.getPics().get(2)).into(holder1.img3);
        }
        if (holder instanceof ViewHolder4) {
            ViewHolder4 holder1 = (ViewHolder4) holder;
            Glide.with(mContext).load(bean.getMember_list_headpic()).into(holder1.imgHeader);
            holder1.tvAuthor.setText(bean.getMember_list_username());
            holder1.tvTime.setText(DateTimeUtils.getDate("MM-dd", bean.getAddtime()));
            holder1.tvContent.setText(bean.getIntroduce());
            holder1.tvEyes.setText(bean.getViews() + "");
            holder1.tvGood.setText(bean.getDolikes() + "");
            holder1.tvShare.setText(bean.getListorder() + "");
            holder1.tvComment.setText(bean.getCommentcount() + "");

            Glide.with(mContext).load(bean.getPics().get(0)).into(holder1.img1);
            Glide.with(mContext).load(bean.getPics().get(1)).into(holder1.img2);
            Glide.with(mContext).load(bean.getPics().get(2)).into(holder1.img3);
            Glide.with(mContext).load(bean.getPics().get(3)).into(holder1.img4);
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        CircleImageView imgHeader;
        TextView tvAuthor;
        TextView tvTime;
        TextView tvFollow;
        TextView tvContent;
        TextView tvEyes;
        TextView tvGood;
        TextView tvShare;
        TextView tvComment;

        ImageView img;

        public ViewHolder1(View itemView) {
            super(itemView);
            imgHeader = itemView.findViewById(R.id.img_header);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvFollow = itemView.findViewById(R.id.tv_follow);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvEyes = itemView.findViewById(R.id.tv_eyes);
            tvGood = itemView.findViewById(R.id.tv_good);
            tvShare = itemView.findViewById(R.id.tv_share);
            tvComment = itemView.findViewById(R.id.tv_comment);

            img = itemView.findViewById(R.id.img);
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {

        CircleImageView imgHeader;
        TextView tvAuthor;
        TextView tvTime;
        TextView tvFollow;
        TextView tvContent;
        TextView tvEyes;
        TextView tvGood;
        TextView tvShare;
        TextView tvComment;

        ImageView img1;
        ImageView img2;
        ImageView img3;

        public ViewHolder3(View itemView) {
            super(itemView);
            imgHeader = itemView.findViewById(R.id.img_header);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvFollow = itemView.findViewById(R.id.tv_follow);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvEyes = itemView.findViewById(R.id.tv_eyes);
            tvGood = itemView.findViewById(R.id.tv_good);
            tvShare = itemView.findViewById(R.id.tv_share);
            tvComment = itemView.findViewById(R.id.tv_comment);

            img1 = itemView.findViewById(R.id.img_1);
            img2 = itemView.findViewById(R.id.img_2);
            img3 = itemView.findViewById(R.id.img_3);
        }
    }

    class ViewHolder4 extends RecyclerView.ViewHolder {

        CircleImageView imgHeader;
        TextView tvAuthor;
        TextView tvTime;
        TextView tvFollow;
        TextView tvContent;
        TextView tvEyes;
        TextView tvGood;
        TextView tvShare;
        TextView tvComment;

        ImageView img1;
        ImageView img2;
        ImageView img3;
        ImageView img4;

        public ViewHolder4(View itemView) {
            super(itemView);
            imgHeader = itemView.findViewById(R.id.img_header);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvFollow = itemView.findViewById(R.id.tv_follow);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvEyes = itemView.findViewById(R.id.tv_eyes);
            tvGood = itemView.findViewById(R.id.tv_good);
            tvShare = itemView.findViewById(R.id.tv_share);
            tvComment = itemView.findViewById(R.id.tv_comment);

            img1 = itemView.findViewById(R.id.img_1);
            img2 = itemView.findViewById(R.id.img_2);
            img3 = itemView.findViewById(R.id.img_3);
            img4 = itemView.findViewById(R.id.img_4);
        }
    }
}
