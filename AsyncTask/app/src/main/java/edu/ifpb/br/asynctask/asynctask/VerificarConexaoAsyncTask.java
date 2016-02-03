package edu.ifpb.br.asynctask.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import edu.ifpb.br.asynctask.util.HttpService;
import edu.ifpb.br.asynctask.util.Response;

/**
 * Created by Matheus on 03/02/2016.
 */
public class VerificarConexaoAsyncTask extends AsyncTask<Void, Void, Response> {
    Context context;

    public VerificarConexaoAsyncTask(Context context) {
        this.context = context;
    }
    @Override
    protected Response doInBackground(Void... params) {

        JSONObject jsonObject = new JSONObject();

        Response response = null;

        HttpURLConnection connection = null;


        try {

            connection = HttpService.sendGetRequest("statusServer");
            int statusCodeHttp = connection.getResponseCode();

            String contentValue = HttpService.getHttpContent(connection);

            response = new Response(statusCodeHttp, contentValue);

        } catch (MalformedURLException ex) {

            Log.e("NotificationWearApp", "MalformedURLException");

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

                String online = json.getString("online");
                Toast.makeText(context, online, Toast.LENGTH_LONG).show();
            }

        } catch (JSONException e) {

            Log.e("NotificationWearApp", "JSONException: " + e);
        }
    }
}
