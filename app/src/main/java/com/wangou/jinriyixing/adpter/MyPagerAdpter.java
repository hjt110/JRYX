package com.wangou.jinriyixing.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wangou.jinriyixing.R;

import java.util.List;

public class MyPagerAdpter extends PagerAdapter {

    private Context mContext;
    private List<String> mDataLit;

    public MyPagerAdpter(Context context, List<String> data) {
        mContext = context;
        mDataLit = data;
    }

    @Override
    public int getCount() {
        return mDataLit.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.img, null);
        container.addView(view);
        ImageView img = view.findViewById(R.id.img);
        Glide.with(mContext).load(mDataLit.get(position)).into(img);
        return view;
    }
}
