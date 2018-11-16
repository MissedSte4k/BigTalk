package edu.ktu.bigtalk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartScreen extends AppCompatActivity {

    Button start;
    Button tips;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);


        start = (Button) findViewById(R.id.start);
        tips = (Button) findViewById(R.id.tips);

        start.setOnClickListener(goStart);
        tips.setOnClickListener(goTips);
    }


    View.OnClickListener goStart = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            Intent intent = new Intent(context, BigTalk.class);
            context.startActivity(intent);
        }
    };

    View.OnClickListener goTips = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            Intent intent = new Intent(context, TipsAndSuggestions.class);
            context.startActivity(intent);
        }
    };
}
