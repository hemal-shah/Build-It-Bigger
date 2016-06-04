package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by hemal on 4/6/16.
 */
public class FetchJokeTest extends AndroidTestCase {


    /**
     * Execute these tests from the gradle tasks panel by double clicking on the
     * connectedCheck task.
     */

    //One countdown when on the asynctasks' displayJoke method..
    CountDownLatch latch = new CountDownLatch(1);
    //variable to verify that the asyntask is completed in under 10 seconds.
    boolean checkValidity = false;

    public void testFetchJoke() throws Exception {
        new FetchJokeTask().execute(new Callback() {
            @Override
            public void displayJoke(String joke) {
                latch.countDown();
                assertNotNull("The message is not null", joke);
                assertTrue(!joke.trim().isEmpty());
                checkValidity = true;
            }
        });

        try {
            latch.await(15, TimeUnit.SECONDS);
            assertTrue(checkValidity);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
