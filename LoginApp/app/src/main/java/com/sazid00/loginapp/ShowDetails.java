package com.sazid00.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ShowDetails extends AppCompatActivity {

    TextView meter,cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        this.setTitle("Show BMI Calculator");


        meter = findViewById(R.id.meterTV);
        cm = findViewById(R.id.cmTV);

        meter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShowDetails.this, "Thanks for Choice", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ShowDetails.this,Meter.class);
                startActivity(intent);
            }
        });

        cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShowDetails.this, "Thanks for Choice", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ShowDetails.this,Centimeter.class);
                startActivity(intent);
            }
        });
    }
}