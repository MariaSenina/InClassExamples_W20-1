package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        Bundle dataToPass = getIntent().getExtras();
        boolean isTablet = findViewById(R.id.fragmentLocation) != null;

        if(isTablet) {
            DetailFragment dFragment = new DetailFragment();
            dFragment.setArguments(dataToPass); //pass data to the the fragment
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentLocation, dFragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, EmptyActivity.class);
            startActivity ( intent, dataToPass);
        }
    }
}