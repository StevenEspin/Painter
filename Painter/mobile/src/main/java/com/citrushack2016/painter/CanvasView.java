package com.citrushack2016.painter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {
    Paint paint;
    Canvas canvas;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.paint = new Paint();
        this.canvas = new Canvas();
    }



    public void drawBasicLine() {

    }
}
