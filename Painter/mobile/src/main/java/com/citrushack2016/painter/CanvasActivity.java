package com.citrushack2016.painter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        CanvasView canvasView = (CanvasView) findViewById(R.id.canvas_view);

        //declare the FAB, link it to the layout
        final FloatingActionButton anchorFAB = (FloatingActionButton) findViewById(R.id.FAB_anchor);//initiates calibration functions for the watch
        final FloatingActionButton clearFAB = (FloatingActionButton) findViewById(R.id.FAB_clear);//clears the current canvas of points, resets activity to defaults. Does requires new calibration
        final FloatingActionButton saveFAB = (FloatingActionButton) findViewById(R.id.FAB_save);//takes a snapshot of the current canvas

        FloatingActionButton menuFAB = (FloatingActionButton) findViewById(R.id.FAB_expand_menu);
        menuFAB.setRippleColor(getResources().getColor(R.color.colorAccentLight));
        //declare set the onClickListener for the menuFAB via anonymous inner class
        menuFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(anchorFAB.getVisibility() == view.INVISIBLE || clearFAB.getVisibility()==view.INVISIBLE || saveFAB.getVisibility() == view.INVISIBLE) {//if the sub-FABs are hidden, make them visible

                    anchorFAB.setClickable(true);//make the FAB clickable
                    anchorFAB.show();//show it via animation
                    anchorFAB.setVisibility(view.VISIBLE);//make sure it is visible

                    clearFAB.setClickable(true);
                    clearFAB.show();
                    clearFAB.setVisibility(view.VISIBLE);

                    saveFAB.setClickable(true);
                    saveFAB.show();
                    saveFAB.setVisibility(view.VISIBLE);
                } else { //otherwise, hide them and make them invisible
                    anchorFAB.setClickable(false);
                    anchorFAB.hide();
                    anchorFAB.setVisibility(view.INVISIBLE);

                    clearFAB.setClickable(false);
                    clearFAB.hide();
                    clearFAB.setVisibility(view.INVISIBLE);

                    saveFAB.setClickable(true);
                    saveFAB.hide();
                    saveFAB.setVisibility(view.INVISIBLE);
                }
            }
        });
    }
}
