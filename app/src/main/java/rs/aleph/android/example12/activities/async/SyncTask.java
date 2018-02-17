package rs.aleph.android.example12.activities.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.activities.fragments.MasterFragment;
import rs.aleph.android.example12.activities.model.Category;
import rs.aleph.android.example12.activities.model.Meal;
import rs.aleph.android.example12.activities.provider.CategoryProvider;
import rs.aleph.android.example12.activities.provider.MealProvider;

/**
 * Created by tijana on 17.2.18..
 */

public class SyncTask extends AsyncTask<Void, Void, Void>{
    private Activity activity;
    private MasterFragment.OnItemSelectedListener listener;
    private MasterFragment fragment;

    public SyncTask(Activity activity, MasterFragment fragment) {
        this.activity = activity;
        listener = (MasterFragment.OnItemSelectedListener) activity;
        this.fragment = fragment;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Toast.makeText(activity, "Pozdrav iz onPostExecute", Toast.LENGTH_SHORT).show();

        final List<String> mealNames = MealProvider.getMealNames();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(activity, R.layout.list_item, mealNames);
        ListView listView = (ListView) fragment.getView().findViewById(R.id.listofMeals);
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onItemSelected(position);
            }
        });
    }

}
