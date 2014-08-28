package codes.project.sameera.o_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case 1:
                Intent i = new Intent(this,Group_AddStudent_details.class);
                break;
            case 2:
                break;
            default:
                break;
        }
    }
}
