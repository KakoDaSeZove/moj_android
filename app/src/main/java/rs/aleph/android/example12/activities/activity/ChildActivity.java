package rs.aleph.android.example12.activities.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;

/**
 * Created by tijana on 8.2.18..
 */

public class ChildActivity extends FirstActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar toolbar = getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);
    }
}
