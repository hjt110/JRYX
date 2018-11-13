package com.wangou.jinriyixing.activity.home;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tong.library.base.BaseActivity;
import com.tong.library.bean.CommentBean;
import com.tong.library.bean.GoodBean;
import com.tong.library.bean.NewsBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.tong.library.view.CircleImageView;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.NewsCommentAdpter;
import com.wangou.jinriyixing.utils.DateTimeUtils;
import com.wangou.jinriyixing.utils.ParamUtils;
import com.zzhoujay.richtext.RichText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.rlv)
    RecyclerView rlv;
    private List<CommentBean.DataBean.ListBean> dataList = new ArrayList<>();
    private NewsCommentAdpter newsCommentAdpter;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_news;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.white);
        setStatusBarIcon(true);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        newsCommentAdpter = new NewsCommentAdpter(getActivity(), dataList);
        rlv.setAdapter(newsCommentAdpter);
        initContent();
        initComment("5");
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
                            try {
                                initInfo(newsBean);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    private void initComment(String type) {
        String nid = getIntent().getStringExtra("nid");
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("type", type);
        paramMap.put("ncvid", nid);
        paramMap.put("page", "");
        Api.getInstance()
                .getComment(ParamUtils.getHeaderMapWithToken(), paramMap)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<CommentBean>() {
                    @Override
                    public void onSuccess(CommentBean commentBean) {
                        if (commentBean.getCode() == 0) {
                            CommentBean.DataBean data = commentBean.getData();
                            List<CommentBean.DataBean.ListBean> list = data.getList();
                            dataList.clear();
                            dataList.addAll(list);
                            newsCommentAdpter.notifyDataSetChanged();
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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rlBottom.setVisibility(View.VISIBLE);
            }
        },500);

    }

    @OnClick({R.id.img_back, R.id.img_author, R.id.tv_follow, R.id.img_share, R.id.tv_good})
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_author:
                break;
            case R.id.tv_follow:
                break;
            case R.id.img_share:
                break;
            case R.id.tv_good:
                clickGood("5", getIntent().getStringExtra("nid"));
                break;
        }
    }

    private void clickGood(String type, String ncvid) {
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("type", type);
        paramMap.put("ncvid", ncvid);
        Api.getInstance()
                .clickGood(ParamUtils.getHeaderMapWithToken(), paramMap)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<GoodBean>() {
                    @Override
                    public void onSuccess(GoodBean goodBean) {
                        if (goodBean.getCode() == 0) {
                            GoodBean.DataBean data = goodBean.getData();
                            if (data.getDolikestype()==1){
                                tvGood.setText("已赞");
                            }else {
                                tvGood.setText("赞一下呗");
                            }
                        }
                    }
                });
    }

}
