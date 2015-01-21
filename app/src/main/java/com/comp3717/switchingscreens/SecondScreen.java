package com.comp3717.switchingscreens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * SecondScreen.java
 * Screen that takes user name string.
 * Created by Jessica on 2015-01-20.
 */
public class SecondScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set appropriate layout (res/layout)
        setContentView(R.layout.second_layout);

        //get data passed over from MainActivity
        Intent activityThatCalled = getIntent();

        /*String to hold data sent from MainActivity (extra data sent)
        * callingActivity : key.*/
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");

        //cast as TextView because the return type is View
        TextView callingActivityMessage = (TextView) findViewById(R.id.callingActivityInfoTextView);

        //new message about what activity called
        callingActivityMessage.append(" " + previousActivity);

    }

    public void onSendUserName(View view) {

        //Field for name entered by the user
        EditText userNameET = (EditText) findViewById(R.id.userNameEditText);

        //get name entered in EditText
        String userName = String.valueOf(userNameET.getText());

        //Intent to send userName back to calling activity
        Intent goingBack = new Intent();

        //key and value to be sent back
        goingBack.putExtra("UserName", userName);

        /* Result of activity executing.
        * RESULT_CANCELLED is passed back if screen crashes. */
        setResult(RESULT_OK, goingBack);

        //close screen
        finish();

    }
}
