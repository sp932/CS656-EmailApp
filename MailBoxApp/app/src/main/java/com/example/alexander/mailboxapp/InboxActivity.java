package com.example.alexander.mailboxapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class InboxActivity extends AppCompatActivity {
    public String sUsername;
    public String sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Flow: Step 5: Match InboxActivity to inbox.xml
        setContentView(R.layout.inbox);

        // Flow: Step 6: Get username and password from
        // Flow: 4b
        sUsername = getIntent().getStringExtra("username");
        sPassword = getIntent().getStringExtra("password");

        // Get listview object
        ListView inBox = (ListView) findViewById(R.id.messages);

        // Get an array adapter we can manipulate programatically
        String[] emailArray = new String[]{"Weclome to CS 656", "Welcome to Group 1"};

        ArrayList<String> emailList = populateEmail(); // This method will be heavily fleshed out
        ArrayAdapter<String> emailsAdapter =
                new ArrayAdapter<String>(this, R.layout.list_item2, R.id.list_text, emailList);


        inBox.setAdapter(emailsAdapter);

        // Flow: Step 6: Make inBox clickable and handle click events

        class ClickHandler implements AdapterView.OnItemClickListener {
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
                TextView emailItem = (TextView) view.findViewById(R.id.list_text);
                String emailItemText = emailItem.getText().toString();


                Intent newIntent = new Intent(InboxActivity.this, ReadActivity.class);

                // Flow: Step 7: Open ReadActivity and pass information to it
                newIntent.putExtra("username",sUsername);
                newIntent.putExtra("password",sPassword);
                newIntent.putExtra("emailItemText",emailItemText);
                startActivity(newIntent);

            }
        } // End inner-Class ClickHandler

        inBox.setOnItemClickListener(new ClickHandler());

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

        // Flow: Step 8: Open Compose activity and pass information to it
        Button btnGoToCompose = (Button) findViewById(R.id.to_compose);
        btnGoToCompose.setTextColor(1);
        Intent newIntent = new Intent(InboxActivity.this, ComposeActivity.class);

        newIntent.putExtra("username",sUsername);
        newIntent.putExtra("password",sPassword);
        startActivity(newIntent);
    } // End toCompose

    public void toRead(View view) {
        // TODO
        // API Calls and whatnot

//        Button btnGoToRead = (Button) findViewById(R.id.text1);
//        btnGoToRead.setTextColor(1);
//        Intent newIntent = new Intent(InboxActivity.this, ReadActivity.class);

//        newIntent.putExtra("username",sUsername);
//        newIntent.putExtra("password",sPassword);
//        startActivity(newIntent);
    } // End toCompose

    public void Quit(View View) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    } // End Quit

} // End Inbox Activity
