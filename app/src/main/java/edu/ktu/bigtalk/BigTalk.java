package edu.ktu.bigtalk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class BigTalk extends AppCompatActivity {
    Random rand = new Random();
    int now = -2;
    Button next;
    Button menu;
    TextView text;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_to_know);
    next = (Button) findViewById(R.id.next);
    menu = (Button) findViewById(R.id.menu);
    text = (TextView) findViewById(R.id.editText);
    int buves = getIntent().getIntExtra("flag", -1);
    List<String> list = read();
    next.setOnClickListener(goNext);
    now = rand.nextInt(list.size()-1);
    while(now == buves) {
        now = rand.nextInt((list.size()-1) );
    }
    text.setText(list.get(now));

    }

    View.OnClickListener goNext = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            Intent intent = new Intent(context, BigTalk.class);
            intent.putExtra("flag",now);
            context.startActivity(intent);
        }
    };

    View.OnClickListener goMenu = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            Intent intent = new Intent(context, BigTalk.class);
            intent.putExtra("flag",now);
            context.startActivity(intent);
        }
    };

    private List<String> read(){
        List<String> list = new ArrayList<String>();
        BufferedReader reader;

        try{
            final InputStream file = getAssets().open("klausimai.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while(line != null){
                Log.d("StackOverflow", line);
                line = reader.readLine();
                list.add(line);
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return list;
    }
}
