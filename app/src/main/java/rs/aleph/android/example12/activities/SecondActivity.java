package rs.aleph.android.example12.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import rs.aleph.android.example12.R;

// Each activity extends Activity class
public class SecondActivity extends Activity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    // onCreate method is a lifecycle method called when he activity is starting
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Each lifecycle method should call the method it overrides
        super.onCreate(savedInstanceState);
        // setContentView method draws UI
        setContentView(R.layout.activity_second);

        // Shows a toast message (a pop-up message)
        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onCreate()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onStart method is a lifecycle method called after onCreate (or after onRestart when the
    // activity had been stopped, but is now again being displayed to the user)
    @Override
    protected void onStart() {
        super.onStart();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onStart()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onRestart method is a lifecycle method called after onStop when the current activity is
    // being re-displayed to the user
    @Override
    protected void onRestart() {
        super.onRestart();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onRestart()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onResume method is a lifecycle method called after onRestoreInstanceState, onRestart, or
    // onPause, for your activity to start interacting with the user
    @Override
    protected void onResume() {
        super.onResume();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onResume()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onPause method is a lifecycle method called when an activity is going into the background,
    // but has not (yet) been killed
    @Override
    protected void onPause() {
        super.onPause();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onPause()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onStop method is a lifecycle method called when the activity are no longer visible to the user
    @Override
    protected void onStop() {
        super.onStop();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onStop()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onDestroy method is a lifecycle method that perform any final cleanup before an activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onDestroy()", Toast.LENGTH_SHORT);
        toast.show();
    }


    public void btnStartActivityClicked(View view) {

        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);

        startActivity(intent);
    }

    public void btnOpenCameraClicked(View view) {
 	Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    	if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
        	startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    	}
    }
}
