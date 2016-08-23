package com.di.tang.myapplication.geometricview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tangdi on 2016/8/19.
 */
public class PointView extends View {

    private Context context;

    private AttributeSet attrs;

    public PointView(Context context) {
        super(context);
        this.context = context;
    }

    public PointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
    }

    public PointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.attrs = attrs;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PointView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        this.attrs = attrs;
    }

    @Override
    protected void onDraw(Canvas canvas){

        Paint paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿功能
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式   Style.FILL/Style.FILL_AND_STROKE/Style.STROKE
        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setShadowLayer(10, 15, 15, Color.GREEN);//设置阴影
        canvas.drawRGB(255, 255,255);
        //画圆
        float[] points = {100, 50, 200, 150};
        canvas.drawPoints(points, paint);
        canvas.drawPoint(139, 158, paint);

    }
}
