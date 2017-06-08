package com.example.photoview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import uk.co.senab.photoview.PhotoViewAttacher;

import static android.R.attr.description;
import static com.example.photoview.R.attr.title;
import android.content.ContentResolver;
/**
 * author: 霍彦朋 (dell) .
 * date: 2017/6/7.
 * function:
 */
public class MyViewPagerAdapter extends PagerAdapter{
    private List<Integer> imlist;
    private Context context;
    private PhotoViewAttacher mAttacher;

    public MyViewPagerAdapter(List<Integer> imlist, Context context) {
        this.imlist = imlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imlist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(imlist.get(position));
        //使图片实现可以放大缩小的功能
        mAttacher = new PhotoViewAttacher(imageView);
        mAttacher.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("提示");
                builder.setMessage("是否保存图片");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Resources res=context.getResources();
                        Bitmap bmp=BitmapFactory.decodeResource(res,imlist.get(position));
                        Log.e("ssssssssssssssssssss","Bitmap:"+bmp);
                        ContentResolver contentResolver = context.getContentResolver();
                        MediaStore.Images.Media.insertImage(contentResolver,bmp,"", "");
                        Toast.makeText(context, "保存成功", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();

                return false;
            }
        });
        container.addView(imageView);
        return imageView;
    }
}
