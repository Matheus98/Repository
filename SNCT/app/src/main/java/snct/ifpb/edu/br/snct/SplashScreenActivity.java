package snct.ifpb.edu.br.snct;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler SplashScren = new Handler();
        SplashScren.postDelayed(SplashScreenActivity.this, 3000);
    }
    public void run(){
        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
        finish();
    }

}
