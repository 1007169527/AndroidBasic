package com.nereusoft.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Change the layout to use RelativeLayout.
 * Rearrange the views in the main layout to be relative to each other.
 *
 * A RelativeLayout is a view grouping in which each view is positioned and aligned relative to
 * other views within the group. In this task you will learn how to build a layout with RelativeLayout.
 */

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Now that you have mShowCount,
         * you can get a reference to the TextView using the ID you set in the layout file.
         * In order to get this reference only once, specify it in the onCreate() method.
         * As you learn in another lesson, the onCreate() method is used to inflate the layout,
         * which means to set the content view of the screen to the XML layout.
         * You can also use it to get references to other UI elements in the layout,
         * such as the TextView.
         *
         * A View, like a string, is a resource that can have an id.
         * The findViewById call takes the ID of a view as its parameter and returns the View.
         * Because the method returns a View, you have to cast the result to the view type you expect,
         * in this case (TextView).
         */
        mShowCount = (TextView) findViewById(R.id.show_count);

    }

    public void showToast(View view) {
        /**
         * Supply the context of the app Activity.
         * Because a Toast displays on top of the Activity UI,
         * the system needs information about the current Activity.
         * When you are already within the context of the Activity whose context you need,
         * use this as a shortcut.
         */
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if(mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

}
