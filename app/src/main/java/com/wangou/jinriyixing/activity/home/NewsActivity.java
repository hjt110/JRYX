package com.wangou.jinriyixing.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tong.library.base.BaseActivity;
import com.tong.library.bean.NewsBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.tong.library.view.CircleImageView;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.utils.DateTimeUtils;
import com.wangou.jinriyixing.utils.ParamUtils;
import com.zzhoujay.richtext.RichText;
import com.zzhoujay.richtext.callback.Callback;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends BaseActivity {

    @BindView(R.id.tv)
    TextView tv;
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
    @BindView(R.id.tv_views)
    TextView tvViews;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_good)
    TextView tvGood;
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
    @BindView(R.id.edit_comment)
    EditText editComment;
    @BindView(R.id.img_comment)
    ImageView imgComment;
    @BindView(R.id.img_read)
    ImageView imgRead;
    @BindView(R.id.img_follow)
    ImageView imgFollow;
    @BindView(R.id.tv_about)
    TextView tvAbout;
    @BindView(R.id.rl_bottom)
    RelativeLayout rlBottom;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_news;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.white);
        setStatusBarIcon(true);
        initContent();
    }

    @Override
    protected void initEvent() {

    }

    private void initContent() {
        String nid = getIntent().getStringExtra("nid");
        Map<String, String> fieldMap = new HashMap<>();
        fieldMap.put("nid", nid);
        Api.getInstance()
                .getNews(ParamUtils.getNormalHeaderMap(), fieldMap)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<NewsBean>() {
                    @Override
                    public void onSuccess(NewsBean newsBean) {
                        if (newsBean.getCode() == 0) {
                            initInfo(newsBean);
                        }
                    }
                });
    }

    private void initInfo(NewsBean newsBean) {
        NewsBean.DataBean data = newsBean.getData();
        Glide.with(getActivity()).load(data.getMember_list_headpic()).into(imgAuthor);
        tvOrgin.setText(data.getMember_list_username());
        tvTitle.setText(data.getNews_title());
        tvViews.setText("阅读" + data.getViews());
        tvTime.setText(DateTimeUtils.getDate("MM-dd", data.getNews_time()));
        RichText.from(data.getNews_content()).singleLoad(false).into(tv);

        Glide.with(getActivity()).load(data.getMember_list_headpic()).into(imgAuthorBottom);
        tvOrginBottom.setText(data.getMember_list_username());
        tvAbout.setText("简介：" + data.getNews_scontent());
        rlBottom.setVisibility(View.VISIBLE);

    }

}
