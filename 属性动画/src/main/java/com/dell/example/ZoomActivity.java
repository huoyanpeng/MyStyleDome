package com.dell.example;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ZoomActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private Button button_zoom_x;
    private ImageView images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        initView();
    }

    private void initView() {
        button = (Button) findViewById(R.id.button_zoom);
        button.setOnClickListener(this);
        button_zoom_x = (Button) findViewById(R.id.button_zoom_x);
        button_zoom_x.setOnClickListener(this);
        images = (ImageView) findViewById(R.id.imageViews);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_zoom:
                zoom();
                break;
            case R.id.button_zoom_x:
                zoomx();
                break;
        }
    }

    private void zoomx() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 600);
        valueAnimator.setTarget(images);
        valueAnimator.setDuration(3000).start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                images.setTranslationY((Float) valueAnimator.getAnimatedValue());

            }
        });


    }

    private void zoom() {
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(images,"rotation",0f,360f);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                System.out.println("valueAnimator======"+valueAnimator.getAnimatedValue());
            }
        });
    }
}
