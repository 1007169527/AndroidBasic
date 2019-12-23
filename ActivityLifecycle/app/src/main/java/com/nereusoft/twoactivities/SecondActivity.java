package com.nereusoft.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";

    private EditText mReply;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply = findViewById(R.id.editText_second);
        textView = findViewById(R.id.text_header);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.setText(message);
    }

    public void returnReply(View view) {

        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        /**
         * Set the result to RESULT_OK to indicate that the response was successful.
         * The Activity class defines the result codes, including RESULT_OK and RESULT_CANCELLED.
         */
        setResult(RESULT_OK,replyIntent);
        /**
         * Call finish() to close the Activity and return to MainActivity.
         */
        finish();
    }
}
