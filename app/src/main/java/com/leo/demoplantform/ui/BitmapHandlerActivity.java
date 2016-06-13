package com.leo.demoplantform.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.leo.demoplantform.R;
import com.leo.potato.PotatoInjection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class BitmapHandlerActivity extends AppCompatActivity {
    private Bitmap bmp;

    @PotatoInjection(idStr = "imageOriginalInfo")
    private TextView tv1;
    @PotatoInjection(idStr = "imageNewInfo")
    private TextView tv2;
    @PotatoInjection(idStr = "cacheInfo")
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_handler);
        tv1 = (TextView) findViewById(R.id.tvOriginalInfo);
        tv2 = (TextView) findViewById(R.id.tvNewInfo);
        tv3 = (TextView) findViewById(R.id.tvCacheInfo);
        bmp = ((BitmapDrawable) getResources().getDrawable(R.drawable.test1440_900)).getBitmap();
        printOriginalBmpInfo();
//        compressInSize2();
        compressInQuality();
    }

    void printOriginalBmpInfo() {
        BitmapFactory.Options op = new BitmapFactory.Options();
        op.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.test1440_900, op);
        String s = String.format("width:%d,height:%d \n", op.outWidth, op.outHeight);
        tv1.setText(s);
    }

    void compressInSize1() {
        BitmapFactory.Options op = new BitmapFactory.Options();
        op.inJustDecodeBounds = true;
        op.inSampleSize = 2;
        BitmapFactory.decodeResource(getResources(), R.drawable.test1440_900, op);
        String s = String.format("width:%d,height:%d \n", op.outWidth, op.outHeight);
        tv2.setText(s);
    }

    void compressInSize2() {
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);
        Bitmap newBmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth() / 3, bmp.getHeight() / 3, matrix, false);
        String s = String.format("width:%d,height:%d \n", newBmp.getWidth(), newBmp.getHeight());
        String s1 = String.format("width:%d,height:%d \n", bmp.getWidth(), bmp.getHeight());
        tv2.setText(s + s1);
    }

    void compressInQuality() {
        long a = bmp.getRowBytes() * bmp.getHeight();
        tv3.setText("original cache size" + a);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 40, bao);
        InputStream is = new ByteArrayInputStream(bao.toByteArray());
        Bitmap newBmp = BitmapFactory.decodeStream(is);
        long b = newBmp.getRowBytes() * newBmp.getHeight();
        tv3.setText(tv3.getText().toString() + " new cache size" + b);
    }
}
