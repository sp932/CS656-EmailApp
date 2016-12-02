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
        // Flow: Step 1: Initialize Main activity
        // Tie activity to res/layout/auth.xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth);

    }

    public void authenticate(View view) {
        // Get username and password
        // Flow: Step 2: Get username and password

        EditText etUsername = (EditText)findViewById(R.id.username);
        EditText etPassword = (EditText)findViewById(R.id.password);

        sUsername = etUsername.getText().toString().trim();
        sPassword  = etPassword.getText().toString().trim();
        // TODO

        // Flow: Step 3: Authenticate
        // API Calls and whatnot

        // Flow: Step 4: Navigate to Inbox
        // Get username and password and send those strings to
        // inbox in case they are used for further API calls
        // The same logic would work with an OAUTH Token
        Button btnAuthenticate = (Button) findViewById(R.id.authenticate_button);
        btnAuthenticate.setTextColor(1);
        Intent newIntent = new Intent(MainActivity.this, InboxActivity.class);

        // Flow: Step 4: A Pass data as extras to next Activity, InboxActivity
        newIntent.putExtra("username",sUsername);
        newIntent.putExtra("password",sPassword);
        startActivity(newIntent); //Go to Inbox
    }

} // End main activity