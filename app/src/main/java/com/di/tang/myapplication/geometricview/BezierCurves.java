package com.di.tang.myapplication.geometricview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tangdi on 2016/8/22.
 */
public class BezierCurves extends View {

    public BezierCurves(Context context) {
        super(context);
    }

    public BezierCurves(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BezierCurves(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onDraw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        Path path = new Path();
        path.moveTo(100, 100);
        path.quadTo(200,200,300,300);
        path.quadTo(400,400,500,300);
        canvas.drawPath(path,paint);
    }
}
