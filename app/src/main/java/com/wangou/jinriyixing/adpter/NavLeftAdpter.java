package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.tong.library.adapter.recyclerview.CommonAdapter;
import com.tong.library.adapter.recyclerview.base.ViewHolder;
import com.wangou.jinriyixing.R;

import java.util.List;

public class NavLeftAdpter extends CommonAdapter<String> {

    public NavLeftAdpter(Context context, List<String> datas) {
        super(context,  datas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.nav_left;
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        holder.setText(R.id.tv_title,s);
        ImageView img = holder.getView(R.id.img);
        switch (position){
            case 0:
                img.setImageResource(R.mipmap.circle_small);
                break;
            case 1:
                img.setImageResource(R.mipmap.collection);
                break;
            case 2:
                img.setImageResource(R.mipmap.edit);
                break;
            case 3:
                img.setImageResource(R.mipmap.card);
                break;
            case 4:
                img.setImageResource(R.mipmap.manager);
                break;
            case 5:
                img.setImageResource(R.mipmap.message);
                break;
            case 6:
                img.setImageResource(R.mipmap.feed_back);
                holder.getView(R.id.line_bottom).setVisibility(View.VISIBLE);
                break;
        }
    }
}
