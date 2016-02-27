package edu.ifpb.br.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import listview.edu.ifpb.br.atividadelistview.R;

public class SplashScreenActivity extends Activity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(SplashScreenActivity.this, 3500);
    }

    @Override
    public void run() {

        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
        finish();

    }
}
