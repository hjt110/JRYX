package com.tong.library.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;


import com.tong.library.adapter.recyclerview.base.ItemViewDelegate;
import com.tong.library.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by sunsh on 18/5/30.
 */
public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T>
{
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public CommonAdapter(final Context context, List<T> datas)
    {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = getLayoutId();
        mDatas = datas;

        addItemViewDelegate(new ItemViewDelegate<T>()
        {
            @Override
            public int getItemViewLayoutId()
            {
                return getLayoutId();
            }

            @Override
            public boolean isForViewType( T item, int position)
            {
                return true;
            }

            @Override
            public void convert(ViewHolder holder, T t, int position)
            {
                CommonAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract int getLayoutId();

    protected abstract void convert(ViewHolder holder, T t, int position);


}
