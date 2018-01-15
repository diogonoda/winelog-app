package br.com.dnoda.winelog_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        load();
    }

    private void load(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_animation);
        anim.reset();

        ImageView imageView = (ImageView) findViewById(R.id.splash);

        if(imageView != null){
            imageView.clearAnimation();
            imageView.startAnimation(anim);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                startActivity(intent);

                SplashScreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
