package com.di.tang.myapplication.geometricview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by tangdi on 2016/8/22.
 */
public class FinguerView extends View {

    private Path path = new Path();

    private float preX, preY;

    public FinguerView(Context context) {
        super(context);
    }

    public FinguerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FinguerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(), event.getY());
                preX = event.getX();
                preY = event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
                float endX = (preX+event.getX())/2;
                float endY = (preY+event.getY())/2;
                path.quadTo(preX, preY, endX, endY);
                preX = event.getX();
                preY = event.getY();
                postInvalidate();
                return true;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
    @Override
    public void onDraw(Canvas canvas){

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawPath(path, paint);
    }

    public void reset(){
        path.reset();
        invalidate();
    }
}
