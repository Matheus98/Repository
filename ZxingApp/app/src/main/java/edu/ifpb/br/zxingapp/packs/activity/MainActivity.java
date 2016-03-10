package edu.ifpb.br.zxingapp.packs.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import edu.ifpb.br.zxingapp.R;

public class MainActivity extends Activity implements OnClickListener {

    public static String SCAN = "com.google.zxing.client.android.SCAN";
    private Button scanBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanBtn = (Button)findViewById(R.id.scan_button);
        scanBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        IntentIntegrator scanIntegrator = new IntentIntegrator(MainActivity.this);
        scanIntegrator.initiateScan();

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {
            String conteudoQRCode = scanningResult.getContents();

            intent = new Intent(this, ConteudoQRCode.class);
            intent.putExtra("conteudoQRCode", conteudoQRCode);
            this.startActivity(intent);
            this.finish();

        }else{

            Log.i("ZxingApp", "onActivityResultErro");
        }


    }

}
