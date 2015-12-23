package br.edu.ifpb.comunicacaorest;

import android.util.Log;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifpb.asynctask.LoginAsyncTask;
import comunicacaorest.ifpb.edu.br.comunicacaorest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button asyncTaskButton = (Button) findViewById(R.id.enviarButton);
        asyncTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("ComunicacaoRest", "Clique no botão Enviar");

                EditText nomeEditText = (EditText) findViewById(R.id.nomeEditText);
                String nome = nomeEditText.getText().toString();

                EditText senhaEditText = (EditText) findViewById(R.id.senhaEditText);
                String senha = senhaEditText.getText().toString();

                LoginAsyncTask loginAsyncTask = new LoginAsyncTask(v.getContext());

                String[] valores = {nome, senha};

                loginAsyncTask.execute(valores);
            }
        });
    }
}

