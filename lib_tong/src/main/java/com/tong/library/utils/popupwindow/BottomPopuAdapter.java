package com.tong.library.utils.popupwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tong.library.R;

import java.util.List;


/**
 * Created by Administrator on 2016/8/25.
 */
public class BottomPopuAdapter extends BaseAdapter {
    private List<String> lstImageItem;
    private Context mContext;
    private boolean isSet;
    private List<Integer> posList;
    private List<Integer> colorList;
    private float itemTextSize;

    public BottomPopuAdapter(Context mContext, List<String> arg0, boolean isSet, List<Integer> posList, List<Integer> colorList, float itemTextSize) {
        this.lstImageItem = arg0;
        this.mContext = mContext;
        this.isSet = isSet;
        this.posList = posList;
        this.colorList = colorList;
        this.itemTextSize = itemTextSize;
    }

    public int getCount() {
        return lstImageItem.size();
    }

    public Object getItem(int position) {
        return lstImageItem.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_bottom_popu, null);
            viewHolder.addtext = view.findViewById(R.id.addtext);
            viewHolder.addlayout = view.findViewById(R.id.addlayout);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.addtext.setText(lstImageItem.get(position));

        if (isSet) {
            if (posList.get(position) == position) {
                viewHolder.addtext.setTextColor(colorList.get(position));
            }
        }

        if (itemTextSize != 0) {
            viewHolder.addtext.setTextSize(itemTextSize);
        }

        return view;
    }


    class ViewHolder {
        TextView addtext;
        LinearLayout addlayout;
    }
}
