package com.wangou.jinriyixing.ui.activity.main;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.tong.library.base.BaseActivity;
import com.tong.library.utils.popupwindow.BottomPopupwindow;
import com.wangou.jinriyixing.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter, MainContract.View> implements MainContract.View {

    @BindView(R.id.tv_main)
    TextView tvMain;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list = new ArrayList<>();
                list.add("test");
                list.add("hahahfhafha");
                BottomPopupwindow.Builder builder = new BottomPopupwindow.Builder(getActivity(), list)
                        .setTextSize(0,30f)
                        .setItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                if (position == 0) {
                                    Toast.makeText(getActivity(), "dlfjdkf", Toast.LENGTH_SHORT)
                                            .show();
                                }
                            }
                        })
                        .show();
            }
        });
    }


}
