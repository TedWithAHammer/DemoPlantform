package com.leo.demoplantform.ui.activityTrasition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.util.Pair;
import android.view.View;

import com.leo.demoplantform.R;
import com.leo.demoplantform.base.BaseActivity;
import com.leo.potato.PotatoInjection;

public class Transition1Activity extends BaseActivity {
    @PotatoInjection(idStr = "showView1", click = "animationStart")
    View animationView1;
    @PotatoInjection(idStr = "showView2", click = "animationStart")
    View animationView2;
    private Pair p1;
    private Pair p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition1);

        p1 = new Pair(animationView1, ViewCompat.getTransitionName(animationView1));
        p2 = new Pair(animationView2, ViewCompat.getTransitionName(animationView2));
    }

    void animationStart(View v) {
        startActivity(new Intent(this, Transition2Activity.class), ActivityOptions.makeSceneTransitionAnimation(this, p1, p2).toBundle());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
