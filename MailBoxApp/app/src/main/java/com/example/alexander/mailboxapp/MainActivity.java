package com.example.alexander.mailboxapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public String sUsername;
    public String sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth);

    }

    public void authenticate(View view) {
        // Get username and password
        //myActivity.this.mEdit.getText().toString()
        EditText etUsername = (EditText)findViewById(R.id.username);
        EditText etPassword = (EditText)findViewById(R.id.password);

        sUsername = etUsername.getText().toString().trim();
        sPassword  = etPassword.getText().toString().trim();
        // TODO
        // API Calls and whatnot

        Button btnAuthenticate = (Button) findViewById(R.id.authenticate_button);
        btnAuthenticate.setTextColor(1);
        Intent newIntent = new Intent(MainActivity.this, InboxActivity.class);

        newIntent.putExtra("username",sUsername);
        newIntent.putExtra("password",sPassword);
        startActivity(newIntent);
    }

} // End main activity