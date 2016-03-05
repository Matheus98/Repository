package edu.ifpb.br.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.ifpb.br.adapter.PessoasCustomAdapter;
import edu.ifpb.br.asynctask.BuscarNomeAsyncTask;
import edu.ifpb.br.callback.BuscarPessoaCallBack;
import edu.ifpb.br.entidade.Pessoa;
import listview.edu.ifpb.br.atividadelistview.R;

public class MainActivity extends Activity implements TextWatcher, OnItemClickListener, BuscarPessoaCallBack {

    private static int TAMANHO_MINIMO_TEXTO = 4;

    private EditText nomeEditText;

    List<Pessoa> pessoas;

    PessoasCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recuperando o EditText e
        nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        nomeEditText.addTextChangedListener(this);

        ListView nomesListView = (ListView) findViewById(R.id.nomesListView);
        pessoas = new ArrayList<Pessoa>();
        adapter = new PessoasCustomAdapter(this, pessoas);

        // Adapter modificado.
        nomesListView.setAdapter(adapter);

        // Evento de OnItemClickListener.
        nomesListView.setOnItemClickListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        Log.i("AtidadeListView", "beforeTextChanged" + s);

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        Log.i("AtidadeListView", "onTextChanged" + s);

        String nome = s.toString();

        //Enviando o objeto pessoa para o AsyncTask, onde sera tratado

            if(nome.length() >= TAMANHO_MINIMO_TEXTO){


                Pessoa pessoa = new Pessoa();
                pessoa.setNome(nome);

                BuscarNomeAsyncTask buscarNomeAsyncTask = new BuscarNomeAsyncTask(this);
                buscarNomeAsyncTask.execute(pessoa);

            }else{

                this.pessoas.clear();

            }


    }

    @Override
    public void afterTextChanged(Editable s) {

        Log.i("AtidadeListView", "afterTextChanged: " + s);

    }
    // BuscarPessoaCallBack
    @Override
    public void backBuscarNome(List<Pessoa> pessoas) {

        this.pessoas.clear();
        this.pessoas.addAll(pessoas);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void errorBuscarNome(String error) {

        pessoas.clear();
        adapter.notifyDataSetChanged();

        Toast.makeText(this, error, Toast.LENGTH_LONG);
    }
    // OnItemClickListener
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Log.i("EditTextListener", "Position: " + position);

        //Intent acionada pelo click em lista e será redirecionada com o Bundle para ListarPessoaActivity

        Pessoa pessoa = pessoas.get(position);

        Intent intent = new Intent(this, ListarPessoaActivity.class);
        intent.putExtra("pessoa", pessoa);
        this.startActivity(intent);
        this.finish();

    }



}
