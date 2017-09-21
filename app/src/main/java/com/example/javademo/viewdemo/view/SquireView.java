package com.example.javademo.viewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.example.javademo.viewdemo.R;

/**
 * Created by 侯占磊 on 2017/9/20.
 */

public class SquireView extends BaseView{

    public SquireView(Context context) {
        super(context);
    }

    public SquireView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquireView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void drawColum(Canvas canvas, Paint mPaint) {
        //注意再看下
        if(colorInfo!=null){
            float cellWith=width/xDivideSize;
            for (int i=0;i<colorInfo.length;i++){
                mPaint.setColor(colorInfo[i][1]);
                float leftTopY=originalY-height*(colorInfo[i][0])/yDivideSize;
                canvas.drawRect(originalX+cellWith*(1+i),leftTopY,originalX+cellWith*(2+i),originalY,mPaint);
            }
        }
    }

    @Override
    protected void drawYScaleValue(Canvas canvas, Paint mPaint) {
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(16);

        mPaint.setFakeBoldText(true);
        float cellHeight = height / yDivideSize;
        //为什么设置
        float cellValue=maxValueY/xDivideSize;
        for(int i=1;i<yDivideSize;i++){
            canvas.drawText(i+"",originalX-30,originalY-cellHeight*i-35,mPaint);
        }
    }

    @Override
    protected void drawXScaleValue(Canvas canvas, Paint mPaint) {
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(16);

        mPaint.setFakeBoldText(true);
        float cellWidth = width / xDivideSize;

        for(int i=0;i<xDivideSize;i++){
            canvas.drawText(i+"",originalX+cellWidth*i-35,originalY+30,mPaint);
        }
    }

    @Override
    protected void drawYScale(Canvas canvas, Paint mPaint) {
        float cellHeight = height / yDivideSize;
        for(int i=0;i<xDivideSize;i++){
            canvas.drawLine(originalX,originalY-cellHeight*(1+i),originalX+10,originalY-cellHeight*(1+i),mPaint);//刻度值
        }
    }

    @Override
    protected void drawXScale(Canvas canvas, Paint mPaint) {
        float cellWidth = width / xDivideSize;
        for(int i=0;i<xDivideSize;i++){
            canvas.drawLine(originalX+cellWidth*(1+i),originalY,originalX+cellWidth*(1+i),originalY+10,mPaint);//刻度值
        }
    }

    @Override
    protected void drawY(Canvas canvas, Paint mPaint) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);//线条的宽度
        canvas.drawLine(originalX,originalY,originalX,originalY-height,mPaint);
    }

    @Override
    protected void drawX(Canvas canvas, Paint mPaint) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);//线条的宽度
        canvas.drawLine(originalX,originalY,originalX+width,originalY,mPaint);
    }
}
