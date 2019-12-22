package com.nereusoft.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

}
