package com.example.levis.materialthemenightmode;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Switch;

import java.util.HashMap;

public class MainActivity extends Activity {
    private SQLiteTheme db2;
    private Switch button;
    private String themeid;
    private String themenumber = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db2 = new SQLiteTheme(getApplicationContext());
        HashMap<String, String> user2 = db2.getUserTheme();
        themeid = user2.get("userthemeid");
        setTheme(Themes.getTheme(Integer.parseInt(themeid)));

        setContentView(R.layout.activity_main);

        if (themeid.equals(themenumber)) {
            Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(),R.mipmap.ic_launcher);
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription("MaterialThemeNightMode",bitmap, ContextCompat.getColor(MainActivity.this, R.color.colorPrimary2));
            MainActivity.this.setTaskDescription(taskDescription);
        }else {
            Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(),R.mipmap.ic_launcher);
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription("MaterialThemeNightMode",bitmap, ContextCompat.getColor(MainActivity.this, R.color.colorPrimary1));
            MainActivity.this.setTaskDescription(taskDescription);
        }

        button = (Switch) findViewById(R.id.switch1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (themeid.equals(themenumber)){
                    db2.deleteUsertheme();
                    String themeid2 = "1";
                    db2.addUsertheme(MainActivity.this,themeid2);
                    recreate();
                }else {
                    db2.deleteUsertheme();
                    String themeid3 = "0";
                    db2.addUsertheme(MainActivity.this,themeid3);
                    recreate();
                }
            }
        });
    }

}
