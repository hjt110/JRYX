package com.wangou.jinriyixing.activity.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.ViewPagerAdpter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyCollectionActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_article)
    TextView tvArticle;
    @BindView(R.id.line_article)
    View lineArticle;
    @BindView(R.id.rl_article)
    RelativeLayout rlArticle;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.line_collection)
    View lineCollection;
    @BindView(R.id.rl_collection)
    RelativeLayout rlCollection;
    @BindView(R.id.tv_video)
    TextView tvVideo;
    @BindView(R.id.line_video)
    View lineVideo;
    @BindView(R.id.rl_video)
    RelativeLayout rlVideo;
    @BindView(R.id.vp)
    ViewPager vp;

    private List<TextView> tvList = new ArrayList<>();
    private List<View> lineList = new ArrayList<>();

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_my_collection;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.white);
        setStatusBarIcon(true);
        tvTitle.setText("我的收藏");
        initTitle();
        initViewPager();
    }

    @Override
    protected void initEvent() {
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updateColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initTitle() {
        tvList.add(tvArticle);
        tvList.add(tvCollection);
        tvList.add(tvVideo);
        lineList.add(lineArticle);
        lineList.add(lineCollection);
        lineList.add(lineVideo);
    }

    private void initViewPager() {
        List<String> titleList = new ArrayList<>();
        titleList.add("文章");
        titleList.add("征集");
        titleList.add("视频");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MyCollectionFragment());
        fragmentList.add(new MyCollectionFragment());
        fragmentList.add(new MyCollectionFragment());
        ViewPagerAdpter viewPagerAdpter = new ViewPagerAdpter(getSupportFragmentManager(), titleList, fragmentList);
        vp.setAdapter(viewPagerAdpter);
    }

    /**
     * 更新标题颜色
     * @param pos
     */
    private void updateColor(int pos){
        for (int i = 0; i < tvList.size(); i++) {
            tvList.get(i).setTextColor(getResources().getColor(R.color.color_6));
            lineList.get(i).setVisibility(View.INVISIBLE);
        }
        tvList.get(pos).setTextColor(getResources().getColor(R.color.red_little));
        lineList.get(pos).setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.img_back, R.id.rl_article, R.id.rl_collection, R.id.rl_video})
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.rl_article:
                vp.setCurrentItem(0);
                break;
            case R.id.rl_collection:
                vp.setCurrentItem(1);
                break;
            case R.id.rl_video:
                vp.setCurrentItem(2);
                break;
            default:
                break;
        }
    }

}
