package test.bwie.com.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * author: 霍彦朋 (dell) .
 * date: 2017/6/6.
 * function:
 */
public class MyViewGroup extends ViewGroup {

    private static final String TAG = "MyViewGroup";

    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {

        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
    }
    //负责设置子控件的测量模式和大小，根据所有子控件设置自己的宽和高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获得它的父容器为它设置测量模式和大小
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        //如果是warp_content情况下，记录宽和高
        int width=0;
        int height=0;
        //记录每一行的宽度，width不断去最大的宽度
        int lineWidth=0;
        //记录每一行的高度，累加至height
        int lineHeight=0;
        //获得ViewGroup下共有多少个子view
        int childCount = getChildCount();
        //遍历每个子布局
        for (int i = 0; i <childCount ; i++) {
            View childAt = getChildAt(i);
            //测量每一个子布局的宽和高
            measureChild(childAt,widthMeasureSpec,heightMeasureSpec);
            //得到子布局的MarginLayoutParams的参数(容器)
            MarginLayoutParams layoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            //获得当前子布局的宽度
            int childWidth = childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            //获得当前子布局的高度
            int chidlHeight = childAt.getMeasuredHeight() + layoutParams.bottomMargin + layoutParams.topMargin;
            if (lineWidth+childWidth>sizeWidth){
                //获取最大值
                width = Math.max(lineWidth, childWidth);
                //重新开启一行，重新记录
                lineWidth=childWidth;
                //叠加当前高度
                height+=lineHeight;
                //开始记录下行高度
                lineHeight=chidlHeight;
            }else {
                //否侧累加至lineWidth,lineHeight取最大值
                lineWidth+=childWidth;
                lineHeight=Math.max(lineHeight,chidlHeight);
            }
            if (i==childCount-1){
                width=Math.max(width,lineWidth);
                height+=lineHeight;
            }
        }
        setMeasuredDimension((modeWidth==MeasureSpec.EXACTLY)?sizeWidth:width,(modeHeight==MeasureSpec.EXACTLY)?sizeHeight:height);
    }
    //储存所有的子View,按行记录
    private List<List<View>> childView=new ArrayList<>();
    //记录每行的最大高度
    private List<Integer> integerList=new ArrayList<>();
    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        childView.clear();
        integerList.clear();

        int width = getWidth();
        int lineWidth=0;
        int lineHeight=0;
        //储存每一行的子View
        List<View> viewList=new ArrayList<>();
        int childCount = getChildCount();
        for (int j = 0; j <childCount ; j++) {
            //获得子View
            View childAt = getChildAt(j);
            //得到子布局的MarginLayoutParams的参数(容器)
            MarginLayoutParams layoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            //如果需要换行
            if (measuredWidth+layoutParams.leftMargin+lineWidth+layoutParams.rightMargin>width){
                //记录每一行所有的子View及最大值高度
                integerList.add(lineHeight);
                //保存当前的子View,然后开启的list集合，保存下一行的子View
                childView.add(viewList);
                //重新设置行宽
                lineWidth=0;
                viewList=new ArrayList<>();
            }else {
                //如果不需要换行，则累加
                lineWidth+=measuredWidth+layoutParams.leftMargin+layoutParams.rightMargin;
                lineHeight+=Math.max(lineHeight,measuredHeight+layoutParams.bottomMargin+layoutParams.topMargin);
                viewList.add(childAt);
            }
        }
        //记录最后一行
        integerList.add(lineHeight);
        childView.add(viewList);

        int left=0;
        int top=0;
        //得到总行数
        int size = childView.size();
        for (int j = 0; j <size ; j++) {
            //每一行所有的子View
            viewList = childView.get(j);
            //当前最大高度
            lineHeight = integerList.get(j);
            //遍历当前的子View
            for (int k = 0; k <viewList.size() ; k++) {
                View view = viewList.get(k);
                if (view.getVisibility()==View.GONE){
                    continue;
                }
                MarginLayoutParams layoutParams = (MarginLayoutParams) view.getLayoutParams();
                //计算子View的i,i1,i2,i3
                int ic=left+layoutParams.leftMargin;
                int i1c=top+layoutParams.topMargin;
                int i2c=ic+view.getMeasuredWidth();
                int i3c=i1c+view.getMeasuredHeight();
                Log.e(TAG, view + " , l = " + ic + " , t = " + i1c + " , r ="
                        + i2c + " , b = " + i3c);
                view.layout(ic,i1c,i2c,i3c);
                left += view.getMeasuredWidth() + layoutParams.rightMargin
                        + layoutParams.leftMargin;
            }
            left=0;
            top=0;

        }
    }

}
