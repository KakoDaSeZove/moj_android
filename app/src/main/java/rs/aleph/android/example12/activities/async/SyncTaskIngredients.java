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
import rs.aleph.android.example12.activities.fragments.DetailFragment;
import rs.aleph.android.example12.activities.fragments.MasterFragment;
import rs.aleph.android.example12.activities.model.Ingredients;
import rs.aleph.android.example12.activities.provider.IngredientsProvider;
import rs.aleph.android.example12.activities.provider.MealProvider;

/**
 * Created by tijana on 17.2.18..
 */


public class SyncTaskIngredients extends AsyncTask<Void, Void, List> {
    private Activity activity;
    private DetailFragment fragment;

    public SyncTaskIngredients(Activity activity, DetailFragment fragment) {
        this.activity = activity;
        this.fragment = fragment;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List doInBackground(Void... params) {
        try {

            Thread.sleep(2000);

            List<Ingredients> ingredients = IngredientsProvider.getIngredients();
            List<String> ingredientNames = new ArrayList<>();
            for (Ingredients ing : ingredients) {
                ingredientNames.add(ing.getName());
            }
            return ingredientNames;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List ingredient) {
        Toast.makeText(activity, "Pozdrav iz onPostExecute", Toast.LENGTH_SHORT).show();


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(activity, R.layout.list_ingredients, ingredient);
        ListView listView = (ListView) fragment.getView().findViewById(R.id.listofIngredients);

        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

    }

}

