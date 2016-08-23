package com.di.tang.myapplication.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.di.tang.myapplication.R;
import com.di.tang.myapplication.fragment.GeometricFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment);
        if(fragment == null){
            fragment = new GeometricFragment();
        }
        fragmentManager.beginTransaction()
                .add(R.id.fragment, fragment)
                .commit();
    }
}
