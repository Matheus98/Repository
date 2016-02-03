package edu.ifpb.br.asynctask.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import edu.ifpb.br.asynctask.R;
import edu.ifpb.br.asynctask.asynctask.VerificarConexaoAsyncTask;

public class SplashScreenActivity extends Activity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler SplashScren = new Handler();
        SplashScren.postDelayed(SplashScreenActivity.this, 3000);
    }

    @Override
    public void run() {
        VerificarConexaoAsyncTask verificaConexao = new VerificarConexaoAsyncTask(this);
        verificaConexao.execute();

    }
}
