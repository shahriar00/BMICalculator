package com.sazid00.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button login_button;

    EditText userName,passWord;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_button = findViewById(R.id.login);
        userName = findViewById(R.id.login_username);
        passWord = findViewById(R.id.login_password);
        db = new DBHelper(this);


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = userName.getText().toString();
                String pass = passWord.getText().toString();


                if(TextUtils.isEmpty(user)|| TextUtils.isEmpty(pass)) {

                    Toast.makeText(Login.this, "All fields required", Toast.LENGTH_SHORT).show();
                }
                else{

                    Boolean checkUserPass = db.check_username_password(user,pass);

                    if(checkUserPass == true)
                    {
                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this,ShowDetails.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }


                }


            }
        });



    }
}