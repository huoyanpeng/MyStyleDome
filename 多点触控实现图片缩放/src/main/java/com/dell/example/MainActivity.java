package com.dell.example;


import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private ImageView images;
    private Matrix matrix=new Matrix();
    private Matrix matrixes=new Matrix();

    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private int mode = NONE;

    // 第一个按下的手指的点
    private PointF startPoint = new PointF();
    // 两个按下的手指的触摸点的中点
    private PointF midPoint = new PointF();
    // 初始的两个手指按下的触摸点的距离
    private float oriDis = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = (ImageView) findViewById(R.id.images);
        images.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView view1 = (ImageView) view;
        switch (motionEvent.getAction()& MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                //第一个手指按下
                matrix.set(view1.getImageMatrix());
                matrixes.set(matrix);
                startPoint.set(motionEvent.getX(),motionEvent.getY());
                //拖动
                mode=DRAG;

                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                //第二个手指按下
                oriDis=distance(motionEvent);
                if (oriDis>10f){
                    matrixes.set(matrix);
                    midPoint= middle(motionEvent);
                    //标记缩放状态
                    mode=ZOOM;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                 //手指滑动事件
                if (mode==DRAG){
                    //单手指拖动
                    matrix.set(matrixes);
                    //移动图片
                    matrix.postTranslate(motionEvent.getX()-startPoint.x,motionEvent.getY()-startPoint.y);
                }else if (mode==ZOOM){
                    //双手指拖动
                    float distance = distance(motionEvent);
                    if (distance>10f){
                        matrix.set(matrixes);
                        float v = distance / oriDis;
                        //图片缩放
                        matrix.setScale(v,v,midPoint.x,midPoint.y);
                    }
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                //手指松开开，标记状态
                mode=NONE;
                break;
        }
        //设置矩阵
        view1.setImageMatrix(matrix);
        return true;
    }
    //计算两个两个触摸点的中心点
    private PointF middle(MotionEvent motionEvent) {

        float x = motionEvent.getX(0) + motionEvent.getX(1);
        float y = motionEvent.getY(0) + motionEvent.getY(1);


        return new PointF(x/2,y/2);
    }

    //计算两个触摸点的距离
    private float distance(MotionEvent motionEvent) {
        //获取第一个手指和第二个手指的坐标
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);

        return (float) Math.sqrt(x*x+y*y);
    }
}
