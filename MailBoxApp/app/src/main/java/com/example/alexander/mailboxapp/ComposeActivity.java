package com.example.alexander.mailboxapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ComposeActivity extends AppCompatActivity {
    public String sUsername;
    public String sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compose);

        // Get username and password
        sUsername = getIntent().getStringExtra("username");
        sPassword = getIntent().getStringExtra("password");

    } // End onCreate

    public void sendMail(View view) {
        // Flow: Step 9: Send email
        // TODO API Calls

    } // End sendMail

    public void toInbox(View view) {

        Button btnGoToCompose = (Button) findViewById(R.id.back_to_inbox);
        btnGoToCompose.setTextColor(1);
        Intent newIntent = new Intent(ComposeActivity.this, InboxActivity.class);

        newIntent.putExtra("username",sUsername);
        newIntent.putExtra("password",sPassword);
        startActivity(newIntent);
    } // End toInbox

} // End Compose Activity
