package ru.lisdevs.myapplication.Level;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import ru.lisdevs.myapplication.CoolActivity;
import ru.lisdevs.myapplication.LevelActivity;
import ru.lisdevs.myapplication.MainActivity;
import ru.lisdevs.myapplication.R;

public class Level4 extends AppCompatActivity {

    public static final Random sRandom = new Random();
    private ImageView mBottleImageView;
    private int lastAngle = -1;

    Animation smalltobig;

    LinearLayout b1;
    LinearLayout b2;
    ImageView iv;
    TextView tx;
    boolean flag;
    int images[]={R.drawable.bottle4,R.drawable.botle2,R.drawable.bottle2, R.drawable.botle, R.drawable.bottle5, R.drawable.bottle6};
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lavel4);

        Thread mySplash = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(50000);
                    Intent i = new Intent(getApplicationContext(), CoolActivity.class);
                    startActivity(i);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        mySplash.start();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(Build.VERSION.SDK_INT >= 19)
        {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

        mBottleImageView = (ImageView) findViewById(R.id.gameover);

        mBottleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinBottle();
            }
        });

        iv=(ImageView) findViewById(R.id.gameover);
        b1=(LinearLayout) findViewById(R.id.bottle);
        b2=(LinearLayout) findViewById(R.id.flipbottle);
        tx=(TextView) findViewById(R.id.text);

        flag=true;

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setImageResource(images[i]);
                i++;
                if(i==6)
                    i=0;
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int theSpinDegrees;

                Random r = new Random();

                theSpinDegrees = r.nextInt(3600);

                RotateAnimation rotateBottle = new RotateAnimation(0, theSpinDegrees,
                        Animation.RELATIVE_TO_SELF,0.5f,
                        Animation.RELATIVE_TO_SELF,0.5f
                );

                rotateBottle.setDuration(2000);
                rotateBottle.setFillAfter(true);

                rotateBottle.setInterpolator(new AccelerateDecelerateInterpolator());

                rotateBottle.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (theSpinDegrees % 360 > 180){
                            // left has been chosen
                            Toast.makeText(Level4.this, "Пройдите на 5 секунд с человеком справа от вас", Toast.LENGTH_SHORT).show ();
                        } else {
                            //the right has been chosen
                            Toast.makeText(Level4.this, "Передайте ход другому", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                mBottleImageView.startAnimation(rotateBottle);



            }
        });

    }

    private void spinBottle() {
        int angle = sRandom.nextInt(3600 - 360) + 360;
        // Центр вращения
        float pivotX = mBottleImageView.getWidth() / 2;
        float pivotY = mBottleImageView.getHeight() / 2;

        final Animation animation = new RotateAnimation(lastAngle == -1 ? 0 : lastAngle, angle, pivotX, pivotY);
        lastAngle = angle;
        animation.setDuration(2500);
        animation.setFillAfter(true);

        mBottleImageView.startAnimation(animation);
    }

    public void onBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 1);

    }

    public void onList(View v) {
        Intent intent = new Intent(this, LevelActivity.class);
        startActivityForResult(intent, 1);

    }

    public void onBackPressed(View v) {
        //эмулируем нажатие на HOME, сворачивая приложение
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

}
