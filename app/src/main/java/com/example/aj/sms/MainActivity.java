package com.example.aj.sms;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//Context provides information about the Actvity or Application to newly created components.
//getApplicationContext() - Returns the context for all activities running in application.
  //      getContext() - Returns the context view only current running activity.
//Activity is a subclass of Context


//A PendingIntent is a token that you give to a foreign application (e.g. NotificationManager,
// AlarmManager,
// Home Screen AppWidgetManager, or other 3rd party applications), which allows the foreign
// application to use
// your application's permissions to execute a predefined piece of code.
public class MainActivity extends AppCompatActivity {
    EditText mobileno,message;
    Button sendsms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileno=(EditText)findViewById(R.id.editText1);
        message=(EditText)findViewById(R.id.editText2);
        sendsms=(Button)findViewById(R.id.button1);

        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no=mobileno.getText().toString();
                String msg=message.getText().toString();

                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);

                SmsManager sms= SmsManager.getDefault();
                sms.sendTextMessage(no, null, msg, pi,null);

                Toast.makeText(getApplicationContext(), "Message Sent successfully!", Toast.LENGTH_LONG).show();
        }
        });
    }
}
