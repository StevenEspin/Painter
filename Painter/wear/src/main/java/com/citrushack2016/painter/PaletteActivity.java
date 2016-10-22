package com.citrushack2016.painter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PaletteActivity extends WearableActivity {

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private BoxInsetLayout mContainerView;

    protected boolean mPaintingEnabled = true;

    //private GestureDetectorCompat mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        setAmbientEnabled();

        //mGestureDetector = new GestureDetectorCompat(this, new PaletteOnGestureListener(this));
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
        if (isAmbient()) {
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
        } else {
            mContainerView.setBackground(null);
        }
    }

    public void onClickThicknessButton(View button) {
        Intent intent = new Intent(this, ThicknessActivity.class);
        startActivity(intent);
    }

    public void onClickEnableButton(View button) {
        mPaintingEnabled = !mPaintingEnabled;
        if(mPaintingEnabled) {
            ((ImageButton) button).setImageResource(R.drawable.pencil);
        } else {
            ((ImageButton) button).setImageResource(R.drawable.pencil_off);
        }
    }
}
