package com.communitytax.directory;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.communitytax.directory.models.Datum;
import com.communitytax.directory.ui.EmployeeFragment;
public class MainActivity extends AppCompatActivity implements EmployeeFragment.OnListFragmentInteractionListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            FragmentTransaction transaction = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = EmployeeFragment.newInstance();  break;
                case R.id.navigation_dashboard:
                    selectedFragment  = EmployeeFragment.newInstance(); break;
                case R.id.navigation_notifications:
                    selectedFragment  = EmployeeFragment.newInstance(); break;
            }

            transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();
            return true;
        }
    };

    @Override
    public void onListFragmentInteraction(Datum item) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
    }
}