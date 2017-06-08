package com.dell.example;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView, "sss", 1.0f, 0.2f);
                objectAnimator.setDuration(1000).start();
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedValue = (float) valueAnimator.getAnimatedValue();
                        imageView.setAlpha(animatedValue);
                        imageView.setScaleX(animatedValue);
                        imageView.setScaleY(animatedValue);
                    }
                });

            }
        });
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.image02);
    }
}
