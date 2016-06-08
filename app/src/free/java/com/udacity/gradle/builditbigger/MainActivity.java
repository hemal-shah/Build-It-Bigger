package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import hemal.mukesh.shah.showmessage.ShowJoke;

/**
 * Created by hemal on 8/6/16.
 */

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog = null;
    InterstitialAd interstitialAd = null;

    String storedJoke = "Empty Joke retrieved!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Getting your joke....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                showJoke(storedJoke);
            }
        });
    }


    public void showJoke(String joke) {
        Intent intent = new Intent(MainActivity.this, ShowJoke.class);
        intent.putExtra(ShowJoke.PASS_JOKE_TAG, joke);
        startActivity(intent);
    }

    public void tellJoke(View view) {

        progressDialog.show();

        //TODO add your own test device id...from the logcat.
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("1B9E645F6AEB9B725AACE600DC298402")
                .build();

        interstitialAd.loadAd(adRequest);

        new FetchJokeTask().execute(new Callback() {
            @Override
            public void displayJoke(String joke) {

                progressDialog.hide();

                if (interstitialAd.isLoaded()) {
                    storedJoke = joke;
                    interstitialAd.show();
                }
                showJoke(joke);
            }
        });


    }
}
