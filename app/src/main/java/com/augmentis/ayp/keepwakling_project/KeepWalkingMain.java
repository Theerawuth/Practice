package com.augmentis.ayp.keepwakling_project;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class KeepWalkingMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_walking_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment f = new KeepWalkingListFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, f)
                .commit();
    }
}
