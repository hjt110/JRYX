package com.wangou.jinriyixing.activity.home;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tong.library.adapter.recyclerview.MultiItemTypeAdapter;
import com.tong.library.base.BaseActivity;
import com.tong.library.bean.NewsTitleBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.CustomColumnsAdpter;
import com.wangou.jinriyixing.utils.ParamUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomColumnsActivity extends BaseActivity {
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.img_right)
    ImageView imgRight;
    @BindView(R.id.tv_myColumn)
    TextView tvMyColumn;
    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.rlv_myColumn)
    RecyclerView rlvMyColumn;
    @BindView(R.id.rlv_moreColumn)
    RecyclerView rlvMoreColumn;
    private List<NewsTitleBean.DataBean> customColunmnList = new ArrayList<>();
    private List<NewsTitleBean.DataBean> moreColumnsList = new ArrayList<>();
    private CustomColumnsAdpter customColumnsAdpter;
    private CustomColumnsAdpter moreColumnsAdpter;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_custom_columns;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.white);
        setStatusBarIcon(true);

        tvTitle.setText("栏目定制");

        rlvMyColumn.setLayoutManager(new GridLayoutManager(this, 4) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        customColumnsAdpter = new CustomColumnsAdpter(getActivity(), customColunmnList, true);
        rlvMyColumn.setAdapter(customColumnsAdpter);

        rlvMoreColumn.setLayoutManager(new GridLayoutManager(this, 4) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        moreColumnsAdpter = new CustomColumnsAdpter(this, moreColumnsList, false);
        rlvMoreColumn.setAdapter(moreColumnsAdpter);

        initColumns();
        initMoreColumns();
    }

    @Override
    protected void initEvent() {
        moreColumnsAdpter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                if (customColumnsAdpter.getDatas().size()<5){
                    customColunmnList.add(moreColumnsList.get(position));
                    customColumnsAdpter.notifyDataSetChanged();
                }else {
                    show("最多只能添加5个哦");
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    @OnClick({R.id.img_back,R.id.tv_edit})
    public void onMyClick(View view){
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_edit:
                if(tvEdit.getText().toString().equals("编辑")){
                    tvEdit.setText("完成");
                }else {
                    tvEdit.setText("编辑");
                }
                customColumnsAdpter.startEdit();
                break;
        }
    }

    private void initColumns() {
        Api.getInstance()
                .getNewsTitle(ParamUtils.getHeaderMapWithToken())
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<NewsTitleBean>() {
                    @Override
                    public void onSuccess(NewsTitleBean bean) {
                        if (bean.getCode()==0){
                            List<NewsTitleBean.DataBean> data = bean.getData();
                            customColunmnList.clear();
                            customColunmnList.addAll(data);
                            customColumnsAdpter.notifyDataSetChanged();
                        }
                    }
                });
    }

    private void initMoreColumns() {
        Api.getInstance()
                .getNewsTitle(ParamUtils.getNormalHeaderMap())
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<NewsTitleBean>() {
                    @Override
                    public void onSuccess(NewsTitleBean bean) {
                        if (bean.getCode()==0){
                            List<NewsTitleBean.DataBean> data = bean.getData();
                            moreColumnsList.clear();
                            moreColumnsList.addAll(data);
                            moreColumnsAdpter.notifyDataSetChanged();
                        }
                    }
                });
    }

}
