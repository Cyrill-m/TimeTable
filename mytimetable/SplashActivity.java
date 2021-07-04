package by.mkstudio.mytimetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash);

        Intent i = new Intent(SplashActivity.this, WDListActivity.class);
        startActivity(i);
        finish();
    }
}