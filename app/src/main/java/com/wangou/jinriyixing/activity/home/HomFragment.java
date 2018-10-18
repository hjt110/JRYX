package com.wangou.jinriyixing.activity.home;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tong.library.base.BaseFragment;
import com.tong.library.bean.NewsTitleBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.RxSchedulers;
import com.tong.library.view.PagerSlidingTabStrip;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.ViewPagerAdpter;
import com.wangou.jinriyixing.utils.ParamUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomFragment extends BaseFragment {

    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.titleBar)
    LinearLayout titleBar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.psts)
    PagerSlidingTabStrip psts;

    private List<String> titleList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<NewsTitleBean.DataBean> dataList = new ArrayList<>();
    private ViewPagerAdpter viewPagerAdpter;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_hom;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        initNews();
    }

    @Override
    protected void initEvent() {

    }

    private void initNews() {
        Api.getInstance()
                .getNewsTitle(ParamUtils.getNormalHeaderMap())
                .compose(RxSchedulers.io_main())
                .subscribe(bean -> {
                    if (bean.getCode() == 0) {
                        List<NewsTitleBean.DataBean> data = bean.getData();
                        setDataList(data);
                        for (int i = 0; i < data.size(); i++) {
                            titleList.add(data.get(i).getMenu_name());
                            fragmentList.add(new GeneralFragment(i));
                        }
                        initViewPager();
                    }
                });
    }

    private void initViewPager() {
        viewPagerAdpter = new ViewPagerAdpter(getChildFragmentManager(), titleList, fragmentList);
        viewPager.setAdapter(viewPagerAdpter);
        psts.setViewPager(viewPager);
    }

    protected List<NewsTitleBean.DataBean> getDataList() {
        return dataList;
    }

    protected void setDataList(List<NewsTitleBean.DataBean> dataList) {
        this.dataList = dataList;
    }

}
