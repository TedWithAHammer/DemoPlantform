package com.leo.demoplantform.ui;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.leo.demoplantform.R;

public class SnackbarActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_snackbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout, "test", Snackbar.LENGTH_LONG).show();
            }
        });

    }
}
