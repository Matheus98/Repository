package br.edu.ifpb.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import br.edu.ifpb.util.HttpService;

public class LoginAsyncTask extends AsyncTask<String, Void, HttpURLConnection> {

    Context context;

    public LoginAsyncTask(Context activity) {

        this.context = activity;
    }

    @Override
    protected HttpURLConnection doInBackground(String... valores) {
        Log.i("Notificationcomunicacaorest", "doInBackgroung: "+ valores[0]);

        HttpURLConnection connection = null;

        try {

            connection = HttpService.sendGetRequest("servicoservlet");

        } catch (MalformedURLException ex) {

            Log.e("Notificationcomunicacao", "MalformedURLException");

        } catch (IOException ex) {

            Log.e("Notificationcomunicacao", "MalformedURLException");
        }

        return connection;
    }

    @Override
    protected void onPostExecute(HttpURLConnection connection) {

        try {

            int status = connection.getResponseCode();

            Log.i("Notificationcomunicacao", "Status HTTP-Response: " + status);

            String contentValue = HttpService.getHttpContent(connection);
            JSONObject json = new JSONObject(contentValue);

            String nome = json.getString("nome");
            Toast.makeText(context, nome, Toast.LENGTH_LONG).show();

            String senha = json.getString("senha");
            Toast.makeText(context, senha, Toast.LENGTH_LONG).show();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (JSONException e) {

            Log.e("Notificationcomunicacao", "JSONException");
        }


    }
}