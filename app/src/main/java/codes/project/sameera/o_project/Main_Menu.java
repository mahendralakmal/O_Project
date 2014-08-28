package codes.project.sameera.o_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by Samy on 8/26/2014.
 */
public class Main_Menu extends Activity implements View.OnClickListener {
    Button buttonAdd,buttonPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        buttonAdd=(Button) findViewById(R.id.buttonAdd);
        buttonPay=(Button) findViewById(R.id.buttonPay);
        buttonAdd.setOnClickListener(this);
        buttonPay.setOnClickListener(this);

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonAdd:
                Intent i = new Intent(this,Main_Student_detail.class);
                startActivity(i);
                break;
            case R.id.buttonPay:
                Intent i2 = new Intent(this,Group_AddStudent_details.class);
                startActivity(i2);
                break;
            default:
                break;
        }
    }
}
