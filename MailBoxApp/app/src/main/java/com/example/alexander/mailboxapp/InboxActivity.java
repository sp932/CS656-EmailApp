package com.example.alexander.mailboxapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
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

        //emailsAdapter.add("I added this one");

        inBox.setAdapter(emailsAdapter);
    } // End onCreate

    public ArrayList populateEmail() {
        // Obviously this will work through an API Call
        ArrayList<String> emailList = new ArrayList<String>();
        ;
        emailList.add("Weclome to CS 656");
        emailList.add("Welcome to Group 1");
        emailList.add("Used Arraylist");

        return emailList;
    } // End populate email
} // End Inbox Activity
