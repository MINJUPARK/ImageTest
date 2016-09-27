package com.example.imagetest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by 박민주 on 2016-09-26.
 */
public class MyImage extends View {
    int choose=MainActivity.ORIGINAL;
    Bitmap picture;

    MyImage(Context context) {
        super(context);
        picture = BitmapFactory.decodeResource(getResources(),R.drawable.cat);
    }

    public void setChoose(int choose) {
        this.choose=choose;
    }
    @Override
    protected void onDraw(Canvas canvas) {

        float cx = getWidth()/2.0f; // 중심점 x
        float cy = getHeight()/2.0f; // 중심점 Y
        float x = (getWidth()-picture.getWidth())/2.0f;
        float y = (getHeight()-picture.getWidth())/2.0f;
        switch(choose) {
            case MainActivity.ROTATE:
                canvas.rotate(45,cx,cy);
                break;
            case MainActivity.TRANSLATE:
                canvas.translate(-150,200);
                break;
            case MainActivity.SCALE:
                canvas.scale(1.5f,1.5f,cx,cy);
                break;
            case MainActivity.SKEW:
                canvas.skew(0.4f, 0.4f);
                break;

        }
        //canvas.rotate(45,cx,cy); // 이미지 회전
        //canvas.translate(-150,200); // 이미지 이동
        canvas.scale(1.5f,1.5f,cx,cy); // 이미지 크기
        canvas.skew(0.4f, 0.4f); // 이미지 비틀기

        canvas.drawBitmap(picture,x,y,null);
    }
}