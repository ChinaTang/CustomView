package com.di.tang.myapplication.geometricview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.xpath.XPath;

/**
 * Created by tangdi on 2016/8/23.
 */
public class AccordPlot<Y, X> extends View {

    private ArrayList<Y> Yaxis = new ArrayList<Y>();

    private Path Xpath = new Path(), Ypath = new Path();;

    private ArrayList<X>Xaxis = new ArrayList<X>();

    private  float Yintervals, Xintervals;

    private Path XheadPath = new Path(), YheadPath = new Path();

    private Map<Y, X> XYmap = new HashMap<Y, X>();

    private Path BrokenLine = new Path();

    private Path XdottedLine, YdottedLine;

    private ArrayList<Path> XdottedLines = new ArrayList<>();
    private ArrayList<Path> YdottedLines = new ArrayList<>();

    public void setXYmap(HashMap<Y, X> hashMap){
        XYmap = hashMap;
    }

    public void setYaxis(ArrayList<Y> YList){
        Yaxis = YList;
    }

    public void setXaxis(ArrayList<X> XList){
        Xaxis = XList;
    }

    public AccordPlot(Context context) {
        super(context);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    public AccordPlot(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    public AccordPlot(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    public void onDraw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(15);

        Paint BrokenPaint = new Paint();
        BrokenPaint.setColor(Color.RED);
        BrokenPaint.setTextSize(15);
        BrokenPaint.setStyle(Paint.Style.STROKE);

        Paint DottedPaint = new Paint();
        DottedPaint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        DottedPaint.setPathEffect(new DashPathEffect(new float[]{20,10,50,100}, 5));

        Ypath.moveTo(20, 35);
        Ypath.lineTo(20, 400);

        Xpath.moveTo(20, 400);
        Xpath.lineTo(535, 400);

        /*{
            XheadPath.reset();
            XheadPath.moveTo(20, 35);
            XheadPath.lineTo(15, 30);

            YheadPath.reset();
            YheadPath.moveTo(20, 35);
            YheadPath.lineTo(25, 30);
            canvas.drawPath(XheadPath, paint);
            canvas.drawPath(YheadPath, paint);
        }

        {
            XheadPath.reset();
            XheadPath.moveTo(535, 400);
            XheadPath.lineTo(530, 395);

            YheadPath.reset();
            YheadPath.moveTo(535, 400);
            YheadPath.lineTo(530, 400);
            canvas.drawPath(XheadPath, paint);
            canvas.drawPath(YheadPath, paint);
        }*/

        for(int i = 0; i < XdottedLines.size(); i++){
            canvas.drawPath(XdottedLines.get(i), DottedPaint);
        }
        for(Path dottedLine : YdottedLines){
            canvas.drawPath(dottedLine, DottedPaint);
        }

        canvas.drawPath(Xpath, paint);
        if(!Xaxis.isEmpty()){
            for(int i = 0; i < Xaxis.size(); i++){
                canvas.drawText(Xaxis.get(i).toString(), 20 + Xintervals * (i + 1), 415, textPaint);
            }
        }
        canvas.drawPath(Ypath, paint);
        if(!Yaxis.isEmpty()){
            for(int i = 0; i < Yaxis.size(); i++){
                canvas.drawText(Yaxis.get(i).toString(), 0, 400 - Yintervals * (i + 1), textPaint);
            }
        }
        canvas.drawPath(BrokenLine, BrokenPaint);
    }

    public void setXYaxis(){
        if(Xaxis.size() == 0 || Yaxis.size() == 0)
            return;
        Yintervals = (400 - 50) / Yaxis.size();
        Xintervals = (520-20)/Xaxis.size();
        /*{
            //Ypath.reset();
            //Ypath.moveTo(20, 50);
            for(int i = 0; i < Yaxis.size(); i++){
                Ypath.lineTo(20, 50 + Yintervals * (i + 1));
            }
            //Xpath.reset();
            //Xpath.moveTo(20, 200);
            for(int i = 0; i < Xaxis.size(); i++){
                Xpath.lineTo(20 + Xintervals * (i + 1), 200);
            }
        }*/

        if(!XYmap.isEmpty()){
            BrokenLine.moveTo(20 + Xintervals,
                    400 - (Yaxis.indexOf(XYmap.get(Xaxis.get(0))) + 1) * Yintervals);
            for(X x : Xaxis){
                BrokenLine.lineTo(20 + (Xaxis.indexOf(x) + 1) * Xintervals,
                        400 - (Yaxis.indexOf(XYmap.get(x)) + 1) * Yintervals);
                {
                    Path xdottedLine = new Path();
                    xdottedLine.moveTo(20 + (Xaxis.indexOf(x) + 1) * Xintervals, 400);
                    xdottedLine.lineTo(20 + (Xaxis.indexOf(x) + 1) * Xintervals,
                            400 - (Yaxis.indexOf(XYmap.get(x)) + 1) * Yintervals);
                    XdottedLines.add(xdottedLine);
                }
                {
                    Path ydottedLine = new Path();
                    ydottedLine.moveTo(20, 400 - (Yaxis.indexOf(XYmap.get(x)) + 1) * Yintervals);
                    ydottedLine.lineTo(20 + (Xaxis.indexOf(x) + 1) * Xintervals,
                            400 - (Yaxis.indexOf(XYmap.get(x)) + 1) * Yintervals);
                    YdottedLines.add(ydottedLine);
                }
            }
        }
        postInvalidate();
    }

    private void drawLineAnmotor(float lx, float ly, float nx, float ny){

    }

}
