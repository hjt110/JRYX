package com.wangou.jinriyixing.ui.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangou.jinriyixing.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomFragment extends Fragment {


    public HomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hom, container, false);
    }

}
