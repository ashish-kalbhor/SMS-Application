package com.sms.sms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Vibrator;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.content.Context;
import android.os.Bundle;
import android.app.Activity;

public class SMS extends AppCompatActivity {

    private Context context = null;
    SmsManager smsmgr = null;
    Vibrator vibe = null;
    private EditText cNumber;
    private EditText textMsgContent = null;
    Button btnSend = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        context = getApplicationContext();

        cNumber = (EditText) findViewById(R.id.etPhoneNo);
        textMsgContent = (EditText)findViewById((R.id.etSmsText));

        // context = context; Why this?
        smsmgr = SmsManager.getDefault();
        vibe = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        btnSend = (Button)findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(context, "SMS Wishes Sent to " + cNumber + "..!!", Toast.LENGTH_SHORT).show();
                smsmgr.sendTextMessage(cNumber.toString(), null, textMsgContent.toString(), null,
                        null);
                // SMS sent to contact number passed as Argument
                vibe.vibrate(1000);
            }
        });

        setContentView(R.layout.activity_sms);
    }


}
