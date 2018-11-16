package edu.ktu.bigtalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TipsAndSuggestions extends AppCompatActivity {

    private TextView patarimai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_and_suggestions);

        patarimai = (TextView) findViewById(R.id.textView);

        read();
    }

    private void read(){
        BufferedReader reader;
        String viskas = "";
        try{
            final InputStream file = getAssets().open("patarimai.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while(line != null){
                Log.d("StackOverflow", line);
                line = reader.readLine();
                viskas = viskas + line + "\n";
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        patarimai.setText(viskas);
    }
}
