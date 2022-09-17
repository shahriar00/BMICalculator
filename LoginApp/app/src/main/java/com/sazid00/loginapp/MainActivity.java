package com.sazid00.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button signup_button,already_button;

    EditText userName,passWord,repassWord;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Login");


        signup_button = findViewById(R.id.register);
        already_button = findViewById(R.id.already);
        db = new DBHelper(this);


        userName = findViewById(R.id.username);
        passWord = findViewById(R.id.password);
        repassWord = findViewById(R.id.confirm_password);


        already_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });


        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = userName.getText().toString();
                String pass = passWord.getText().toString();
                String repass = repassWord.getText().toString();

                if (TextUtils.isEmpty(user)|| TextUtils.isEmpty(pass)||TextUtils.isEmpty(repass)) {

                    Toast.makeText(MainActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals(repass)) {

                        Boolean check_user = db.check_username(user);

                        if (check_user == false) {
                            Boolean insert = db.insert_userdata(user, pass);

                            if (insert == true) {

                                    Toast.makeText(MainActivity.this, "Registration Complete and ready to sign up", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(MainActivity.this, ShowDetails.class);
                                    startActivity(intent);


                            } else {
                                Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(MainActivity.this, "User name already exists", Toast.LENGTH_SHORT).show();
                        }


                    }
                    else {

                        Toast.makeText(MainActivity.this, "Password are not matching", Toast.LENGTH_SHORT).show();

                    }
                }




            }
        });

    }
}