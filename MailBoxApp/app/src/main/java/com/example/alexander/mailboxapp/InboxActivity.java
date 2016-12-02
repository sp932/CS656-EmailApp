package com.example.alexander.mailboxapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InboxActivity extends AppCompatActivity {
    public String sUsername;
    public String sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inbox);

        sUsername = getIntent().getStringExtra("username");
        sPassword = getIntent().getStringExtra("password");

        // Get listview object
        ListView inBox = (ListView) findViewById(R.id.messages);

        // Get an array adapter we can manipulate programatically
        String[] emailArray = new String[]{"Weclome to CS 656", "Welcome to Group 1"};

        ArrayList<String> emailList = populateEmail(); // This method will be heavily fleshed out
        ArrayAdapter<String> emailsAdapter =
                new ArrayAdapter<String>(this, R.layout.list_item, emailList);


        inBox.setAdapter(emailsAdapter);
    } // End onCreate

    public ArrayList populateEmail() {
        // Obviously this will work through an API Call

        // Main logic - Need to implement receive either through API
        // or SMTP

        // Dummy code
        ArrayList<String> emailList = new ArrayList<String>();
        emailList.add("Weclome to CS 656");
        emailList.add("Welcome to Group 1");
        emailList.add("Used Arraylist");
        emailList.add("Populated manually, switch to API");

        return emailList;
    } // End populate email

    public void toCompose(View view) {
        // TODO
        // API Calls and whatnot

        Button btnGoToCompose = (Button) findViewById(R.id.to_compose);
        btnGoToCompose.setTextColor(1);
        Intent newIntent = new Intent(InboxActivity.this, ComposeActivity.class);

        newIntent.putExtra("username",sUsername);
        newIntent.putExtra("password",sPassword);
        startActivity(newIntent);
    } // End toCompose

    public void Quit(View View) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    } // End Quit

} // End Inbox Activity
