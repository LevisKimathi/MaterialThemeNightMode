package com.example.levis.materialthemenightmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {
    private Button button1;
    private SQLiteTheme db2;
    private String themeid = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(Themes.getTheme(Integer.parseInt(themeid)));
        setContentView(R.layout.activity_login);

        db2 = new SQLiteTheme(getApplicationContext());

        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db2.addUsertheme(LoginActivity.this,themeid);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
