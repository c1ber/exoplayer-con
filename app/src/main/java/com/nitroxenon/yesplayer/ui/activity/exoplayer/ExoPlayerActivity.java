package com.nitroxenon.yesplayer.ui.activity.exoplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.nitroxenon.yesplayer.R;

import java.util.Iterator;
import java.util.Set;

public class ExoPlayerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dumpIntent("terrafuck",getIntent());
        ((TextView)findViewById(R.id.tvLink)).setText(getIntent().getDataString());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        dumpIntent("terrafuck",intent);
        ((TextView)findViewById(R.id.tvLink)).setText(getIntent().getDataString());
    }

    public static void dumpIntent(String tag, Intent i) {
        tag = "dumpIntent:" + tag;
        if (i == null) return;
        Log.e(tag, "Dumping Intent start");
        Log.e(tag, "action:" + i.getAction());
        Log.e(tag, "data:" + i.getDataString());

        Bundle bundle = i.getExtras();
        if (bundle != null) {
            Set<String> keys = bundle.keySet();
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) {
                String key = it.next();
                Log.e(tag, "[" + key + "=" + bundle.get(key) + "]" + ":" + bundle.get(key).getClass().toString());
            }
        }
        Log.e(tag, "Dumping Intent end");
    }
}
