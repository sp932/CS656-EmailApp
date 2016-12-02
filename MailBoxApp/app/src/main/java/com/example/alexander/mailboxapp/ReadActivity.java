package com.example.alexander.mailboxapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class ReadActivity extends AppCompatActivity {
    public String sUsername;
    public String sPassword;
    public String sItemText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read);

        sUsername = getIntent().getStringExtra("username");
        sPassword = getIntent().getStringExtra("password");
        sItemText = getIntent().getStringExtra("emailItemText");
        Log.v("ReadActivity", sItemText);

    }

    public void toInbox(View view) {

        Button btnGoToCompose = (Button) findViewById(R.id.back_to_inbox);
        btnGoToCompose.setTextColor(1);
        Intent newIntent = new Intent(ReadActivity.this, InboxActivity.class);

        newIntent.putExtra("username",sUsername);
        newIntent.putExtra("password",sPassword);
        startActivity(newIntent);
    } // End toInbox

}
