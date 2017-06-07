package test.bwie.com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/6/6.
 * function:
 */
public class CircleView extends View {

    private float x=100;
    private float y=100;
    private Paint paint;
    private float x2;
    private float y2;
    private boolean falg=false;
    private boolean b;

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化画笔
        paint = new Paint();
        //设置颜色
        paint.setColor(Color.YELLOW);
        //抗锯齿
        paint.setAntiAlias(true);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x,y,100,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x2 = event.getX();
                y2 = event.getY();
                Log.e("ssss","x2=="+x2+";y2=="+y2);
                b = ininIf();
                break;
            case MotionEvent.ACTION_MOVE:
                //在拖动图形时获得x值，y值；
                 x = event.getX();
                 y = event.getY();
                Log.e("ssss","x=="+x+";y=="+y);

                //刷新
                invalidate();
                //子线程刷新
//                postInvalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return b;
    }

    private boolean ininIf() {
          if (100>=Math.abs(x-x2)&&100>=Math.abs(y-y2)){
              falg=true;
          }else {
             falg=false;
          }
        return falg;
    }
}
