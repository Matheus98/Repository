package edu.ifpb.br.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.ifpb.br.asynctask.BuscarNomeAsyncTask;
import listview.edu.ifpb.br.atividadelistview.R;

public class MainActivity extends Activity implements TextWatcher {

    private static int TAMANHO_MINIMO_TEXTO = 4;

    private EditText nomeEditText;

    public static List<String> nomes;

    public static ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        nomeEditText.addTextChangedListener(this);

        ListView nomesListView = (ListView) findViewById(R.id.nomesListView);
        nomes = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);

        nomesListView.setAdapter(adapter);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        Log.i("AtidadeListView", "beforeTextChanged"+s);

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        Log.i("AtidadeListView", "onTextChanged"+s);

        String nome = s.toString();
        //JSON
        try{

            if(nome.length() >= TAMANHO_MINIMO_TEXTO){


                JSONObject json = new JSONObject();
                json.put("fullName",nome);

                BuscarNomeAsyncTask buscarNomeAsyncTask = new BuscarNomeAsyncTask();
                buscarNomeAsyncTask.execute(json);

                nomes.add(nome);
                adapter.notifyDataSetChanged();

            }

        }catch (JSONException e){

            Log.e("AtidadeListView", "onTextChanged"+e.getMessage());

        }

    }

    @Override
    public void afterTextChanged(Editable s) {

        Log.i("AtidadeListView","afterTextChanged: " + s);

    }


    public static void lista(List<String> name) {

        //Limpa a lista
        adapter.clear();

        //Iterando e colocando os nomes da lista no listView
        if(name != null){

            for (String item : name) {

                nomes.add(item);

                adapter.notifyDataSetChanged();
            }

        }else{

            Log.e("AtividadeListView", "MetodolistaErro");

        }

    }
}
