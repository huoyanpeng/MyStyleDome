package com.example.dell.myprojectclassifymodule.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/23.
 * function:
 */
public class MyRecyclerRightAdapter extends RecyclerView.Adapter<MyRecyclerRightAdapter.ViewHolder> {

    @Override
    public MyRecyclerRightAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyRecyclerRightAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
