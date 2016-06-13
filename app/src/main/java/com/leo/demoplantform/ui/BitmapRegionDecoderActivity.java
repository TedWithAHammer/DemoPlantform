package com.leo.demoplantform.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.leo.demoplantform.R;

import java.io.IOException;
import java.io.InputStream;

public class BitmapRegionDecoderActivity extends AppCompatActivity {
    int originX = 0;
    int originY = 0;
    int bitmapWidth = 1920;
    int bitmapHeight = 1080;
    Rect rect = new Rect(originX, originX, originX + 500, originY + 500);
    private BitmapRegionDecoder brd;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_region_decoder);
        imageView = (ImageView) findViewById(R.id.imageview);
        try {
            InputStream is = getResources().openRawResource(R.raw.test1920_1080);
            BitmapFactory.Options op = new BitmapFactory.Options();
            op.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(is, null, op);
            bitmapWidth = op.outWidth;
            bitmapHeight = op.outHeight;
            brd = BitmapRegionDecoder.newInstance(is, false);
            refreshImageview();
        } catch (IOException e) {
            e.printStackTrace();
        }
        findViewById(R.id.btnLeft).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (originX - 10 > 0) {
                    originX -= 10;
                    rect.left = originX;
                    rect.right = originX + 500;
                    refreshImageview();
                }
            }
        });
        findViewById(R.id.btnRight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (originX + 10 < bitmapWidth) {
                    originX += 10;
                    rect.left = originX;
                    rect.right = originX + 500;
                    refreshImageview();
                }
            }
        });
        findViewById(R.id.btnUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (originY - 10 > 0) {
                    originY -= 10;
                    rect.top = originY;
                    rect.bottom = originY + 500;
                    refreshImageview();
                }
            }
        });
        findViewById(R.id.btnDown).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (originY + 10 < bitmapHeight) {
                    originY += 10;
                    rect.top = originY;
                    rect.bottom = originY + 500;
                    refreshImageview();
                }
            }
        });
    }

    void refreshImageview() {
        Log.i("-------", "rect:" + rect.right + "  " + rect.top + "    " + rect.right + "   " + rect.bottom);
        BitmapFactory.Options op = new BitmapFactory.Options();
        op.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bmp = brd.decodeRegion(rect, op);
        imageView.setImageBitmap(bmp);
    }

}
