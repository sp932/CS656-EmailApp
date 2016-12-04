package com.example.alexander.mailboxapp;

import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ComposeActivity extends AppCompatActivity {
    public String sUsername;
    public String sPassword;
    public static Properties mailServerInfo;
    public static javax.mail.Session mailSession;
    public static MimeMessage emailMessage;
    public Transport transport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compose);

        // Get username and password
        sUsername = getIntent().getStringExtra("username");
        sPassword = getIntent().getStringExtra("password");

        // Check that Credentials made it through the system
        Log.v("Username", sUsername);
        Log.v("Password", sPassword);

    } // End onCreate

    public void sendMail(View view) throws MessagingException {
        // Flow: Step 9: Send email

        Log.v("Sending Message", "sendMail Called");

        mailServerInfo = System.getProperties();
        mailServerInfo.put("mail.smtp.port", "587");
        mailServerInfo.put("mail.smtp.auth", "true");
        mailServerInfo.put("mail.smtp.starttls.enable", "true");

        Log.v("Mailserver", "Properties set");

        mailSession = Session.getDefaultInstance(mailServerInfo, null);
        emailMessage = new MimeMessage(mailSession);
        try {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("aplevchuk@gmail.com"));
        } catch (MessagingException e) {
            Log.v("Message info", "Invalid Address");
        }
        try {
            emailMessage.setSubject("Test Email");
        } catch (MessagingException e) {
            Log.v("Message info", "Bad subject");
        }
        String emailBody = "Test email" + "<br><br> From, <br>Alex";
        try {
            emailMessage.setContent(emailBody, "text/html");
        } catch (MessagingException e) {
            Log.v("Message info", "Bad body");
        }
        Log.v("Message info", "Finished message");

        try {
            transport = mailSession.getTransport("smtp");
        } catch (NoSuchProviderException e) {
            Log.v("Initiating transport", "FAILED");
        }

        transport.connect("smtp.gmail.com", sUsername, sPassword);
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();

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
