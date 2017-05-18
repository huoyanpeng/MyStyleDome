package com.example.dell.myprojectclassifymodule.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.myprojectclassifymodule.R;

import java.util.List;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/17.
 * function:
 */
public class MyRecyclerLifeAdapter extends RecyclerView.Adapter<MyRecyclerLifeAdapter.ViewHolder> {

     private Context context;
     private List<String> list;

    public MyRecyclerLifeAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyRecyclerLifeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_life,parent,false);
        ViewHolder v=new ViewHolder(view);

        return v;
    }

    @Override
    public void onBindViewHolder(MyRecyclerLifeAdapter.ViewHolder holder, int position) {
        holder.item.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView item;

        public ViewHolder(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.item_life_text);
        }
    }
}
