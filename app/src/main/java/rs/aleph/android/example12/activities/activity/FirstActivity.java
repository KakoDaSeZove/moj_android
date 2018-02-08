package rs.aleph.android.example12.activities.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.activities.fragments.DetailFragment;
import rs.aleph.android.example12.activities.fragments.MasterFragment;

// Each activity extends Activity class
public class FirstActivity extends AppCompatActivity implements MasterFragment.OnItemSelectedListener {

    boolean landscape = false;

    // onCreate method is a lifecycle method called when he activity is starting
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Each lifecycle method should call the method it overrides
        super.onCreate(savedInstanceState);
        // setContentView method draws UI
        setContentView(R.layout.activity_main);

        Toolbar toolbar  = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Shows a toast message (a pop-up message)
        Snackbar snackbar = Snackbar.make(findViewById(R.id.master_view), "Hello from FirstActivity onCreate()", Snackbar.LENGTH_LONG);
        snackbar.show();

        Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onCreate()", Toast.LENGTH_SHORT);
        toast.show();

        // 1) Make notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setContentTitle("Baby friendly seat...");
        builder.setSmallIcon(R.drawable.ic_notification_icon);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_notification_icon));
        builder.setContentText("You've got baby friendly place in the restaurant with baby seat provided");

        // 3) Action on notification
        // Creates an explicit intent
        Intent intent = new Intent(this, FirstActivity.class);

        // The stack builder contains an artificial back stack
        TaskStackBuilder tsb = TaskStackBuilder.create(this);

        // Adds the back stack for the Intent
        tsb.addParentStack(FirstActivity.class);

        // Adds the Intent to the top of the stack
        tsb.addNextIntent(intent);

        PendingIntent pe = tsb.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pe);

        // 2) Display notification
        // Returns the handle to the notification manager
        NotificationManager manager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        // Notifies the user (id allows notification update later on)
        manager.notify(1, builder.build());

        if (savedInstanceState == null) {
            // FragmentTransaction is a set of changes (e.g. adding, removing and replacing fragments) that you want to perform at the same time.
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            MasterFragment masterFragment = new MasterFragment();

            ft.replace(R.id.master_view, masterFragment, "Master_Fragment_1");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        // If the device is in the landscape mode and the detail fragment is null create detail fragment
        if (findViewById(R.id.detail_view) != null) {
            landscape = true;
            getFragmentManager().popBackStack();

            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
            if (detailFragment == null) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                detailFragment = new DetailFragment();
                ft.replace(R.id.detail_view, detailFragment, "Detail_Fragment_1");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        } else {
            landscape = false;
        }

        //! Basic alert Dialog example
        AlertDialog.Builder basicAlertDialogBuilder = new AlertDialog.Builder(this);
        basicAlertDialogBuilder.setMessage(R.string.alert_dialog);
        basicAlertDialogBuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.master_view), R.string.sattisfied_message, Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        basicAlertDialogBuilder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.master_view), R.string.unsattisfied_message, Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        //basicAlertDialogBuilder.create().show();

        //! Pickup Dialog example
        AlertDialog.Builder pickUpAlertDialogBuilder = new AlertDialog.Builder(this);
        pickUpAlertDialogBuilder.setTitle(R.string.pick_up_alert_dialog);
        pickUpAlertDialogBuilder.setItems(R.array.a_tommorow_offer, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {


                Snackbar snackbar = Snackbar.make(findViewById(R.id.master_view), R.string.pick_up_message + getResources().getStringArray(R.array.a_tommorow_offer)[which], Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        //pickUpAlertDialogBuilder.create().show();


        //! Fragment Dialog example
        AlertDialog.Builder fragmentAlertDialogBuilder = new AlertDialog.Builder(this);
        fragmentAlertDialogBuilder.setView(getLayoutInflater().inflate(R.layout.fragment_dialog_example, null));
        fragmentAlertDialogBuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.master_view), "Hvala vam na saradnji.", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        fragmentAlertDialogBuilder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.master_view), "Potrudicemo se da budemo bolji.", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        //fragmentAlertDialogBuilder.create().show();

    }


    // onStart method is a lifecycle method called after onCreate (or after onRestart when the
    // activity had been stopped, but is now again being displayed to the user)
    @Override
    protected void onStart() {

        super.onStart();

        // Shows a toast message (a pop-up message)
        Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onStart()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onRestart method is a lifecycle method called after onStop when the current activity is
    // being re-displayed to the user
    @Override
    protected void onRestart() {

        super.onRestart();

        // Shows a toast message (a pop-up message)
        Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onRestart()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onResume method is a lifecycle method called after onRestoreInstanceState, onRestart, or
    // onPause, for your activity to start interacting with the user
    @Override
    protected void onResume() {

        super.onResume();

        // Shows a toast message (a pop-up message)
        Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onResume()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onPause method is a lifecycle method called when an activity is going into the background,
    // but has not (yet) been killed
    @Override
    protected void onPause() {

        super.onPause();

        // Shows a toast message (a pop-up message)
        Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onPause()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onStop method is a lifecycle method called when the activity are no longer visible to the user
    @Override
    protected void onStop() {

        super.onStop();

        // Shows a toast message (a pop-up message)
        Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onStop()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onDestroy method is a lifecycle method that perform any final cleanup before an activity is destroyed
    @Override
    protected void onDestroy() {

        super.onDestroy();

        // Shows a toast message (a pop-up message)
        Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onDestroy()", Toast.LENGTH_SHORT);
        toast.show();
    }


    @Override
    public void onItemSelected(int position) {

        // Shows a toast message (a pop-up message)
        Toast.makeText(getBaseContext(), "FirstActivity.onItemSelected()", Toast.LENGTH_SHORT).show();

        if (landscape) {
            // If the device is in the landscape mode updates detail fragment's content.
            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
            detailFragment.updateContent(position);
        } else {
            // If the device is in the portrait mode sets detail fragment's content and replaces master fragment with detail fragment in a fragment transaction.
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setContent(position);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.master_view, detailFragment, "Detail_Fragment_2");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }

        RestorantDatePickerFragement datePickerDialog = new RestorantDatePickerFragement();
        datePickerDialog.show(getFragmentManager(), "tag_name");

        RestorantTimePickerFragement timePickerDialog = new RestorantTimePickerFragement();
        //timePickerDialog.show(getFragmentManager(), "tag_name");
    }

    @SuppressLint("ValidFragment")
    private class RestorantDatePickerFragement extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle state) {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.master_view), "Rezervisali ste vase mesto u restoranu: " + year + "/" + (month + 1) + "/" + day, Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    @SuppressLint("ValidFragment")
    private class RestorantTimePickerFragement extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle state) {
            Calendar c = Calendar.getInstance();
            int hourOfDay = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), this, hourOfDay, minute, true);
        }

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.master_view), "Rezervisali ste vase mesto u restoranu: " + hourOfDay + ":" + minute, Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    public void onOpenSettingClicked(View view) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.master_view, new RestoranSettingsFragment())
                .commit();
    }

    @SuppressLint("ValidFragment")
    private class RestoranSettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle state) {
            super.onCreate(state);
            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.preferences);
        }
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.addMeal:
                Snackbar snackbar = Snackbar.make(findViewById(R.id.master_view), "Dodali ste jelo", Snackbar.LENGTH_LONG);
                snackbar.show();
                return true;
            case R.id.replaceMeal:
                snackbar = Snackbar.make(findViewById(R.id.master_view), "Zamenili ste jelo", Snackbar.LENGTH_LONG);
                snackbar.show();
                return true;
            case R.id.deleteMeal:
                snackbar = Snackbar.make(findViewById(R.id.master_view), "Uklonili ste jelo", Snackbar.LENGTH_LONG);
                snackbar.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
