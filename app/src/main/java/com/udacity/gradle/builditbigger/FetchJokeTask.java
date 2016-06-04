package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.example.hemal.myapplication.backend.jokeEndpointApi.JokeEndpointApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by hemal on 1/6/16.
 */
public class FetchJokeTask extends AsyncTask<Callback, Void, String> {

    private static final String TAG = FetchJokeTask.class.getSimpleName();

    private static JokeEndpointApi jokeEndpointApi = null;
    public Callback callback;
    //Gives error when on real device.
    private String root_url = "http://10.0.2.2:8080/_ah/api/";

    @Override
    protected String doInBackground(Callback... params) {

        if(jokeEndpointApi == null){
            JokeEndpointApi.Builder builder = new JokeEndpointApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl(root_url)
                    .setApplicationName("backend")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            jokeEndpointApi = builder.build();
        }
        callback = params[0];

        String joke = "";

        try {
            joke = jokeEndpointApi.getJokeEndpoint().execute().getJoke();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return joke;
    }


    @Override
    protected void onPostExecute(String joke) {
        callback.displayJoke(joke);
    }
}

