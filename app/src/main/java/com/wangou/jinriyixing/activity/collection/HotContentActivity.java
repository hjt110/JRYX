package com.wangou.jinriyixing.activity.collection;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tong.library.base.BaseActivity;
import com.tong.library.bean.CollectionContentBean;
import com.tong.library.bean.HotContentBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.tong.library.view.CircleImageView;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.utils.DateTimeUtils;
import com.wangou.jinriyixing.utils.ParamUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class HotContentActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img_author)
    CircleImageView imgAuthor;
    @BindView(R.id.tv_orgin)
    TextView tvOrgin;
    @BindView(R.id.img_share)
    ImageView imgShare;
    @BindView(R.id.tv_follow)
    TextView tvFollow;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_comment)
    TextView tvComment;
    @BindView(R.id.tv_views)
    TextView tvViews;
    @BindView(R.id.tv_goodNum)
    TextView tvGoodNum;
    @BindView(R.id.tv_subheading)
    TextView tvSubheading;
    @BindView(R.id.img_cover)
    ImageView imgCover;
    @BindView(R.id.tv_vote)
    TextView tvVote;
    @BindView(R.id.img_author_bottom)
    CircleImageView imgAuthorBottom;
    @BindView(R.id.tv_orgin_bottom)
    TextView tvOrginBottom;
    @BindView(R.id.tv_follow_bottom)
    TextView tvFollowBottom;
    @BindView(R.id.tv_fansNum)
    TextView tvFansNum;
    @BindView(R.id.tv_followNum)
    TextView tvFollowNum;
    @BindView(R.id.tv_readNum)
    TextView tvReadNum;
    @BindView(R.id.tv_about)
    TextView tvAbout;
    @BindView(R.id.rl_bottom)
    RelativeLayout rlBottom;
    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.edit_comment)
    EditText editComment;
    @BindView(R.id.img_comment)
    ImageView imgComment;
    @BindView(R.id.img_read)
    ImageView imgRead;
    @BindView(R.id.img_follow)
    ImageView imgFollow;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_hot_content;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        String ossid = getIntent().getStringExtra("ossid");
        initContent(ossid);
    }

    @Override
    protected void initEvent() {

    }

    private void initContent(String ossid) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("osssid", ossid);
        Api.getInstance()
                .getHotContent(ParamUtils.getHeaderMapWithToken(), paramMap)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<HotContentBean>() {
                    @Override
                    public void onSuccess(HotContentBean hotContentBean) {
                        if (hotContentBean.getCode() == 0) {
                            HotContentBean.DataBean data = hotContentBean.getData();
                            Glide.with(getActivity()).load(data.getFriend_data().getMember_list_headpic()).into(imgAuthor);
                            tvOrgin.setText(data.getFriend_data().getMember_list_username());
                            tvTitle.setText(data.getSubmission().getTitle());
                            tvDate.setText(DateTimeUtils.getDate("yyyy-MM-dd",data.getSubmission().getAddtime()));
                            tvComment.setText(data.getSubmission().getCommentcount()+"评");
                            tvViews.setText(data.getSubmission().getViews()+"阅");
                            tvGoodNum.setText(data.getSubmission().getDolikes()+"赞");
                            tvSubheading.setText(data.getSubmission().getSolicitationtitle());
                            Glide.with(getActivity()).load(data.getSubmission().getCover()).into(imgCover);

                            Glide.with(getActivity()).load(data.getFriend_data().getMember_list_headpic()).into(imgAuthorBottom);
                            tvOrginBottom.setText(data.getFriend_data().getMember_list_username());
                            tvFansNum.setText("粉丝："+data.getFriend_data().getFansnum());
                            tvFollowNum.setText("关注："+data.getFriend_data().getFollownum());
                            tvReadNum.setText("阅读："+data.getFriend_data().getReadnum());
                            tvAbout.setText("简介："+data.getFriend_data().getExplains());
                        }
                    }
                });
    }

}
