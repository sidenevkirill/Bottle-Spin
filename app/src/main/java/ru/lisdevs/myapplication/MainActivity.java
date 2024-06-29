package ru.lisdevs.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import ru.lisdevs.myapplication.Level.Level1;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(Build.VERSION.SDK_INT >= 19)
        {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

    }

    public void onList(View v) {
        Intent intent = new Intent(this, Level1.class);
        startActivityForResult(intent, 1);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    public void onInfo(View v) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivityForResult(intent, 2);

    }

    public void onBottle(View v) {
        Intent intent = new Intent(this, LevelActivity.class);
        startActivityForResult(intent, 3);

    }

    public void onBackPressed(View v) {
        //эмулируем нажатие на HOME, сворачивая приложение
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

}

