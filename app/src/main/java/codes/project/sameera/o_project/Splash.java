package codes.project.sameera.o_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by sameera on 8/28/14.
 */
public class Splash extends Activity {


    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this,Login.class);
                Splash.this.startActivity(i);
                Splash.this.finish();
            }
        },SPLASH_DISPLAY_LENGTH);
    }
}
