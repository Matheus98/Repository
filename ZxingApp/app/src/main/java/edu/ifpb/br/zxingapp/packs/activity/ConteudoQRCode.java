package edu.ifpb.br.zxingapp.packs.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import edu.ifpb.br.zxingapp.R;

public class ConteudoQRCode extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo_qrcode);


        TextView conteudoQRcode = (TextView) findViewById(R.id.ConteudoShow);

        Intent intent = getIntent();

        conteudoQRcode.setText(("Content: " + (String) intent.getSerializableExtra("conteudoQRCode")));
    }
}
