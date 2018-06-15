package events.tcs.com.events.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import events.tcs.com.events.R;
import events.tcs.com.events.constant.ApplicationData;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        RelativeLayout relativeViewSplash = (RelativeLayout) findViewById(R.id.rv_splash);
        Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        relativeViewSplash.startAnimation(animationFadeIn);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, ApplicationData.SPLASH_TIME_OUT);
    }
}
