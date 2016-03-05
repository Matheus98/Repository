package edu.ifpb.br.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import edu.ifpb.br.activity.MainActivity;
import edu.ifpb.br.callback.BuscarPessoaCallBack;
import edu.ifpb.br.entidade.Pessoa;
import edu.ifpb.br.util.HttpService;
import edu.ifpb.br.util.Response;

/**
 * Created by Matheus on 25/02/2016.
 */
public class BuscarNomeAsyncTask extends AsyncTask<Pessoa, Void, Response>{

    private BuscarPessoaCallBack buscarNomeCallBack;

    public BuscarNomeAsyncTask(BuscarPessoaCallBack buscarNomeCallBack) {

        this.buscarNomeCallBack = buscarNomeCallBack;
    }

    @Override
    protected Response doInBackground(Pessoa... pessoas) {

        Response response = null;

        Pessoa pessoa = pessoas[0];

        Gson gson = new Gson();

        Log.i("AtividadeListView", "doInBackground (GSON): " + pessoa);

        //Chamando o metodo no HttpService
        try {

            response = HttpService.sendJSONPostResquest("get-byname", gson.toJson(pessoa));

        }catch (IOException e){

            Log.e("AtividadeListView", e.getMessage());

        }

        return response;

    }
    @Override
    protected void onPostExecute(Response response) {

        int codeHttp = response.getStatusCodeHttp();

        Log.i("EditTextListener", "Código HTTP: " + codeHttp
                + " Conteúdo: " + response.getContentValue());

        if (codeHttp != HttpURLConnection.HTTP_OK) {

            buscarNomeCallBack.errorBuscarNome(response.getContentValue());

        } else {

            Gson gson = new Gson();
            List<Pessoa> pessoas = gson.fromJson(response.getContentValue(),
                    new TypeToken<ArrayList<Pessoa>>(){}.getType());

            buscarNomeCallBack.backBuscarNome(pessoas);
        }

    }
}

