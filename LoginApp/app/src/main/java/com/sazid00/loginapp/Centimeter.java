package com.sazid00.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Centimeter extends AppCompatActivity {

    TextView male,female;

    EditText kg,meter;

    TextView resultTV,situation;
    Button bmi_cal;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.sign)
        {
            Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Centimeter.this,Login.class);
            startActivity(intent);
            finish();
        }


        if(item.getItemId() == R.id.reset)
        {
            kg.setText("");
            meter.setText("");
            resultTV.setText("");
            situation.setText("");

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centimeter);
        this.setTitle("Centimeter Scale");


        male = findViewById(R.id.maleTV);
        female = findViewById(R.id.femaleTV);
        kg = findViewById(R.id.kgET);
        meter = findViewById(R.id.meterET);
        resultTV = findViewById(R.id.resultTV);
        situation = findViewById(R.id.situationTV);
        bmi_cal = findViewById(R.id.bmi);




        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Centimeter.this, "Male Selected", Toast.LENGTH_SHORT).show();
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Centimeter.this, "Female Selected", Toast.LENGTH_SHORT).show();
            }
        });




        bmi_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String KG = kg.getText().toString().trim();
                String height = meter.getText().toString().trim();

                if(KG.isEmpty())
                {
                    kg.setError("Enter your weight");
                    kg.requestFocus();
                    return;
                }
                if(height.isEmpty())
                {
                    meter.setError("Enter your height");
                    meter.requestFocus();
                    return;
                }

                float kg_calc = Float.parseFloat(KG);
                float height_calc = Float.parseFloat(height);
                float convert_meter = height_calc/100;

                Float result = kg_calc/(convert_meter*convert_meter);

//                Underweight = <18.5
//                Normal weight = 18.5–24.9
//                Overweight = 25–29.9
//                Obesity = BMI of 30 or greater

                if(result<18.5)
                {
                    resultTV.setText(String.valueOf(result));
                    situation.setText("Underweight");
                }
                else if(result >=18.5 && result<=24.9)
                {
                    resultTV.setText(String.valueOf(result));
                    situation.setText("Normal weight");

                }
                else if(result >=25 && result<=29.9)
                {
                    resultTV.setText(String.valueOf(result));
                    situation.setText("Overweight");

                }
                else if(result >=30)
                {
                    resultTV.setText(String.valueOf(result));
                    situation.setText("Obesity");

                }


            }
        });







    }
}