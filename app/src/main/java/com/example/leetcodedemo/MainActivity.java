package com.example.leetcodedemo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MainActivity extends AppCompatActivity {

    private static Drawable mDrawable;



    Runnable ref1 = new MyRunnable();
    Runnable ref2 = new Runnable() {
        @Override
        public void run() {

        }
    };

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = new ImageView(this);
        mDrawable = getResources().getDrawable(R.drawable.ic_launcher_background);
        iv.setImageDrawable(mDrawable);
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
    }
}
