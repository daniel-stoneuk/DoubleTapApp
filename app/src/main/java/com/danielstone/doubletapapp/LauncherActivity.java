package com.danielstone.doubletapapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i("test", "onCreate: getIntent().getAction()" + getIntent().getAction());

        if (getIntent().getAction().contains("android.media.action.STILL_IMAGE_CAMERA")) {
            PackageManager manager = this.getPackageManager();
            try {

                Intent i = manager.getLaunchIntentForPackage("com.danielstone.energyhive");
                if (i == null) {
                    throw new PackageManager.NameNotFoundException();
                }
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(i);
                finish();

            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
