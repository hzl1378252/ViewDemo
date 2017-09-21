package com.example.javademo.viewdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.example.javademo.viewdemo.R;

/**
 * Created by 侯占磊 on 2017/9/18.
 */

public abstract class BaseView extends View {
    private Context mContext;
    private Paint mPaint;

    //视图的宽高
    public int width;
    public int height;
    //起点的 x，y坐标值
    public int originalX = 100;
    public int originalY = 800;

    public int xDivideSize;//平分几等份
    public int yDivideSize;

    public int colorInfo [] [] ;//二维数据，第一维度值，第二维度颜色

    public float maxValueY;//y轴最大值
    public float maxValueX;//X轴最大值

    /**
     * 设置数据源
     * @param colorInfo
     */
    public void setColorInfo(int[][] colorInfo) {
        this.colorInfo = colorInfo;
    }

    /**
     * 设置X轴最大值和等份
     * @param xDivideSize
     * @param maxValueX
     */
    public void setXVale(int xDivideSize,int maxValueX){
        this.xDivideSize=xDivideSize;
        this.maxValueX=maxValueX;
    }

    public void setYVale(int yDivideSize,int maxValueY){
        this.yDivideSize=yDivideSize;
        this.maxValueY=maxValueY;
    }

    private String mTitle;
    private String mXName;
    private String mYName;

    private int mTextSize;
    private int mTextColor;

    public BaseView(Context context) {
        this(context, null);//指向最下面的构造方法
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        //获取自定义样式
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.BaseView);

        mTitle = array.getString(R.styleable.BaseView_title);
        mXName = array.getString(R.styleable.BaseView_xName);
        mYName = array.getString(R.styleable.BaseView_yName);

        mTextColor = array.getColor(R.styleable.BaseView_textColor, Color.BLACK);
        mTextSize = array.getDimensionPixelSize(R.styleable.BaseView_textSize, 12);

        if (array != null) {
            array.recycle();//不等于空  结束完回收
        }
        initPaint();

    }

    private void initPaint() {
        if (mPaint == null) {
            mPaint = new Paint();
            mPaint.setDither(true);//去抖动
            mPaint.setAntiAlias(true);//去锯齿
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        width=getWidth() - originalX;
        height=( originalY > getHeight() ? getHeight() : originalY ) - 400;//使Y轴向下移动

        drawX(canvas,mPaint);
        drawY(canvas,mPaint);//x y轴
        drawTitle(canvas,mPaint);//标题
        drawXScale(canvas,mPaint);
        drawYScale(canvas,mPaint);//x y 轴的刻度
        drawXScaleValue(canvas,mPaint);
        drawYScaleValue(canvas,mPaint);//x y 轴的值
        drawXArrow(canvas,mPaint);
        drawYArrow(canvas,mPaint);//x y轴箭头
       drawColum(canvas,mPaint);//柱形图

    }

    protected abstract void drawColum(Canvas canvas, Paint mPaint);

    /**
     * 画Y轴的箭头
     * @param canvas
     * @param mPaint
     */
    protected  void drawYArrow(Canvas canvas, Paint mPaint){
        Path path=new Path();
        path.moveTo(originalX,originalY-height-30);//应该是减
        path.lineTo(originalX+10,originalY-height);
        path.lineTo(originalX-10,originalY-height);

        path.close();
        canvas.drawPath(path,mPaint);
        canvas.drawText(mYName+"",originalX-50,originalY-height,mPaint );
    }

    /**
     * 画x轴的箭头
     * @param canvas
     * @param mPaint
     */
    protected  void drawXArrow(Canvas canvas, Paint mPaint){
        Path path=new Path();
        path.moveTo(originalX+width+30,originalY);
        path.lineTo(originalX+width,originalY-10);
        path.lineTo(originalX+width,originalY+10);


        path.close();
        canvas.drawPath(path,mPaint);
        canvas.drawText(mXName+"",originalX+width,originalY+50,mPaint);
    }

    /**
     * Y轴的值
     * @param canvas
     * @param mPaint
     */
    protected abstract void drawYScaleValue(Canvas canvas, Paint mPaint);

    /**
     * X轴的值
     * @param canvas
     * @param mPaint
     */
    protected abstract void drawXScaleValue(Canvas canvas, Paint mPaint);

    /**
     * 画Y轴的刻度
     * @param canvas
     * @param mPaint
     */
    protected abstract void drawYScale(Canvas canvas, Paint mPaint);

    /**
     * 画X轴的刻度
     * @param canvas
     * @param mPaint
     */
    protected abstract void drawXScale(Canvas canvas, Paint mPaint);

    /**
     * 画标题
     * @param canvas
     * @param mPaint
     */
    private void drawTitle(Canvas canvas, Paint mPaint) {

        if(!TextUtils.isEmpty(mTitle)){
            mPaint.setColor(mTextColor);
            mPaint.setTextSize(mTextSize);
            mPaint.setFakeBoldText(true);//加粗

           canvas.drawText(mTitle,(getWidth()/2)-
           mPaint.measureText(mTitle)/2,originalY+40,mPaint);//width减去字体的宽度，Y轴上移40 ；/2是为了居中
        }
    }

    /**
     * 画Y轴
     * @param canvas
     * @param mPaint
     */
    protected abstract void drawY(Canvas canvas, Paint mPaint);

    /**
     *
     * 画x轴
     * @param canvas
     * @param mPaint
     */
    protected abstract void drawX(Canvas canvas, Paint mPaint);

}
