package com.ebookfrenzy.statechange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
//import android.util.Log to use Log class.

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "StateChange";
    // declare a tag that will enable us to filter diagnostic messages in the log output.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate");
        // declare a tag that will enable us to filter diagnostic messages in the log output.
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG,"onRestart");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"onSaveInstanceState");

        final EditText editText = findViewById(R.id.editText);
        //obtain a reference to the view

        //obtain the text that the editText view contains via the object's getText() method:
        CharSequence userText = editText.getText();

        //Save teh text using the Bundle object's putCharSequence method, passing through the key "savedText", and the userText object as arguments:
        outState.putCharSequence("savedText",userText);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");

        final EditText editText = findViewById(R.id.editText);

        CharSequence userText = savedInstanceState.getCharSequence("savedText");

        editText.setText(userText);
    }


}
