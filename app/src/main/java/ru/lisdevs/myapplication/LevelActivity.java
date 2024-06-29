package ru.lisdevs.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import ru.lisdevs.myapplication.Level.Level1;
import ru.lisdevs.myapplication.Level.Level2;
import ru.lisdevs.myapplication.Level.Level3;
import ru.lisdevs.myapplication.Level.Level4;
import ru.lisdevs.myapplication.Level.Level5;
import ru.lisdevs.myapplication.Level.Level6;


public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(Build.VERSION.SDK_INT >= 19)
        {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

    }

    public void onBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 0);

    }

    public void onOne(View v) {
        Intent intent = new Intent(this, Level1.class);
        startActivityForResult(intent, 1);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    public void onTo(View v) {
        Intent intent = new Intent(this, Level2.class);
        startActivityForResult(intent, 2);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    public void onFree(View v) {
        Intent intent = new Intent(this, Level3.class);
        startActivityForResult(intent, 3);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    public void onFo(View v) {
        Intent intent = new Intent(this, Level4.class);
        startActivityForResult(intent, 4);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    public void onFive(View v) {
        Intent intent = new Intent(this, Level5.class);
        startActivityForResult(intent, 5);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    public void onSix(View v) {
        Intent intent = new Intent(this, Level6.class);
        startActivityForResult(intent, 6);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

}

