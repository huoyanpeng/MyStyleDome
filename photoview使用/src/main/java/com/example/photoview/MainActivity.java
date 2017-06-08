package com.example.photoview;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<Integer> imlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

        MyViewPagerAdapter adapter=new MyViewPagerAdapter(imlist,this);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initData() {
        imlist.add(R.mipmap.ae);
        imlist.add(R.mipmap.af);
        imlist.add(R.mipmap.ah);
        imlist.add(R.mipmap.bi);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }
}
