package com.wangou.jinriyixing.adpter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.tong.library.bean.CircleListBean;
import com.tong.library.view.CircleImageView;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.activity.circle.CircleFragment;
import com.wangou.jinriyixing.activity.main.MainActivity;
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
            default:
                TYPE = TYPE_THREE;
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
            holder1.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CircleFragment.showPop(mContext, bean.getPics(), 0);
                }
            });

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

            holder1.rlv.setLayoutManager(new GridLayoutManager(mContext, 3));
            CircleImgAdpter circleImgAdpter = new CircleImgAdpter(mContext, bean.getPics());
            holder1.rlv.setAdapter(circleImgAdpter);

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

        RecyclerView rlv;

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

            rlv = itemView.findViewById(R.id.rlv);
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
