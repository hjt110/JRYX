package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.wangou.jinriyixing.R;

import java.util.List;

public class GuideAdpter extends CommonAdapter<String> {

    public GuideAdpter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rlv_hot;
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        holder.setText(R.id.tv,s);
        ImageView img = holder.getView(R.id.img);
        switch (position){
            case 0:
                img.setImageResource(R.mipmap.word);
                break;
            case 1:
                img.setImageResource(R.mipmap.poetry);
                break;
            case 2:
                img.setImageResource(R.mipmap.couplet);
                break;
            case 3:
                img.setImageResource(R.mipmap.article2);
                break;
            case 4:
                img.setImageResource(R.mipmap.pen);
                break;
            case 5:
                img.setImageResource(R.mipmap.more);
                break;
        }
    }
}
