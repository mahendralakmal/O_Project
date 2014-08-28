package codes.project.sameera.o_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

/**
 * Created by sameera on 8/28/14.
 */
public class Main_Student_detail extends Activity implements View.OnClickListener {
    Button Gbtn,Ibtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_student_detail);
        Gbtn = (Button) findViewById(R.id.btn1);
        Ibtn = (Button) findViewById(R.id.btn2);
        Gbtn.setOnClickListener(this);
        Ibtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                Intent i = new Intent(Main_Student_detail.this,Group_AddStudent_details.class);
                startActivity(i);
                break;
            case R.id.btn2:
                Intent i2 = new Intent(Main_Student_detail.this,Indi_AddStudentDetail.class);
                startActivity(i2);
            break;
            default:

                break;
        }
    }
}
