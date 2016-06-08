package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import hemal.mukesh.shah.showmessage.ShowJoke;

/**
 * Created by hemal on 8/6/16.
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {
        new FetchJokeTask().execute(new Callback() {
            @Override
            public void displayJoke(String joke) {
                Intent intent = new Intent(MainActivity.this, ShowJoke.class);
                intent.putExtra(ShowJoke.PASS_JOKE_TAG, joke);
                startActivity(intent);
            }
        });
    }
}
