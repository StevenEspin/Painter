package com.citrushack2016.painter;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.util.SparseArray;

public class ThicknessActivity extends WearableActivity {
    /**
     * Initial (default) thickness
     */
    protected static final int INITIAL_THICKNESS = 1;

    /**
     * Currently selected thickness
     */
    protected int mSelectedThickness = INITIAL_THICKNESS;

    /**
     * Map of thickness numbers to mArrows
     */
    protected SparseArray<View> mArrows = new SparseArray<View>();

    /**
     * Map of thickness numbers to mButtons
     */
    protected SparseArray<View> mButtons = new SparseArray<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thickness);
        populateViewMaps();
        mButtons.get(INITIAL_THICKNESS).callOnClick();
    }

    /**
     * Populate view maps.
     */
    protected void populateViewMaps() {
        mArrows.put(1, findViewById(R.id.thick1_arrow));
        mArrows.put(2, findViewById(R.id.thick2_arrow));
        mArrows.put(3, findViewById(R.id.thick3_arrow));

        mButtons.put(1, findViewById(R.id.thick1_button));
        mButtons.put(2, findViewById(R.id.thick2_button));
        mButtons.put(3, findViewById(R.id.thick3_button));
    }

    protected void showArrow(View arrow) {
        arrow.setVisibility(View.VISIBLE);
    }

    protected void hideArrow(View arrow) {
        arrow.setVisibility(View.INVISIBLE);
    }

    public void onClickThick1Button(View button) {
        hideArrow(mArrows.get(mSelectedThickness));
        showArrow(mArrows.get(1));
        mSelectedThickness = 1;
    }

    public void onClickThick2Button(View button) {
        hideArrow(mArrows.get(mSelectedThickness));
        showArrow(mArrows.get(2));
        mSelectedThickness = 2;
    }

    public void onClickThick3Button(View button) {
        hideArrow(mArrows.get(mSelectedThickness));
        showArrow(mArrows.get(3));
        mSelectedThickness = 3;
    }

    /**
     * Get the selected thickness.
     * @return Selected thickness
     */
    public int getSelectedThickness() {
        return mSelectedThickness;
    }

    public void onClickThicknessBackButton(View button) {
        Intent intent = new Intent(this, PaletteActivity.class);
        startActivity(intent);
    }
}