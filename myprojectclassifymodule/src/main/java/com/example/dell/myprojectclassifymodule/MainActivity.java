package com.example.dell.myprojectclassifymodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.dell.myprojectclassifymodule.adapter.MyDecoration;
import com.example.dell.myprojectclassifymodule.adapter.MyRecyclerLifeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<String> list=new ArrayList<>();
    private EditText editText;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyRecyclerLifeAdapter adapter=new MyRecyclerLifeAdapter(this,list);
        recyclerView.setAdapter(adapter);
        //这句就是添加我们自定义的分隔线
        recyclerView.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST));
        adapter.setOnItemClickListener(new MyRecyclerLifeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Toast.makeText(MainActivity.this,list.get(position), Toast.LENGTH_SHORT).show();
//                Frament_Right right=new Frament_Right();
//                right.dd(list.get(position));
            }
        });

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });


    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.main_re);
        progress = (ProgressBar) findViewById(R.id.progress);
        editText = (EditText) findViewById(R.id.classify_head_ed);
        onehead_image = (ImageView) findViewById(R.id.onehead_image);
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
