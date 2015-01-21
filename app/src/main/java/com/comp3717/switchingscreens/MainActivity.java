package com.comp3717.switchingscreens;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * MainActivity.java
 * MainActivity for app that sends name user entered between screens.
 * @version 1.0
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onGetNameClick(View view) {

        Intent getNameScreenIntent = new Intent(this, SecondScreen.class);

        final int result = 1;

        /* put data we want to send over to second screen.
        * callingActivity : string's name
        * MainActivity : string data to be passed over. */
        getNameScreenIntent.putExtra("callingActivity", "MainActivity");

        /* Call the activity without data being sent back. */
        //startActivity(getNameScreenIntent);

        /* Call the activity and send data back */
        startActivityForResult(getNameScreenIntent, result);

    }

    /**
     * Handle user name being sent back after SecondScreen closes.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //create TextView to put user's name in it
        TextView theUserNameMessage = (TextView) findViewById(R.id.userNameMessage);

        //get name sent back sent from SecondScreen which just closed.
        //UserName : key
        String nameSentBack = data.getStringExtra("UserName");

        theUserNameMessage.append(" " + nameSentBack);

    }

}
