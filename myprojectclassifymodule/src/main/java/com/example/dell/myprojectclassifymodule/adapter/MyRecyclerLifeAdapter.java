package com.example.dell.myprojectclassifymodule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
public class MyRecyclerLifeAdapter extends RecyclerView.Adapter<MyRecyclerLifeAdapter.ViewHolder> implements View.OnClickListener{

     private Context context;
     private List<String> list;
     //声明接口
     private OnItemClickListener mOnItemClickListener = null;
    public MyRecyclerLifeAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }
    //自定义接口
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
    //暴露给外面的调用者，定义一个设置Listener的方法（）
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public MyRecyclerLifeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_life,parent,false);
        ViewHolder v=new ViewHolder(view);

        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return v;
    }

    @Override
    public void onBindViewHolder(MyRecyclerLifeAdapter.ViewHolder holder, int position) {
        holder.item.setText(list.get(position));

        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView item;

        public ViewHolder(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.item_life_text);
        }
    }
}
