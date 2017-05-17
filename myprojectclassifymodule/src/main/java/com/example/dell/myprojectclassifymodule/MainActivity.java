package com.example.dell.myprojectclassifymodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Classify_main{

    private EditText classify_head_ed;
    private RecyclerView classify_re_life;
    private RecyclerView classify_re_right;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        classify_head_ed = (EditText) findViewById(R.id.classify_head_ed);
        classify_re_life = (RecyclerView) findViewById(R.id.classify_re_life);
        classify_re_right = (RecyclerView) findViewById(R.id.classify_re_right);
        progress = (ProgressBar) findViewById(R.id.progress);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setItems(List<String> items) {

    }

    @Override
    public void showMessage(String message) {

    }
}
