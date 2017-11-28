package com.teamcaffeine.hotswap.activity.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.teamcaffeine.hotswap.R;

public class NavigationActivity extends AppCompatActivity implements BlankFragment.BlankFragmentListener, BlankFragment2.BlankFragment2Listener {

    private final String TAG = "NavigationActivity";

    public BottomNavigationView navigation;

    private BlankFragment blankFragment;
    private BlankFragment2 blankFragment2;
    final FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction ft;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Log.i(TAG, "nav home: ");
                    ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.dynamicContent, blankFragment);
                    ft.commit();
                    return true;
                case R.id.navigation_search:
                    Log.i(TAG, "nav search: ");
                    ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.dynamicContent, blankFragment2);
                    ft.commit();
                    return true;
                case R.id.navigation_inbox:
                    Log.i(TAG, "nav inbox: ");
                    return true;
                case R.id.navigation_profile:
                    Log.i(TAG, "nav profile: ");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        blankFragment = new BlankFragment();
        blankFragment2 = new BlankFragment2();
    }
}
