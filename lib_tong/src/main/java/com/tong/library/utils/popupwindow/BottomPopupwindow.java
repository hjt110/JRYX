package com.tong.library.utils.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.tong.library.R;

import java.util.ArrayList;
import java.util.List;

public class BottomPopupwindow {

    public static class Builder {
        private final PopupWindow popupWindow;
        private Context context;
        private final Activity activity;
        private List<String> list;
        private final TextView tv_cancle;
        private final ListView lv;
        private boolean isSet;
        private List<Integer> posList = new ArrayList<>();
        private List<Integer> colorList = new ArrayList<>();
        private float itemTextSize =0;

        public Builder(Context context, List<String> list) {
            this.context = context;
            activity = (Activity) context;
            this.list = list;
            View contentView = LayoutInflater.from(context).inflate(R.layout.pupview, null, false);
            popupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            backgroundAlpha(0.65f, activity);

            contentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            popupWindow.setAnimationStyle(R.style.Animation);
            tv_cancle = contentView.findViewById(R.id.tv_pop_cancle);
            tv_cancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            lv = contentView.findViewById(R.id.lv_pop);

            //初始化lv添加textview的color和size
            for (int i = 0; i < list.size(); i++) {
                posList.add(-1);
                colorList.add(0);
            }

            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            backgroundAlpha(1.0f, activity);
                        }
                    }, 290);
                }
            });
        }

        public Builder setCancleText(String msg){
            tv_cancle.setText(msg);
            return this;
        }

        public Builder setCancleTextColor(int color) {
            tv_cancle.setTextColor(color);
            return this;
        }

        public Builder setCancleTextSize(float size) {
            tv_cancle.setTextSize(size);
            return this;
        }

        public Builder setItemTextColor(int position, int color) {
            isSet = true;
            posList.set(position, position);
            colorList.set(position, color);
            return this;
        }

        public Builder setItemTextSize(float size){
            itemTextSize = size;
            return this;
        }

        public Builder setItemClickListener(AdapterView.OnItemClickListener listener) {
            lv.setOnItemClickListener(listener);
            return this;
        }

        public void backgroundAlpha(float bgAlpha, Activity activity) {
            WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
            lp.alpha = bgAlpha; //0.0-1.0
            activity.getWindow().setAttributes(lp);
        }

        public Builder show() {
            BottomPopuAdapter bottomPopuAdapter = new BottomPopuAdapter(context, list, isSet, posList, colorList,itemTextSize);
            lv.setAdapter(bottomPopuAdapter);
            popupWindow.showAtLocation(activity.getWindow()
                    .getDecorView(), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
            return this;
        }

    }


}
