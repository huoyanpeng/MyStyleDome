package com.example.dell.myprojectclassifymodule;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/17.
 * function:
 */
public class Frament_Right extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frament_right,null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.twohaed_re);
        View viewById1 = view.findViewById(R.id.image_back);
    }
}
