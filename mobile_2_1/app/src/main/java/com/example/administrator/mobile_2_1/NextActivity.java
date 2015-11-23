package com.example.administrator.mobile_2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent in = this.getIntent();
        Toast.makeText(this, "Name: " + in.getStringExtra("name"), Toast.LENGTH_LONG).show();
    }
}
