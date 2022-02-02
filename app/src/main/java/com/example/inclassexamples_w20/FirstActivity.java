package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {
    private ArrayList<String> elements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView loads objects onto the screen.
        // Before this function, the screen is empty.
        setContentView(R.layout.activity_main);

        ListView myList = findViewById(R.id.theListView);

        MyListAdapter adapter = new MyListAdapter();
        myList.setAdapter(adapter);

        Button myButton = findViewById(R.id.addButton);
        myButton.setOnClickListener(click -> {
            elements.add("New element");
            adapter.notifyDataSetChanged();
        });

        myList.setOnItemLongClickListener((p, b, pos, id) -> {
            System.out.println("HIIII");
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("A Title")
                    .setMessage("Do you want to add stuff?")
                    .setPositiveButton("Yes", (click, arg) -> {
                        elements.add("Hello");
                        adapter.notifyDataSetChanged();
                    })
                    .setNegativeButton("No", (click, arg) -> {})
                    .setNeutralButton("Maybe", (click, arg) -> {})
                    .setView(getLayoutInflater().inflate(R.layout.row_layout, null))
                    .create().show();
            return true;
        });
    }

    private class MyListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return elements.size();
        }

        @Override
        public Object getItem(int position) {
            return "This is row " + position;
        }

        @Override
        public long getItemId(int position) {
            return (long) position;
        }

        @Override
        public View getView(int position, View old, ViewGroup parent) {
            View newView = old;

            LayoutInflater inflater = getLayoutInflater();

            if (newView == null) {
                newView = inflater.inflate(R.layout.row_layout, parent, false);
            }

            TextView tView = newView.findViewById(R.id.textGoesHere);
            tView.setText(getItem(position).toString());

            return newView;
        }
    }
}