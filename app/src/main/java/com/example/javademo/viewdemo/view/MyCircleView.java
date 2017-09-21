package com.example.javademo.viewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 自己画一个圆形
 * Created by 侯占磊 on 2017/9/21.
 */

public class MyCircleView extends View {
    private int mColor = Color.RED;
    private Paint mPaint;

    public MyCircleView(Context context) {
        super(context);
        initPaint();
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int paddingLeft = getPaddingLeft();
        final int paddingBottom = getPaddingBottom();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        int width = getWidth()-paddingLeft-paddingRight;
        int height = getHeight()-paddingBottom-paddingTop;
        int radius = Math.min(width, height) / 2;
        canvas.drawCircle(paddingLeft+width/2, paddingTop+height/2, radius, mPaint);

    }

    protected void initPaint() {
        if (mPaint == null) {
            mPaint = new Paint();
            mPaint.setColor(mColor);
            mPaint.setStrokeWidth(5);


        }
    }
}


