package com.wangou.jinriyixing.activity.collection;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tong.library.adapter.recyclerview.MultiItemTypeAdapter;
import com.tong.library.base.BaseFragment;
import com.tong.library.bean.BannerBean;
import com.tong.library.bean.CollectionListBean;
import com.tong.library.bean.CollectionTitleBean;
import com.tong.library.bean.HotBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.ContentAdpter;
import com.wangou.jinriyixing.adpter.GuideAdpter;
import com.wangou.jinriyixing.adpter.HotAdpter;
import com.wangou.jinriyixing.base.RequestHelper;
import com.wangou.jinriyixing.utils.GlideImageLoader;
import com.wangou.jinriyixing.utils.ParamUtils;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class HotFragment extends BaseFragment {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.rlv_guide)
    RecyclerView rlvGuide;
    @BindView(R.id.rlv_content)
    RecyclerView rlvContent;
    private int pos;

    private List<CollectionListBean.DataBean.ListBean> dataList = new ArrayList<>();
    private ContentAdpter contentAdpter;
    private List<CollectionTitleBean.DataBean> guideList = new ArrayList<>();
    private GuideAdpter guideAdpter;
    private String type = "0";
    private List<HotBean.DataBean.ListBean> hotList = new ArrayList<>();
    private HotAdpter hotAdpter;

    @SuppressLint("ValidFragment")
    public HotFragment(int pos) {
        this.pos = pos;
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        switch (pos) {
            case 0:
                type = "0";
                break;
            case 2:
                type = "1";
                break;
        }

        RequestHelper.initBanner("14", banner);
        initGuide();

        //征集0，进行2
        if (pos == 0 || pos == 2) {
            contentAdpter = new ContentAdpter(getActivity(), dataList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            rlvContent.setLayoutManager(linearLayoutManager);
            rlvContent.setAdapter(contentAdpter);
            initContent(guideList.get(0).getVmid() + "", type);
        }
        //热门1
        if (pos == 1) {
            hotAdpter = new HotAdpter(getActivity(), hotList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            rlvContent.setLayoutManager(linearLayoutManager);
            rlvContent.setAdapter(hotAdpter);
            initHot(guideList.get(0).getVmid() + "");
        }
    }

    @Override
    protected void initEvent() {
        guideAdpter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                guideAdpter.updateTextCololr(position);
                if (position == guideList.size() - 1) {

                } else {
                    switch (pos) {
                        case 0:
                        case 2:
                            initContent(guideList.get(position).getVmid() + "", type);
                            break;
                        case 1:
                            initHot(guideList.get(position).getVmid() + "");
                            break;
                    }
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

        if (pos == 0 || pos == 2) {
            contentAdpter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                    Intent intent = new Intent(getActivity(), CollectionContentActivity.class);
                    intent.putExtra("soid", dataList.get(position).getOsid() + "");
                    startActivity(intent);
                }

                @Override
                public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                    return false;
                }
            });
        }

        if (pos == 1) {
            hotAdpter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                    Intent intent = new Intent(getActivity(), HotContentActivity.class);
                    intent.putExtra("ossid", hotList.get(position).getOssid()+"");
                    startActivity(intent);
                }

                @Override
                public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                    return false;
                }
            });
        }


    }

    private void initGuide() {
        List<CollectionTitleBean.DataBean> data = ((CollectionFragment) getParentFragment()).getDataList();
        CollectionTitleBean.DataBean dataBean = new CollectionTitleBean.DataBean();
        dataBean.setName("更多");
        guideList.clear();
        guideList.addAll(data);
        guideList.add(dataBean);
        rlvGuide.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        guideAdpter = new GuideAdpter(getActivity(), guideList);
        rlvGuide.setAdapter(guideAdpter);
    }

    private void initContent(String mid, String type) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("mid", mid);
        paramMap.put("type", type);
        paramMap.put("page", "");
        Api.getInstance()
                .getCollectionList(ParamUtils.getNormalHeaderMap(), paramMap)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<CollectionListBean>() {
                    @Override
                    public void onSuccess(CollectionListBean collectionListBean) {
                        if (collectionListBean.getCode() == 0) {
                            CollectionListBean.DataBean info = collectionListBean.getData();
                            List<CollectionListBean.DataBean.ListBean> data = info.getList();
                            dataList.clear();
                            dataList.addAll(data);
                            contentAdpter.notifyDataSetChanged();
                        }
                    }
                });
    }

    private void initHot(String mid) {
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("mid", mid);
        paramMap.put("page", "");
        Api.getInstance()
                .getHotList(ParamUtils.getNormalHeaderMap(), paramMap)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<HotBean>() {
                    @Override
                    public void onSuccess(HotBean hotBean) {
                        if (hotBean.getCode() == 0) {
                            HotBean.DataBean data = hotBean.getData();
                            List<HotBean.DataBean.ListBean> list = data.getList();
                            hotList.clear();
                            hotList.addAll(list);
                            hotAdpter.notifyDataSetChanged();
                        }
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (banner != null) {
            banner.stopAutoPlay();
        }
    }
}
