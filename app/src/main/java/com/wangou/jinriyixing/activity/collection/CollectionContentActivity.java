package com.wangou.jinriyixing.activity.collection;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tong.library.base.BaseActivity;
import com.tong.library.bean.CollectionContentBean;
import com.tong.library.bean.HotListBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.HotListAdpter;
import com.wangou.jinriyixing.utils.ParamUtils;
import com.zzhoujay.richtext.RichText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectionContentActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.img_share)
    ImageView imgShare;
    @BindView(R.id.img_cover)
    ImageView imgCover;
    @BindView(R.id.tv_viewDetail)
    TextView tvViewDetail;
    @BindView(R.id.tv_contribute)
    TextView tvContribute;
    @BindView(R.id.tv_vote)
    TextView tvVote;
    @BindView(R.id.tv_views)
    TextView tvViews;
    @BindView(R.id.edit_search)
    EditText editSearch;
    @BindView(R.id.img_search)
    ImageView imgSearch;
    @BindView(R.id.tv_hot)
    TextView tvHot;
    @BindView(R.id.line_hot)
    View lineHot;
    @BindView(R.id.tv_newest)
    TextView tvNewest;
    @BindView(R.id.line_newest)
    View lineNewest;
    @BindView(R.id.rlv_hot)
    RecyclerView rlvHot;
    @BindView(R.id.rlv_newest)
    RecyclerView rlvNewest;
    @BindView(R.id.rl_hot)
    RelativeLayout rlHot;
    @BindView(R.id.rl_newest)
    RelativeLayout rlNewest;

    private List<CollectionContentBean.DataBean> dataList = new ArrayList<>();
    private List<HotListBean.DataBean.ListBean> hotList = new ArrayList<>();
    private List<HotListBean.DataBean.ListBean> newestList = new ArrayList<>();
    private HotListAdpter hotListAdpter;
    private HotListAdpter newestAdpter;
    private String soid;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_collection_content;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.white);
        setStatusBarIcon(true);

        soid = getIntent().getStringExtra("soid");
        initContent(soid);
        rlvHot.setLayoutManager(new LinearLayoutManager(getActivity()));
        hotListAdpter = new HotListAdpter(getActivity(), hotList);
        rlvHot.setAdapter(hotListAdpter);
        rlvNewest.setLayoutManager(new LinearLayoutManager(getActivity()));
        newestAdpter = new HotListAdpter(getActivity(), newestList);
        rlvNewest.setAdapter(newestAdpter);
        initList(soid, "1", "0", "");
        initList(soid, "2", "0", "");
    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.img_back, R.id.img_share, R.id.tv_viewDetail, R.id.tv_contribute, R.id.rl_hot, R.id.rl_newest,R.id.img_search})
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_share:
                break;
            case R.id.tv_viewDetail:
                showDetail(getActivity(), dataList.get(0));
                break;
            case R.id.tv_contribute:
                break;
            case R.id.rl_hot:
                lineHot.setVisibility(View.VISIBLE);
                lineNewest.setVisibility(View.GONE);
                rlvHot.setVisibility(View.VISIBLE);
                rlvNewest.setVisibility(View.GONE);
                break;
            case R.id.rl_newest:
                lineHot.setVisibility(View.GONE);
                lineNewest.setVisibility(View.VISIBLE);
                rlvHot.setVisibility(View.GONE);
                rlvNewest.setVisibility(View.VISIBLE);
                break;
            case R.id.img_search:
                initList(soid, "1", "0", editSearch.getText().toString());
                initList(soid, "2", "0", editSearch.getText().toString());
                break;
        }
    }

    private void initContent(String soid) {
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("soid", soid);
        Api.getInstance()
                .getCollectionContent(ParamUtils.getNormalHeaderMap(), paramMap)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<CollectionContentBean>() {
                    @Override
                    public void onSuccess(CollectionContentBean collectionContentBean) {
                        if (collectionContentBean.getCode() == 0) {
                            CollectionContentBean.DataBean data = collectionContentBean.getData();
                            dataList.clear();
                            dataList.add(data);
                            tvTitle.setText(data.getTitle());
                            Glide.with(getActivity()).load(data.getPic()).into(imgCover);
                            tvVote.setText("投稿" + data.getContributions());
                            tvViews.setText("阅读" + data.getViews());
                        }
                    }
                });
    }

    private void initList(String soid, String type, String page, String searchtext) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("soid", soid);
        paramMap.put("type", type);
        paramMap.put("page", page);
        paramMap.put("seachtext", searchtext);
        Api.getInstance()
                .getHotOrNewestList(ParamUtils.getNormalHeaderMap(), paramMap)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<HotListBean>() {
                    @Override
                    public void onSuccess(HotListBean hotListBean) {
                        if (hotListBean.getCode() == 0) {
                            HotListBean.DataBean data = hotListBean.getData();
                            List<HotListBean.DataBean.ListBean> list = data.getList();
                            if (type.equals("1")){
                                hotList.clear();
                                hotList.addAll(list);
                                hotListAdpter.notifyDataSetChanged();
                            }else {
                                newestList.clear();
                                newestList.addAll(list);
                                newestAdpter.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }

    /**
     * 弹出详情
     *
     * @param context
     * @param bean
     */
    public static void showDetail(Context context, CollectionContentBean.DataBean bean) {
        View view = LayoutInflater.from(context).inflate(R.layout.pop_service, null);
        TextView tv_content = view.findViewById(R.id.tv_content);
        ImageView img_close = view.findViewById(R.id.img_close);
        RichText.from(bean.getIntroduce()).singleLoad(false).into(tv_content);
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.showAtLocation(((Activity) context).getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        img_close.setOnClickListener(v -> popupWindow.dismiss());
    }

}
