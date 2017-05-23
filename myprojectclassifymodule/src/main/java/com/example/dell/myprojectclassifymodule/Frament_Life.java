package com.example.dell.myprojectclassifymodule;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myprojectclassifymodule.adapter.MyDecoration;
import com.example.dell.myprojectclassifymodule.adapter.MyRecyclerLifeAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/5/17.
 * function:
 */
public class Frament_Life extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private List<String> list=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frament_life,null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.frament_life_re);
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyRecyclerLifeAdapter adapter=new MyRecyclerLifeAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);
        //这句就是添加我们自定义的分隔线
        recyclerView.addItemDecoration(new MyDecoration(getActivity(), MyDecoration.VERTICAL_LIST));
    }

    private void initData() {
        list.add("宝宝奶粉");
        list.add("辅食营养");
        list.add("宝宝尿裤");
        list.add("洗护用品");
        list.add("喂养用品");
        list.add("宝宝玩乐");
        list.add("妈妈专区");
        list.add("童装童鞋");
        list.add("图书天地");
        list.add("童车童床");
    }
}
