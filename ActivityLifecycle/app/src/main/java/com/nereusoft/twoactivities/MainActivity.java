package com.nereusoft.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";

    private EditText mMessageEditText;

    public static final int TEXT_REQUEST = 1;

    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
        Log.d(LOG_TAG, "onCreate");
        if (savedInstanceState != null) {
            if(savedInstanceState.getBoolean("reply_visible")) {
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(savedInstanceState.getString("reply_text"));
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        String message = mMessageEditText.getText().toString();
        /**
         * The Intent constructor takes two arguments for an explicit Intent:
         * an application Context and the specific component that will receive that Intent.
         * Here you should use this as the Context, and SecondActivity.class
         * as the specific class:
         */
        /**
         * The Intent extras are key/value pairs in a Bundle. A Bundle is a collection of data,
         * stored as key/value pairs. To pass information from one Activity to another,
         * you put keys and values into the Intent extra Bundle from the sending Activity,
         * and then get them back out again in the receiving Activity.
         */
        Intent intent = null;
        intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    /**
     * @param requestCode
     * @param resultCode
     * @param data
     * The three arguments to onActivityResult() contain all the information you need to handle the
     * return data: the requestCode you set when you launched the Activity with startActivityForResult(),
     * the resultCode set in the launched Activity (usually one of RESULT_OK or RESULT_CANCELED),
     * and the Intent data that contains the data returned from the launch Activity
     */

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }


    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    /**
     * The state of each Activity is stored as a set of key/value pairs in a Bundle object called the
     * Activity instance state. The system saves default state information to instance state Bundle
     * just before the Activity is stopped, and passes that Bundle to the new Activity instance to restore.
     *
     * To keep from losing data in an Activity when it is unexpectedly destroyed and recreated,
     * you need to implement the onSaveInstanceState() method. The system calls this method on your
     * Activity (between onPause() and onStop()) when there is a possibility the Activity may be
     * destroyed and recreated.
     *
     * You may have noticed that rotating the device does not affect the state of the second Activity at all.
     * This is because the second Activity layout and state are generated from the layout and the Intent
     * that activated it. Even if the Activity is recreated, the Intent is still there and the data in that
     * Intent is still used each time the onCreate() method in the second Activity is called.
     *
     * In addition, you may notice that in each Activity, any text you typed into message or
     * reply EditText elements is retained even when the device is rotated. This is because the
     * state information of some of the View elements in your layout are automatically saved
     * across configuration changes, and the current value of an EditText is one of those cases.
     */

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mReplyHeadTextView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text",mReplyTextView.getText().toString());
        }
    }




}
