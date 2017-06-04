package com.example.dell.myprojectclassifymodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.myprojectclassifymodule.adapter.MyReclclerMainTwoAdapter;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private ImageView image_back;
    private TextView sou_suo;
    private EditText twohaed_ed;
    private ImageView yv_yin;
    private ImageView edit_search;
    private List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyReclclerMainTwoAdapter adapter=new MyReclclerMainTwoAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
    }

    private void initData() {
        list.add("育儿图书");
        list.add("防辐射服");
        list.add("儿童车");
        list.add("奶瓶");
        list.add("自行车");
        list.add("纸尿裤");
        list.add("奶粉");
        list.add("驱蚊液");
        list.add("推车");
        list.add("男童夏装");
        list.add("女童夏装");
        list.add("儿童玩具");
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.twohaed_re);
        image_back = (ImageView) findViewById(R.id.image_back);
        sou_suo = (TextView) findViewById(R.id.sou_suo);
        twohaed_ed = (EditText) findViewById(R.id.twohaed_ed);
        yv_yin = (ImageView) findViewById(R.id.yv_yin);
        edit_search = (ImageView) findViewById(R.id.edit_search);

        image_back.setOnClickListener(this);
        sou_suo.setOnClickListener(this);
        yv_yin.setOnClickListener(this);
        edit_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image_back:
                finish();
                break;
            case R.id.sou_suo:
                break;
            case R.id.yv_yin:
                break;
            case R.id.edit_search:
                break;
        }
    }
}
