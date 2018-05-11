package com.example.ahn.lab04_1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ahn on 2018-05-10.
 */

public class touchEventView extends View {
    private Path path;
    private Paint pnt;
    private Canvas canvas;
    private Bitmap bitmap;

    //Constructor of View
    public touchEventView(Context c) {
        super(c);
        initDrawing();
    }

    //Initialize drawing tools
    private void initDrawing() {
        path = new Path();
        pnt = new Paint();
        pnt.setColor(Color.BLUE);
        pnt.setStrokeWidth(10);
        pnt.setStyle(Paint.Style.STROKE);
    }

    //Before drawing (onDraw method), check View's size
    //If View's size changed, then called
    protected void onSizeChanged(int x, int y, int oldX, int oldY) {
        super.onSizeChanged(x, y, oldX, oldY);
        bitmap = Bitmap.createBitmap(x, y, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }

    //Draw path on bitmap
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, 0, pnt);
        canvas.drawPath(path, pnt);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //get Touched location
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            //touch
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY);
                break;
            //move
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                break;
            //out
            case MotionEvent.ACTION_UP:
                path.lineTo(touchX, touchY);
                canvas.drawPath(path, pnt);
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
}
