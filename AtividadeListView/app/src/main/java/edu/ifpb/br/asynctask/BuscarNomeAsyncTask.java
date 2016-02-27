package edu.ifpb.br.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.ifpb.br.activity.MainActivity;
import edu.ifpb.br.util.HttpService;
import edu.ifpb.br.util.Response;

/**
 * Created by Matheus on 25/02/2016.
 */
public class BuscarNomeAsyncTask extends AsyncTask<JSONObject, Void, Response>{


    @Override
    protected Response doInBackground(JSONObject... jsons) {

        Response response = null;

        JSONObject json = jsons[0];

        Log.i("AtividadeListView", "doInBackground (JSON): " + json);
        //Chamando o metodo no HttpService
        try {

            response = HttpService.sendJSONPostResquest("get-byname", json);

        }catch (IOException e){

            Log.e("AtividadeListView", e.getMessage());

        }

        return response;

    }
    @Override
    protected void onPostExecute(Response response) {

        String nome = null;

        List<String> nomes = new ArrayList<String>();

        int i;


        try {

            //JSON Parsing, getting o valor enviado pelo metodo e colocando em jsonArray
            JSONArray jsonArray = new JSONArray(response.getContentValue());

            //Iterando o jsonArray e adicionando na lista
            for (i =0; i < jsonArray.length();i++){

                JSONObject jsonObject = new JSONObject(jsonArray.getString(i));

                nome = jsonObject.getString("fullName");

                nomes.add(nome);

            }


        } catch (JSONException e) {

            e.printStackTrace();

        }

        //Chamando o metodo na activity principal
        MainActivity.lista(nomes);

    }
}

