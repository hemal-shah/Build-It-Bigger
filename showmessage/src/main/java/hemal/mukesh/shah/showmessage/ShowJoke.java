package hemal.mukesh.shah.showmessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by hemal on 1/6/16.
 */
public class ShowJoke extends AppCompatActivity {

    TextView textView;
    public static final String PASS_JOKE_TAG = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_joke_layout);


        Intent incomingIntent = getIntent();
        String joke = incomingIntent.getStringExtra(PASS_JOKE_TAG);

        textView = (TextView) findViewById(R.id.tv_show_joke);

        if(joke != null && !joke.equals("")){
            textView.setText(joke);
        } else {
            textView.setText(R.string.no_data_obtained);
        }

    }
}
