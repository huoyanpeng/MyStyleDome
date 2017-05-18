package com.example.dell.myprojectclassifymodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText classify_head_ed;
    private RecyclerView classify_re_life;
    private RecyclerView classify_re_right;
    private ProgressBar progress;
    private List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        progress = (ProgressBar) findViewById(R.id.progress);
    }
}
