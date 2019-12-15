package com.nereusoft.textviewi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Change the ConstraintLayout ViewGroup to RelativeLayout.
 * Add two TextView elements for the article heading and subheading.
 * Use TextAppearance styles and colors for the article heading and subheading.
 * Use HTML tags in the text string to control formatting.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
