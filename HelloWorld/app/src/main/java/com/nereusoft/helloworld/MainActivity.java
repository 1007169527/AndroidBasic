package com.nereusoft.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Install the Android Studio development environment.
 * Create an emulator (virtual device) to run your app on your computer.
 * Create and run the Hello World app on the virtual and physical devices.
 * Explore the project layout.
 * Generate and view log messages from your app.
 * Explore the AndroidManifest.xml file.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
