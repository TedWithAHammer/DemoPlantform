package com.leo.demoplantform.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.leo.demoplantform.R;
import com.leo.demoplantform.ui.activityTrasition.Transition1Activity;
import com.leo.demoplantform.ui.eventBus.EventBusActivity1;
import com.leo.demoplantform.ui.eventBus.EventBusActivity2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_bitmapregiondecoder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BitmapRegionDecoderActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_snackbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SnackbarActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BitmapHandlerActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_translucent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TranslucentActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_transition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Transition1Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_eventbus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventBusActivity2.class);
                startActivity(intent);
            }
        });

    }
}
