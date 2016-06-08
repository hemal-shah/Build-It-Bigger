package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import hemal.mukesh.shah.showmessage.ShowJoke;

/**
 * Created by hemal on 8/6/16.
 */

public class MainActivity extends AppCompatActivity {


    ProgressDialog progressDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Getting your joke....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);

    }

    public void tellJoke(View view) {
        progressDialog.show();
        new FetchJokeTask().execute(new Callback() {
            @Override
            public void displayJoke(String joke) {
                progressDialog.hide();
                Intent intent = new Intent(MainActivity.this, ShowJoke.class);
                intent.putExtra(ShowJoke.PASS_JOKE_TAG, joke);
                startActivity(intent);
            }
        });
    }
}
