package com.example.ppp.pdudebugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PPP on 08/02/2015.
 */
public class SmsReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        try {
            final Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                //MainActivity.printPdu(pdus);
                StringBuilder sb = new StringBuilder();
                for (Object pdu : pdus) {
                    byte smsPdu[] = (byte[]) pdu;

                    for(int xx = 0; xx < smsPdu.length;xx++) {
                        String test = Integer.toHexString(smsPdu[xx] & 0xff);
                        if (test.length() <= 1){test = "0"+test;}
                        sb.append(test);
                    }MainActivity.printPdu(sb.toString());
            }

        }
        }catch (Exception e) {
            Log.e("SmsReceiver", "Error Type" + e);
        }
    }

}
