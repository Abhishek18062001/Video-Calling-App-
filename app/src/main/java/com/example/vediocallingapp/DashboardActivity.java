package com.example.vediocallingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class DashboardActivity extends AppCompatActivity {
    EditText code;
    Button joinbtn,sharebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        code=findViewById(R.id.code);
        joinbtn=findViewById(R.id.joinbtn);
        sharebtn=findViewById(R.id.sharebtn);

        URL serverurl;

        try {
            serverurl=new URL("https://meet.jit.si");
            JitsiMeetConferenceOptions deafaultoption=
                    new JitsiMeetConferenceOptions.Builder()
                            .setServerURL(serverurl)
                            .setWelcomePageEnabled(false)
                            .build();
            JitsiMeet.setDefaultConferenceOptions(deafaultoption);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JitsiMeetConferenceOptions  options=new JitsiMeetConferenceOptions.Builder()
                        .setRoom(code.getText().toString())
                        .setWelcomePageEnabled(false)
                        .build();
                JitsiMeetActivity.launch(DashboardActivity.this,options);

            }
        });
    }
}