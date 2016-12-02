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
        // Get information
//        EditText etRecipient = (EditText) findViewById(R.id.recipient);
//        EditText etSubject = (EditText) findViewById(R.id.subject);
//        EditText etBody = (EditText) findViewById(R.id.body);

        // Main logic - Need to implement send either through API
        // or SMTP

        // Clear fields if successful
//        etRecipient.setText("");
//        etSubject.setText("");
//        etBody.setText("");

    } // End sendMail

    public void toInbox(View view) {
        // TODO
        // API Calls and whatnot

        Button btnGoToCompose = (Button) findViewById(R.id.back_to_inbox);
        btnGoToCompose.setTextColor(1);
        Intent newIntent = new Intent(ComposeActivity.this, InboxActivity.class);

        newIntent.putExtra("username",sUsername);
        newIntent.putExtra("password",sPassword);
        startActivity(newIntent);
    } // End toInbox

} // End Compose Activity
