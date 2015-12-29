package ifpb.edu.br.asynktaskcomunicacaorest.asynctask;

/**
 * Created by Delberto on 29/12/2015.
 */
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import ifpb.edu.br.asynktaskcomunicacaorest.util.Response;
import ifpb.edu.br.asynktaskcomunicacaorest.util.HttpService;

/**
 * Created by Rhavy on 01/12/2015.
 */
public class LoginAsyncTask extends AsyncTask<String, Void, Response>{

    Context context;

    public LoginAsyncTask(Context activity) {

        this.context = activity;
    }

    @Override
    protected void onPreExecute() {

        Log.i("NotificationWearApp", "OnPreExecute");
    }

    @Override
    protected Response doInBackground(String... valores) {

        Log.i("NotificationWearApp", "doInBackground: " + valores[0]);

        Response response = null;
        HttpURLConnection connection = null;

        JSONObject jo = new JSONObject();

        try {

            jo.put("nome", valores[0]);
            jo.put("senha", valores[1]);


        } catch (Exception e) {
            Log.e("", "" + e.getMessage());
        }

        try {

            connection = HttpService.sendGetRequest("servicoservlet");
            HttpService.sendJSONPostResquest(jo,"servicoservlet");

            int statusCodeHttp = connection.getResponseCode();
            String contentValue = HttpService.getHttpContent(connection);

            response = new Response(statusCodeHttp, contentValue);

        } catch (MalformedURLException ex) {

            Log.e("NotificationWearApp","MalformedURLException");

        } catch (IOException ex) {

            Log.e("NotificationWearApp","MalformedURLException");

        } finally {

            connection.disconnect();
        }

        return response;
    }

    @Override
    protected void onPostExecute(Response response) {

        try {

            int status = response.getStatusCodeHttp();

            if (status == HttpURLConnection.HTTP_OK) {

                JSONObject json = new JSONObject(response.getContentValue());

                String nome = json.getString("nome");
                Log.i("NotificationWearApp", "Nome: " + nome);
                Toast.makeText(context, nome, Toast.LENGTH_LONG).show();
            }

        } catch (JSONException e) {

            Log.e("NotificationWearApp", "JSONException: " + e);
        }
    }
}