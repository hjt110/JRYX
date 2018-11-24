package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.tong.library.bean.NewsTitleBean;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomColumnsAdpter extends CommonAdapter<NewsTitleBean.DataBean> {
    private boolean isMyColumns;
    private List<ImageView> imgList = new ArrayList<>();

    public CustomColumnsAdpter(Context context, List<NewsTitleBean.DataBean> datas, boolean isMyColumns) {
        super(context, datas);
        this.isMyColumns = isMyColumns;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_custom_columns;
    }

    @Override
    protected void convert(ViewHolder holder, NewsTitleBean.DataBean dataBean, int position) {
        if (isMyColumns) {
            holder.setText(R.id.tv_content, dataBean.getMenu_name());
            ImageView img = holder.getView(R.id.img_close);
            imgList.add(img);
            img.setOnClickListener(v -> {
                if (mDatas.size()==1){
                    Toast.makeText(mContext,"不能少于一个",Toast.LENGTH_SHORT).show();
                    return;
                }
                int layoutPosition = holder.getLayoutPosition();
                imgList.remove(layoutPosition);
                mDatas.remove(layoutPosition);
                notifyItemRemoved(layoutPosition);
            });
        } else {
            holder.setText(R.id.tv_content, "+" + dataBean.getMenu_name());
        }
    }

    public void startEdit() {
        if (imgList.size() == 0) {
            return;
        }
        if (imgList.get(0).getVisibility() == View.VISIBLE) {
            for (ImageView img : imgList) {
                img.setVisibility(View.GONE);
            }
        } else {
            for (ImageView img : imgList) {
                img.setVisibility(View.VISIBLE);
            }
        }
    }

}
