package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.hemal.myapplication.backend.jokeEndpointApi.JokeEndpointApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by hemal on 1/6/16.
 */
public class FetchJokeTask extends AsyncTask<Callback, Void, String> {

    private static final String TAG = FetchJokeTask.class.getSimpleName();

    private static JokeEndpointApi jokeEndpointApi = null;
    public Callback callback;
    @Override
    protected String doInBackground(Callback... params) {

        if(jokeEndpointApi == null){
            JokeEndpointApi.Builder builder = new JokeEndpointApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-1332.appspot.com/_ah/api/");

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

