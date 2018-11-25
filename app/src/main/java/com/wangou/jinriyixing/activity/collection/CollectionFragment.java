package com.wangou.jinriyixing.activity.collection;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.tong.library.base.BaseFragment;
import com.tong.library.bean.CollectionTitleBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.ViewPagerAdpter;
import com.wangou.jinriyixing.utils.ParamUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionFragment extends BaseFragment {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.img_search)
    ImageView imgSearch;
    @BindView(R.id.vp)
    ViewPager vp;

    private List<CollectionTitleBean.DataBean> dataList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_collection;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initCollection();
    }

    @Override
    protected void initEvent() {

    }

    private void initCollection() {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("limit","");
        Api.getInstance().getCollectionTitle(ParamUtils.getHeaderMapWithToken(),paramMap)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<CollectionTitleBean>() {
                    @Override
                    public void onSuccess(CollectionTitleBean collectionTitleBean) {
                        if (collectionTitleBean.getCode()==0){
                            List<CollectionTitleBean.DataBean> data = collectionTitleBean.getData();
                            setDataList(data);
                            initTab();
                        }
                    }
                });
    }

    private void initTab() {
        titleList.add("征集");
        titleList.add("热门");
        titleList.add("进行");
        for (int i = 0; i < titleList.size(); i++) {
            fragmentList.add(new HotFragment(i));
        }
        ViewPagerAdpter viewPagerAdpter = new ViewPagerAdpter(getChildFragmentManager(), titleList, fragmentList);
        vp.setAdapter(viewPagerAdpter);
        tablayout.setupWithViewPager(vp);
    }

    public List<CollectionTitleBean.DataBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<CollectionTitleBean.DataBean> dataList) {
        this.dataList = dataList;
    }
}
