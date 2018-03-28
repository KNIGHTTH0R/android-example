package com.amadeus.amadeusflightreservations;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class AmadeusActivity extends AppCompatActivity {

    private static final String TAG = "Amadeus APP";
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amadeus_amadeus);


        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getSupportFragmentManager();

        fragment = new SetupFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment).commit();


    }

    public void replaceFragments(Class fragmentClass, String... params) {
        //fragment = new FlightListFragment();
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        fragmentManager.beginTransaction().replace(R.id.main_container, fragment)
                .commit();
        if (fragment instanceof FlightListFragment){
            ((FlightListFragment) fragment).setArguments( params);
        } else if (fragment instanceof  FamilyComboListFragment){
            ((FamilyComboListFragment) fragment).setArguments( params);

        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new SetupFragment();
                    break;
                case R.id.navigation_dashboard:
                    fragment = new SearchCitiesFragment();
                    break;

                case R.id.navigation_notifications:
                    fragment = new FamilyCombosFragment();
                    break;

            }
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_container, fragment).commit();
            return true;
        }
    };

}
