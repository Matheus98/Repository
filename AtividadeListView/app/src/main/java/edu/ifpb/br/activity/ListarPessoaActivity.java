package edu.ifpb.br.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import edu.ifpb.br.entidade.Pessoa;
import listview.edu.ifpb.br.atividadelistview.R;
//Activity responsável por receber as informações e o objeto enviandos pela intent e listar as informações da pessoa clicada
public class ListarPessoaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pessoa);

        Intent intent = getIntent();

        Pessoa pessoaActivity = (Pessoa) intent.getSerializableExtra("pessoa");

        TextView txtInscription = (TextView) findViewById(R.id.inscription);
        TextView txtFullName = (TextView) findViewById(R.id.fullName);
        TextView txtId = (TextView) findViewById(R.id.id);
        TextView txtEmail = (TextView) findViewById(R.id.email);
        TextView txtIsDelivered = (TextView) findViewById(R.id.isDelivered);

        txtFullName.setText(pessoaActivity.getNome());
        txtInscription.setText(pessoaActivity.getDescricao());
        txtEmail.setText(pessoaActivity.getEmail());
        txtId.setText(" Identificação única "+pessoaActivity.getId());

        if (pessoaActivity.isEntregue()){

            txtIsDelivered.setText("Situação: Entregue");

        }else{

            txtIsDelivered.setText("Situação: Não entregue");

        }

    }
}
