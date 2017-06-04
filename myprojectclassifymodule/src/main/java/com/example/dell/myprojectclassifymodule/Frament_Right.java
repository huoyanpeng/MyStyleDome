package com.example.dell.myprojectclassifymodule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/17.
 * function:
 */
public class Frament_Right extends Fragment {

    private View view;
    private TextView right_text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frament_right,container,true);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.twohaed_re);
        right_text = (TextView) view.findViewById(R.id.right_text);
    }

    public void dd(String ss){
        right_text.setText(ss);
    }


}
