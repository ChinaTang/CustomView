package com.di.tang.myapplication.geometricview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tangdi on 2016/8/22.
 */
public class DottedLineView extends View {

    Paint paint = new Paint();
    private ValueAnimator valueAnimator;

    public DottedLineView(Context context) {
        super(context);
        valueAnimator = ValueAnimator.ofInt(0,500);
        valueAnimator.setDuration(1000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                paint.setPathEffect(new DashPathEffect(new float[]{20,10,50,100},
                        (int)valueAnimator.getAnimatedValue()));
                postInvalidate();
            }
        });
        valueAnimator.start();
    }

    public DottedLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        valueAnimator = ValueAnimator.ofInt(0,500);
        valueAnimator.setDuration(5000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                paint.setPathEffect(new DashPathEffect(new float[]{20,10,50,100},
                        (int)valueAnimator.getAnimatedValue()));
                postInvalidate();
            }
        });
        valueAnimator.start();
    }

    public DottedLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        valueAnimator = ValueAnimator.ofInt(0,50);
        valueAnimator.setDuration(1000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                paint.setPathEffect(new DashPathEffect(new float[]{20,10,50,100},
                        (int)valueAnimator.getAnimatedValue()));
                postInvalidate();
            }
        });
        valueAnimator.start();
    }


    @Override
    public void onDraw(Canvas canvas){
        paint.setStyle(Paint.Style.STROKE);

        Path path = new Path();
        path.moveTo(100,600);
        path.lineTo(400,100);
        path.lineTo(700,900);

        canvas.translate(0,100);
        paint.setColor(Color.RED);
        canvas.drawPath(path,paint);

        paint.setColor(Color.YELLOW);
        canvas.translate(0,100);
        canvas.drawPath(path,paint);
    }
}
