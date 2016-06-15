package com.leo.demoplantform.ui;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.leo.demoplantform.R;
import com.leo.demoplantform.base.BaseActivity;
import com.leo.potato.PotatoInjection;

public class TranslucentActivity extends BaseActivity {
    @PotatoInjection(idStr = "toolbar")
    Toolbar toolbar;
    @PotatoInjection(idStr = "drawlayout")
    DrawerLayout drawlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translucent);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_black_18dp);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawlayout.openDrawer(Gravity.LEFT);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
