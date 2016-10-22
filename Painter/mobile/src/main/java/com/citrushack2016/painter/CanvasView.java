package com.citrushack2016.painter;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {
    Paint paint = new Paint();

    int sizeX;
    int sizeY;
    Point midPoint;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);

        sizeX = this.getWidth();
        sizeY = this.getHeight();
    }

    public void calculateDimens() {//should only be called after the UI has been made. This MUST be called in order for the view to work.
        sizeX = this.getWidth();
        sizeY = this.getHeight();
        midPoint.set( (sizeX/2) , (sizeY/2) );//This is the point at the center of the view.
    }

    public void drawPoint(int posX, int posY) {

    }
}
