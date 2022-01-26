package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView loads objects onto the screen.
        // Before this function, the screen is empty.
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.inputText);
        Button secondButton = findViewById(R.id.buttonToSecond);

        Intent nextPage = new Intent(this, SecondActivity.class);
            nextPage.putExtra("name","Bert");
            nextPage.putExtra("age", 20);
            nextPage.putExtra("typed", editText.getText().toString());

        secondButton.setOnClickListener( click -> startActivity( nextPage ));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
